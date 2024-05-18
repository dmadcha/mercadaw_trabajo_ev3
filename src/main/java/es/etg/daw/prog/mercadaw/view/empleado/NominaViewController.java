package es.etg.daw.prog.mercadaw.view.empleado;

import es.etg.daw.prog.mercadaw.controller.MercaDAWController;
import es.etg.daw.prog.mercadaw.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class NominaViewController extends ViewController {
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
    private TableColumn<?, ?> colAportacionSalarial;

    @FXML
    private TableColumn<?, ?> colCodigo;

    @FXML
    private TableColumn<?, ?> colIndemnizacion;

    @FXML
    private TableColumn<?, ?> colSalarioBruto;

    @FXML
    private TableColumn<?, ?> colSalarioNeto;

    @FXML
    private TableColumn<?, ?> colTotalCosteLaboral;

    @FXML
    private TableColumn<?, ?> colTotalNomina;

    @FXML
    private TableView<?> tabNomina;

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
