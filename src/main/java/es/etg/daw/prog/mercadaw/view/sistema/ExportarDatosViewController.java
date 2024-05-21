package es.etg.daw.prog.mercadaw.view.sistema;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import es.etg.daw.prog.mercadaw.view.ViewController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

/**
 * Vusta de la exportación de datos del sistema.
 * \author Erik Herrera Llamas
 */
public class ExportarDatosViewController extends ViewController implements Initializable {
    public static final String NOMBRE_VENTANA = "Seleccionar Destino";

    private Stage stage;

    @FXML
    private Button btnCargarDatos;

    @FXML
    private Button btnExportar;

    @FXML
    private Button btnExportarDatos;

    @FXML
    private Button btnSalir;

    @FXML
    private Button btnSelectDestino;

    @FXML
    private CheckBox checkExcel;

    @FXML
    private CheckBox checkPDF;

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

    /*@FXML
    void exportar(MouseEvent event) throws Exception {
        String ruta = txfRuta.getText();
        MercaDAWController controller = new MercaDAWController();
        controller.exportar(ruta);
    }*/

    @FXML
    void seleccionarDestino(MouseEvent event) {
        DirectoryChooser carpeta = new DirectoryChooser();
        carpeta.setTitle(NOMBRE_VENTANA);

        File directorio = carpeta.showDialog(stage);

        txfRuta.setText(directorio.getAbsolutePath());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }
}
