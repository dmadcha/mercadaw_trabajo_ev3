package es.etg.daw.prog.mercadaw.view.empleado;

import es.etg.daw.prog.mercadaw.controller.MercaDAWController;
import es.etg.daw.prog.mercadaw.view.ViewController;
import es.etg.daw.prog.mercadaw.model.entities.empleados.TipoEmpleado;
import es.etg.daw.prog.mercadaw.model.entities.empleados.Empleado;
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
    private TableColumn<Empleado, String> colApellidos;

    @FXML
    private TableColumn<Empleado, TipoEmpleado> colCategoria;

    @FXML
    private TableColumn<Empleado, Integer> colCodigo;

    @FXML
    private TableColumn<Empleado, String> colNombre;

    @FXML
    private TableColumn<Empleado, Double> colSueldo;

    @FXML
    private TableView<Empleado> tabEmpleado;


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
