package es.etg.daw.prog.mercadaw.view.compra;

import es.etg.daw.prog.mercadaw.controller.MercaDAWController;
import es.etg.daw.prog.mercadaw.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class DarAltaCompraViewController extends ViewController {
    private MercaDAWController controller = new MercaDAWController();

    @FXML
    private Button btnAñadir;

    @FXML
    private Button btnConsultarDatos;

    @FXML
    private Button btnDarAltaComp;

    @FXML
    private Button btnSalir;

    @FXML
    private TableColumn<?, ?> colCodigoCli;

    @FXML
    private TableColumn<?, ?> colCodigoProd;

    @FXML
    private TableColumn<?, ?> colCorreoCli;

    @FXML
    private TableColumn<?, ?> colNombreCli;

    @FXML
    private TableColumn<?, ?> colNombreProd;

    @FXML
    private TableColumn<?, ?> colPostCli;

    @FXML
    private TableColumn<?, ?> colPrecioProd;

    @FXML
    private TableColumn<?, ?> colStockProd;

    @FXML
    private TableView<?> tabCliente;

    @FXML
    private TableView<?> tabProducto;

    @FXML
    void accesoConsultarDatos(MouseEvent event) {
        controller.cargarListarCompras();
    }

    @FXML
    void accesoDarAltaComp(MouseEvent event) {
        controller.cargarCompras();
    }

    @FXML
    void addCompra(MouseEvent event) {
        
    }

    @FXML
    void salir(MouseEvent event) {
        controller.cargarApp();
    }

}
