package es.etg.daw.prog.mercadaw.view.empleado;

import es.etg.daw.prog.mercadaw.controller.MercaDAWController;
import es.etg.daw.prog.mercadaw.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class ListarEmpleadoViewController extends ViewController {
    private MercaDAWController controller = new MercaDAWController();

    @FXML
    private Button btnCalcularNomina;

    @FXML
    private Button btnConsultarDatos;

    @FXML
    private Button btnDarAltaEmple;

    @FXML
    private Button btnSalir;

    @FXML
    private TableColumn<?, ?> colApellidos;

    @FXML
    private TableColumn<?, ?> colCategoria;

    @FXML
    private TableColumn<?, ?> colCodigo;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private TableColumn<?, ?> colSueldo;

    @FXML
    private TableView<?> tabEmpleado;


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
    void salir(MouseEvent event) {
        controller.cargarApp();
    }

}
