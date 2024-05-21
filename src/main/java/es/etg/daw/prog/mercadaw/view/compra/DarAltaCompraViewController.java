package es.etg.daw.prog.mercadaw.view.compra;

import java.net.URL;
import java.util.ResourceBundle;

import es.etg.daw.prog.mercadaw.model.entities.compras.Cliente;
import es.etg.daw.prog.mercadaw.model.entities.compras.Compra;
import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;
import es.etg.daw.prog.mercadaw.view.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class DarAltaCompraViewController extends ViewController implements Initializable {
    private ObservableList<Compra> compras;


    @FXML
    private Button btnAnadirCompra;

    @FXML
    private Button btnAnadirProducto;

    @FXML
    private Button btnGestionClientes;

    @FXML
    private Button btnSalir;

    @FXML
    private TableColumn<?, ?> colCodigoCli;

    @FXML
    private TableColumn<?, ?> colCodigoComp;

    @FXML
    private TableColumn<?, ?> colCodigoProd;

    @FXML
    private TableColumn<?, ?> colCodigoProdCompra;

    @FXML
    private TableColumn<?, ?> colFecha;

    @FXML
    private TableColumn<?, ?> colNombCli;

    @FXML
    private TableColumn<?, ?> colNombProd;

    @FXML
    private TableColumn<?, ?> colNombProdCompra;

    @FXML
    private TableColumn<?, ?> colPrecioProd;

    @FXML
    private TableView<?> tabCompras;

    @FXML
    private TableView<?> tabProductos;

    @FXML
    private TextField txfCodCliente;

    @FXML
    void accesoDarAltaClientes(MouseEvent event) {
        controller.cargarClientes();
    }

    @FXML
    void addCompra(MouseEvent event) {

    }

    @FXML
    void addProducto(MouseEvent event) {

    }

    @FXML
    void seleccionarProducto(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        iniciarTabla();
    }

    public void iniciarTabla(){
        compras = FXCollections.observableArrayList();

        this.colCodigoCli.setCellValueFactory(new PropertyValueFactory<>(Compra.ATT_ID_COMP));
        this.colCodigoCli.setCellValueFactory(new PropertyValueFactory<>(Cliente.ATT_ID_CLI));
        this.colNombCli.setCellValueFactory(new PropertyValueFactory<>(Cliente.ATT_NOMB_CLI));
        this.colCodigoProdCompra.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_ID));
        this.colNombProdCompra.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_NOMBRE));
        this.colFecha.setCellValueFactory(new PropertyValueFactory<>(Compra.ATT_FECH_COMP));

        this.colCodigoProd.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_ID));
        this.colNombProd.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_NOMBRE));
        this.colPrecioProd.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_PRECIO));

    }
}
