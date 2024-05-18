package es.etg.daw.prog.mercadaw.view.producto;

import es.etg.daw.prog.mercadaw.controller.MercaDAWController;
import es.etg.daw.prog.mercadaw.view.ViewController;
import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;
import es.etg.daw.prog.mercadaw.model.entities.productos.TipoProducto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ListarStockViewController extends ViewController {
    private MercaDAWController controller = new MercaDAWController();
    private ObservableList<Producto> productos;

    @FXML
    private Button btnConsultarDatos;

    @FXML
    private Button btnDarAltaProd;

    @FXML
    private Button btnListarStock;

    @FXML
    private Button btnPrecioVenta;

    @FXML
    private Button btnSalir;

    @FXML
    private TableColumn<Producto, TipoProducto> colCategoria;

    @FXML
    private TableColumn<Producto, Integer> colCodigo;

    @FXML
    private TableColumn<Producto, String> colMarca;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Producto, Double> colPrecio;

    @FXML
    private TableColumn<Producto, Integer> colStock;

    @FXML
    private TableView<Producto> tabStock;

    @FXML
    void accesoConsultarDatos(MouseEvent event) {
        controller.cargarListarProductos();
    }

    @FXML
    void accesoDarAltaProd(MouseEvent event) {
        controller.cargarProductos();
    }

    @FXML
    void accesoListarStock(MouseEvent event) {
        controller.cargarListarStock();
    }

    @FXML
    void accesoPrecioVenta(MouseEvent event) {
        controller.cargarVentaProductos();
    }

    @FXML
    void salir(MouseEvent event) {
        controller.cargarApp();
    }

    @FXML
    public void inicializarTabla() {
        productos = FXCollections.observableArrayList();

        this.colCodigo.setCellFactory(new PropertyValueFactory<>());
        this.colNombre.setCellFactory(new PropertyValueFactory<>());
        this.colMarca.setCellFactory(new PropertyValueFactory<>());
        this.colCategoria.setCellFactory(new PropertyValueFactory<>());
        this.colPrecio.setCellFactory(new PropertyValueFactory<>());
        this.colStock.setCellFactory(new PropertyValueFactory<>());
    }
}
