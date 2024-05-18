package es.etg.daw.prog.mercadaw.view.compra;

import es.etg.daw.prog.mercadaw.controller.MercaDAWController;
import es.etg.daw.prog.mercadaw.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class ListarCompraViewController extends ViewController {
    private MercaDAWController controller = new MercaDAWController();

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
    private TableColumn<?, ?> colFechaComp;

    @FXML
    private TableView<?> tabCompra;

    @FXML
    void accesoConsultarDatos(MouseEvent event) {
        controller.cargarListarCompras();
    }

    @FXML
    void accesoDarAltaComp(MouseEvent event) {
        controller.cargarCompras();
    }

    @FXML
    void salir(MouseEvent event) {
        controller.cargarApp();
    }

}
