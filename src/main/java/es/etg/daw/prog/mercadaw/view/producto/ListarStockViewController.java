package es.etg.daw.prog.mercadaw.view.producto;

import es.etg.daw.prog.mercadaw.controller.MercaDAWController;
import es.etg.daw.prog.mercadaw.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class ListarStockViewController extends ViewController {
    private MercaDAWController controller = new MercaDAWController();

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
    private TableColumn<?, ?> colCategoria;

    @FXML
    private TableColumn<?, ?> colCodigo;

    @FXML
    private TableColumn<?, ?> colMarca;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private TableColumn<?, ?> colPrecio;

    @FXML
    private TableColumn<?, ?> colStock;

    @FXML
    private TableView<?> tabStock;

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

}
