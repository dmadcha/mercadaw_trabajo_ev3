package es.etg.daw.prog.mercadaw.view.sistema;

import java.io.File;

import es.etg.daw.prog.mercadaw.controller.MercaDAWController;
import es.etg.daw.prog.mercadaw.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class CargaDatosViewController extends ViewController {
    public static final String NOMBRE_VENTANA = "Seleccionar Archivo";
    public static final String EXTENSION_CSV = "*.csv";
    public static final String EXTENSION_SQL = "*.sql";
    public static final String EXTENSION_JSON = "*.json";
    public static final String DESC_CSV = "CSV";
    public static final String DESC_SQL = "SQL";
    public static final String DESC_JSON = "JSON";


    private Stage stage;
    private MercaDAWController controller = new MercaDAWController();

    @FXML
    private Button btnCargarDatos;

    @FXML
    private Button btnCargarEnviar;

    @FXML
    private Button btnExportarDatos;

    @FXML
    private Button btnSalir;

    @FXML
    private Button btnSelectArchivo;

    @FXML
    private TextField txfRuta;

    @FXML
    void accesoCargarDatos(MouseEvent event) {
        controller.cargarImportar();
    }

    @FXML
    void accesoExportarDatos(MouseEvent event) {
        controller.cargarExportar();
    }

    @FXML
    void enviar(MouseEvent event) {
        
    }

    @FXML
    void salir(MouseEvent event) {
        controller.cargarApp();
    }

    @FXML
    void selectArchivo(MouseEvent event) {
        ExtensionFilter extensionCSV = new ExtensionFilter(DESC_CSV, EXTENSION_CSV);
		ExtensionFilter extensionSQL = new ExtensionFilter(DESC_JSON, EXTENSION_JSON);
        ExtensionFilter extensionJSON = new ExtensionFilter(DESC_SQL, EXTENSION_SQL);

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(extensionCSV, extensionSQL, extensionJSON);
        fileChooser.setTitle(NOMBRE_VENTANA);
                        
        File selectedFile = fileChooser.showOpenDialog(stage);
        txfRuta.setText(selectedFile.getAbsolutePath());
    }

}
