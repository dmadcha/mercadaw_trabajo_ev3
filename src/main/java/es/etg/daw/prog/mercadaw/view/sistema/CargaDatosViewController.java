package es.etg.daw.prog.mercadaw.view.sistema;

import es.etg.daw.prog.mercadaw.controller.MercaDAWController;
import es.etg.daw.prog.mercadaw.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CargaDatosViewController extends ViewController {
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

    }

}
