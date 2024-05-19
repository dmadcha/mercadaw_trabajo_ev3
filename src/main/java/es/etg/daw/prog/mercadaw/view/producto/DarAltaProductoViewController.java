package es.etg.daw.prog.mercadaw.view.producto;

import java.net.URL;
import java.util.ResourceBundle;

import es.etg.daw.prog.mercadaw.controller.MercaDAWController;
import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;
import es.etg.daw.prog.mercadaw.model.entities.productos.ProductoFactory;
import es.etg.daw.prog.mercadaw.model.entities.productos.TipoProducto;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;
import es.etg.daw.prog.mercadaw.view.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * Vista de dar alta producto.
 * \author Erik Herrera Llamas
 */
public class DarAltaProductoViewController extends ViewController implements Initializable {
    public static final String MSG_ERROR = "ERROR";
    private MercaDAWController controller = new MercaDAWController();
    private ObservableList<Producto> productos;

    @FXML
    private Button btnAñadirProd;

    @FXML
    private Button btnDarAltaProd;

    @FXML
    private Button btnObtenerPrecio;

    @FXML
    private Button btnSalir;

    @FXML
    private ChoiceBox<TipoProducto> choiceCategoria;

    @FXML
    private TableColumn<Producto, Double> colAltura;

    @FXML
    private TableColumn<Producto, Double> colAnchura;

    @FXML
    private TableColumn<Producto, String> colCategoria;

    @FXML
    private TableColumn<Producto, String> colMarca;

    @FXML
    private TableColumn<Producto, Integer> colCodigo;

    @FXML
    private TableColumn<Producto, String> colDesc;

    @FXML
    private TableColumn<Producto, Integer> colElementos;

    @FXML
    private TableColumn<Producto, Double> colIVA;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Producto, Double> colPeso;

    @FXML
    private TableColumn<Producto, Double> colPrecio;

    @FXML
    private TableColumn<Producto, Integer> colStock;

    @FXML
    private TableView<Producto> tabProductos;

    @FXML
    private TextArea txaDescripcion;

    @FXML
    private TextArea txaPrecioVenta;

    @FXML
    private TextField txfAltura;

    @FXML
    private TextField txfAnchura;

    @FXML
    private TextField txfElementos;

    @FXML
    private TextField txfIva;

    @FXML
    private TextField txfMarca;

    @FXML
    private TextField txfNombre;

    @FXML
    private TextField txfPeso;

    @FXML
    private TextField txfPrecio;

    @FXML
    void accesoDarAltaProd(MouseEvent event) {
        controller.cargarProductos();
    }

    @FXML
    public void iniciarTabla() {
        this.productos = FXCollections.observableArrayList();

        this.colCodigo.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_ID));
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_NOMBRE));
        this.colMarca.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_MARCA));
        this.colCategoria.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_CATEGORIA));
        this.colPrecio.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_PRECIO));
        //this.colIVA.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_IVA));
        this.colAltura.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_ALTURA));
        this.colAnchura.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_ANCHURA));
        this.colPeso.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_PESO));
        this.colElementos.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_ELEMENTOS));
        this.colDesc.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_DESCRIPCION) );
        this.colStock.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_STOCK));

        this.tabProductos.setItems(productos);
    }

    @FXML
    void addProducto(MouseEvent event) throws MercaDAWException {
        try {
            String nombre = txfNombre.getText();
            String marca = txfMarca.getText();
            String tipo = choiceCategoria.getValue().toString();
            double precio = Double.parseDouble(colPrecio.getText());
            //double iva = Double.parseDouble(txfIva.getText());
            double altura = Double.parseDouble(txfAltura.getText());
            double anchura = Double.parseDouble(txfAnchura.getText());
            double peso = Double.parseDouble(txfPeso.getText());
            int numElementos = Integer.parseInt(txfElementos.getText());
            String desc = txaDescripcion.getText();

            Producto producto = ProductoFactory.obtener(tipo, null, nombre, marca, altura, anchura, peso, numElementos, 0, precio, desc);
            if (this.productos.contains(producto)) {
                mostrarAviso(MSG_ERROR, AlertType.ERROR); 
            } else {
                this.productos.add(producto);
                this.tabProductos.refresh();
            }
        
        } catch (NumberFormatException e) {
            mostrarAviso(MSG_ERROR, AlertType.ERROR);
        }
    }

    @FXML
    void salir(MouseEvent event) {
        controller.cargarApp();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceCategoria.getItems().setAll(TipoProducto.values());
        iniciarTabla();
    }

    private void mostrarAviso(String msg, AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setHeaderText(null);
        alerta.setTitle(MSG_ERROR);
        alerta.setContentText(msg);
        alerta.showAndWait();
    }
}
