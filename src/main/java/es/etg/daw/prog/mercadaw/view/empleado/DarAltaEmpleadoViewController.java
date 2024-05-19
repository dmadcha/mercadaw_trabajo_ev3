package es.etg.daw.prog.mercadaw.view.empleado;

import java.net.URL;
import java.util.ResourceBundle;

import es.etg.daw.prog.mercadaw.controller.MercaDAWController;
import es.etg.daw.prog.mercadaw.model.entities.empleados.Empleado;
import es.etg.daw.prog.mercadaw.model.entities.empleados.EmpleadoFactory;
import es.etg.daw.prog.mercadaw.model.entities.empleados.TipoEmpleado;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;
import es.etg.daw.prog.mercadaw.view.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class DarAltaEmpleadoViewController extends ViewController implements Initializable{
    public static final String MSG_ERROR = "ERROR";
    
    private MercaDAWController controller = new MercaDAWController();
    private ObservableList<Empleado> empleados;

    @FXML
    private Button btnAñadir;

    @FXML
    private Button btnDarAltaEmple;

    @FXML
    private Button btnSalir;

    @FXML
    private ChoiceBox<TipoEmpleado> choiceCategoria;

    @FXML
    private TableColumn<Empleado, String> colApellidos;

    @FXML
    private TableColumn<Empleado, Double> colAportacionSal;

    @FXML
    private TableColumn<Empleado, String> colCategoria;

    @FXML
    private TableColumn<Empleado, Integer> colCodigo;

    @FXML
    private TableColumn<Empleado, Double> colIndemnizacion;

    @FXML
    private TableColumn<Empleado, String> colNombre;

    @FXML
    private TableColumn<Empleado, Double> colSalBruto;

    @FXML
    private TableColumn<Empleado, Double>colSalNeto;

    @FXML
    private TableColumn<Empleado, Double> colSueldo;

    @FXML
    private TableColumn<Empleado, Double> colTotalCosteLab;

    @FXML
    private TableColumn<Empleado, Double> colTotalNomina;

    @FXML
    private TableView<Empleado> tabEmpleados;

    @FXML
    private TableView<Empleado> tabNomina;

    @FXML
    private TextField txfApellido;

    @FXML
    private TextField txfNombre;

    @FXML
    void accesoDarAltaEmple(MouseEvent event) {
        controller.cargarEmpleados();
    }

    @FXML
    public void iniciarTabla() {
        this.empleados = FXCollections.observableArrayList();

        this.colCodigo.setCellValueFactory(new PropertyValueFactory<>(Empleado.ATT_ID_EMPLE));
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>(Empleado.ATT_NOM_EMPLE));
        this.colApellidos.setCellValueFactory(new PropertyValueFactory<>(Empleado.ATT_APELLIDO));
        this.colCategoria.setCellValueFactory(new PropertyValueFactory<>(Empleado.ATT_CATEGORIA));
        this.colSueldo.setCellValueFactory(new PropertyValueFactory<>(Empleado.ATT_SUELDO));
        this.tabEmpleados.setItems(empleados);
    }

    @FXML
    void addEmpleado(MouseEvent event) throws MercaDAWException {
        try {
            String nombre = txfNombre.getText();
            String apellidos = txfApellido.getText();
            String tipo = choiceCategoria.getValue().toString();

            Empleado empleado = EmpleadoFactory.obtener(tipo, null, nombre, apellidos);
            if (this.empleados.contains(empleado)) {
                mostrarAviso(MSG_ERROR, AlertType.ERROR);
            } else {
                this.empleados.add(empleado);
                this.tabEmpleados.refresh();
            }
        } catch (NumberFormatException e) {
            mostrarAviso(MSG_ERROR, AlertType.ERROR);
        }
    }

    @FXML
    void salir(MouseEvent event) {
        controller.cargarApp();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceCategoria.getItems().setAll(TipoEmpleado.values());
        iniciarTabla();
    }

    private void mostrarAviso(String msg, AlertType tipo){
        Alert alerta = new Alert(tipo);
        alerta.setHeaderText(null);
        alerta.setTitle(MSG_ERROR);
        alerta.setContentText(msg);
        alerta.showAndWait();
    }
}
