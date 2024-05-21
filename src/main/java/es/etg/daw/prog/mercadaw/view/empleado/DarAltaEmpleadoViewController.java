package es.etg.daw.prog.mercadaw.view.empleado;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import es.etg.daw.prog.mercadaw.model.entities.empleados.Empleado;
import es.etg.daw.prog.mercadaw.model.entities.empleados.EmpleadoFactory;
import es.etg.daw.prog.mercadaw.model.entities.empleados.TipoDespido;
import es.etg.daw.prog.mercadaw.model.entities.empleados.TipoEmpleado;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;
import es.etg.daw.prog.mercadaw.view.ViewController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * Vista de dar alta empleado.
 * \author Erik Herrera Llamas, Diego Madroñero, Jesús Pérez 
 */
public class DarAltaEmpleadoViewController extends ViewController implements Initializable{
    private ObservableList<Empleado> empleados;

     @FXML
    private Button btnAnadir;

    @FXML
    private Button btnCalcularNomina;

    @FXML
    private Button btnExportar;

    @FXML
    private Button btnSalir;

    @FXML
    private ChoiceBox<TipoDespido> choiceDespido;

    @FXML
    private ChoiceBox<TipoEmpleado> choiceCategoria;

    @FXML
    private TableColumn<Empleado, String> colApellidos;
    
    @FXML
    private TableColumn<Empleado, String> colCategoria;

    @FXML
    private TableColumn<Empleado, Integer> colCodigoEmple;

    @FXML
    private TableColumn<Empleado, String> colNombre;

    @FXML
    private TableView<Empleado> tabEmpleados;

    @FXML
    private TextArea txaNominaEmpleado;

    @FXML
    private TextField txfApellido;

    @FXML
    private TextField txfNombre;

    @FXML
    private TextField txfRuta;

    @FXML
    void accesoDarAltaEmple(MouseEvent event) {
        controller.cargarEmpleados();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        choiceCategoria.getItems().setAll(TipoEmpleado.values());
        choiceDespido.getItems().setAll(TipoDespido.values());
        iniciarTabla();
        try {
            insertar(controller.cargarTablaEmpleado());
        } catch (Exception e) {
            //TODO: MENSAJE ERROR (CARGA INICAL DE LA TABLA FALLIDA)
        }        
    }

    public void insertar(List<Empleado> empls){
        this.empleados.setAll(empls);
        this.tabEmpleados.setItems(empleados);
    }
    

    @FXML
    public void iniciarTabla() {

        empleados = FXCollections.observableArrayList();

        this.colCodigoEmple.setCellValueFactory(new PropertyValueFactory<>(Empleado.ATT_ID_EMPLE));
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>(Empleado.ATT_NOM_EMPLE));
        this.colApellidos.setCellValueFactory(new PropertyValueFactory<>(Empleado.ATT_APELLIDO));
        this.colCategoria.setCellValueFactory(celda -> new SimpleStringProperty(celda.getValue().toString()));

    }

    @FXML
    void addEmpleado(MouseEvent event) throws MercaDAWException, SQLException {
        try {
            String nombre = txfNombre.getText();
            String apellidos = txfApellido.getText();
            String tipo = choiceCategoria.getValue().toString();
            Date fecha = Date.valueOf(LocalDate.now());

            Empleado empleado = EmpleadoFactory.obtener(tipo, null, nombre, apellidos, fecha);
            List<Empleado> empleadosBd = controller.darAlta(empleado);
            if (empleados.contains(empleado)) {
                mostrarAviso(MSG_ERROR, AlertType.ERROR);
            } else {
                insertar(empleadosBd);
            }
        } catch (NumberFormatException e) {
            mostrarAviso(MSG_ERROR, AlertType.ERROR);
        }
    }

    @FXML
    void seleccionarEmpleado(MouseEvent event) {
        Empleado empleado = this.tabEmpleados.getSelectionModel().getSelectedItem();

        if(empleado == null){
            //TODO MENSAJE ERROR
        }
    }

    @FXML
    void calcularNomina(MouseEvent event) {
        Empleado empleado = this.tabEmpleados.getSelectionModel().getSelectedItem();
        TipoDespido despido = this.choiceDespido.getValue();
        String msg = controller.calcularNomina(empleado, despido);
        txaNominaEmpleado.setText(msg);
    }

    @FXML
    void exportarNomina(MouseEvent event) {
        final String RUTA_NOMINA = "./src/main/resources/nominas/nominaEmpleado%d.md";
        Empleado empleado = this.tabEmpleados.getSelectionModel().getSelectedItem();
        controller.exportarNomina(String.format(RUTA_NOMINA, empleado.getId()), txaNominaEmpleado.getText());
    }
}


