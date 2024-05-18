package es.etg.daw.prog.mercadaw.view.empleado;

import es.etg.daw.prog.mercadaw.controller.MercaDAWController;
import es.etg.daw.prog.mercadaw.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class DarAltaEmpleadoViewController extends ViewController {
    private MercaDAWController controller = new MercaDAWController();

    @FXML
    private Button btnAñadir;

    @FXML
    private Button btnCalcularNomina;

    @FXML
    private Button btnConsultarDatos;

    @FXML
    private Button btnDarAltaEmple;

    @FXML
    private Button btnSalir;

    @FXML
    private ChoiceBox<?> choiceCategoria;

    @FXML
    private TextField txfApellido;

    @FXML
    private TextField txfNombre;

    @FXML
    void accesoCalcularNomina(MouseEvent event) {
        controller.cargarNomina();
    }

    @FXML
    void accesoConsultarDatos(MouseEvent event) {
        controller.cargarListarEmpleados();
    }

    @FXML
    void accesoDarAltaEmple(MouseEvent event) {
        controller.cargarEmpleados();
    }

    @FXML
    void addEmpleado(MouseEvent event) {

    }

    @FXML
    void salir(MouseEvent event) {
        controller.cargarApp();
    }

}
