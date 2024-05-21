package es.etg.daw.prog.mercadaw.view.producto;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;
import es.etg.daw.prog.mercadaw.model.entities.productos.ProductoFactory;
import es.etg.daw.prog.mercadaw.model.entities.productos.TipoProducto;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;
import es.etg.daw.prog.mercadaw.view.ViewController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private ObservableList<Producto> productos;

    @FXML
    private Button btnAnadirProd;

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
    private TextField txfStock;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceCategoria.getItems().setAll(TipoProducto.values());
        iniciarTabla();
        try {
            insertar(controller.cargarTablaProducto());
        } catch (Exception e) {
            //TODO: MENSAJE ERROR (CARGA INICAL DE LA TABLA FALLIDA)
        }
    }
    public void insertar(List<Producto> produts){
        this.productos.setAll(produts);
        this.tabProductos.setItems(productos);
    }

    @FXML
    public void iniciarTabla() {

        productos = FXCollections.observableArrayList();

        this.colCodigo.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_ID));
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_NOMBRE));
        this.colCategoria.setCellValueFactory(celda -> new SimpleStringProperty(celda.getValue().toString()));
        this.colMarca.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_MARCA));
        this.colPrecio.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_PRECIO));
        this.colIVA.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_IVA));
        this.colAltura.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_ALTURA));
        this.colAnchura.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_ANCHURA));
        this.colPeso.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_PESO));
        this.colElementos.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_ELEMENTOS));
        this.colStock.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_STOCK));
        this.colDesc.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_DESCRIPCION));
        

    }

    @FXML
    void addProducto(MouseEvent event) throws MercaDAWException{
        try {

            String nombre = txfNombre.getText();
            String marca = txfMarca.getText();
            String tipo = choiceCategoria.getValue().toString();
            Double precio = Double.parseDouble(txfPrecio.getText());
            int stock = Integer.parseInt(txfStock.getText());
            Double altura = Double.parseDouble(txfAltura.getText());
            Double anchura = Double.parseDouble(txfAnchura.getText());
            Double peso = Double.parseDouble(txfPeso.getText());
            int elemtos = Integer.parseInt(txfElementos.getText());
            String desc = txaDescripcion.getText();

            Producto producto = ProductoFactory.obtener(tipo, null, nombre, marca, altura, anchura, peso, elemtos, stock, precio, desc);
            
            List<Producto> productosDb = controller.darAlta(producto);


            if (productos.contains(producto)) {
                mostrarAviso(MSG_ERROR, AlertType.ERROR);
            } else {
                insertar(productosDb);
            }
        } catch (NumberFormatException e) {
            mostrarAviso(MSG_ERROR, AlertType.ERROR);
        }
    }

    @FXML
    void obtenerPrecioVenta(MouseEvent event) {
        Producto producto = this.tabProductos.getSelectionModel().getSelectedItem();
        String msg = controller.calcularPrecioVenta(producto);
        txaPrecioVenta.setText(msg);
    }

    @FXML
    void seleccionarProducto(MouseEvent event) {

        Producto producto = this.tabProductos.getSelectionModel().getSelectedItem();

        if(producto == null){
            //TODO MENSAJE ERROR
        }
    }
}
