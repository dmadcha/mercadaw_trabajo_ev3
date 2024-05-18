package es.etg.daw.prog.mercadaw.view.sistema;

import es.etg.daw.prog.mercadaw.controller.MercaDAWController;
import es.etg.daw.prog.mercadaw.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ExportarDatosViewController extends ViewController {
    private MercaDAWController controller = new MercaDAWController();

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

    @FXML
    void exportar(MouseEvent event) {

    }

    @FXML
    void salir(MouseEvent event) {
        controller.cargarApp();
    }

    @FXML
    void seleccionarDestino(MouseEvent event) {

    }

}
