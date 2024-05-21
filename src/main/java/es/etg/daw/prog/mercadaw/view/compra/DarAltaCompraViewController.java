package es.etg.daw.prog.mercadaw.view.compra;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import es.etg.daw.prog.mercadaw.model.entities.compras.Cliente;
import es.etg.daw.prog.mercadaw.model.entities.compras.Compra;
import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;
import es.etg.daw.prog.mercadaw.view.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class DarAltaCompraViewController extends ViewController implements Initializable {
    
    private ObservableList<Compra> compras;
    private ObservableList<Producto> productos;


    @FXML
    private Button btnAnadirCompra;

    @FXML
    private Button btnAnadirProducto;

    @FXML
    private Button btnGestionClientes;

    @FXML
    private Button btnSalir;

    @FXML
    private TableColumn<Cliente, Integer> colCodigoCli;

    @FXML
    private TableColumn<Compra, Integer> colCodigoComp;

    @FXML
    private TableColumn<Producto, Integer> colCodigoProd;

    @FXML
    private TableColumn<Compra, Integer> colCodigoProdCompra;

    @FXML
    private TableColumn<Compra, Date> colFecha;

    @FXML
    private TableColumn<Producto, String> colNombProd;

    @FXML
    private TableColumn<Producto, Double> colPrecioProd;

    @FXML
    private TableView<Compra> tabCompras;

    @FXML
    private TableView<Producto> tabProductos;

    @FXML
    private TextField txfCodCliente;

    List<Producto> prods = new ArrayList<>();


    @FXML
    void accesoDarAltaClientes(MouseEvent event) {
        controller.cargarClientes();
    }

    @FXML
    void addCompra(MouseEvent event) throws MercaDAWException {
        try {

            int id = Integer.parseInt(txfCodCliente.getText());
            Date fecha = Date.valueOf(LocalDate.now());
            Cliente cliente = controller.visualizarCliente(id);

            Compra compra = new Compra(null, fecha, cliente, prods);
            
            List<Compra> compraBD = controller.darAlta(compra);


            if (compras.contains(compra)) {
                mostrarAviso(MSG_ERROR, AlertType.ERROR);
            } else {
                insertarCompras(compraBD);
            }

        } catch (NumberFormatException e) {
            mostrarAviso(MSG_ERROR, AlertType.ERROR);
        }
    }

    @FXML
    void addProducto(MouseEvent event) {
        Producto producto = this.tabProductos.getSelectionModel().getSelectedItem();
        prods.add(producto);
    }

    @FXML
    void seleccionarProducto(MouseEvent event) {
        Producto producto = this.tabProductos.getSelectionModel().getSelectedItem();

        if(producto == null){
            //TODO MENSAJE ERROR
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        iniciarTablaCompras();
        iniciarTablaProductos();
        try {
            insertarProductos(controller.cargarTablaProducto());
            insertarCompras(controller.cargarTablaCompra());

        } catch (Exception e) {
            //TODO: MENSAJE ERROR (CARGA INICAL DE LA TABLA FALLIDA)
        }
    }
    public void insertarProductos(List<Producto> products){
        this.productos.setAll(products);
        this.tabProductos.setItems(productos);
    }
    public void insertarCompras(List<Compra> comprs){
        this.compras.setAll(comprs);
        this.tabCompras.setItems(compras);
    }

    public void iniciarTablaCompras(){
        compras = FXCollections.observableArrayList();

        this.colCodigoComp.setCellValueFactory(new PropertyValueFactory<>(Compra.ATT_ID_COMP));
        this.colCodigoCli.setCellValueFactory(new PropertyValueFactory<>(Cliente.ATT_ID_CLI));
        this.colCodigoProdCompra.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_ID));
        this.colFecha.setCellValueFactory(new PropertyValueFactory<>(Compra.ATT_FECH_COMP));

    }

    public void iniciarTablaProductos(){
        productos = FXCollections.observableArrayList();

        this.colCodigoProd.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_ID));
        this.colNombProd.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_NOMBRE));
        this.colPrecioProd.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_PRECIO));
    }
}
