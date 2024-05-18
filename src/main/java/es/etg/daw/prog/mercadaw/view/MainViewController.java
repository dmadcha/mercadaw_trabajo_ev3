package es.etg.daw.prog.mercadaw.view;

import java.io.IOException;

import es.etg.daw.prog.mercadaw.controller.MercaDAWController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class MainViewController extends ViewController{
    private MercaDAWController controller = new MercaDAWController();

    @FXML
    private Button btnCompra;

    @FXML
    private Button btnEmpleado;

    @FXML
    private Button btnProducto;

    @FXML
    private Button btnSistema;

    @FXML
    void accesoGestionCompra(MouseEvent event) {
        controller.cargarCompras();
    }

    @FXML
    void accesoGestionEmpleado(MouseEvent event) {
        controller.cargarEmpleados();
    }

    @FXML
    void accesoGestionProducto(MouseEvent event) throws IOException {
        controller.cargarProductos();
    }

    @FXML
    void accesoGestionSistema(MouseEvent event) {
        controller.cargarImportar();
    }
}
