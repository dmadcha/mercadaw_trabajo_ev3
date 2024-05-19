package es.etg.daw.prog.mercadaw.view.producto;

import java.net.URL;
import java.util.ResourceBundle;

import es.etg.daw.prog.mercadaw.controller.MercaDAWController;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;
import es.etg.daw.prog.mercadaw.view.ViewController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class DarAltaProductoViewController extends ViewController implements Initializable {
    private MercaDAWController controller = new MercaDAWController();

    @FXML
    private Button btnAñadir;

    @FXML
    private Button btnDarAltaEmple;

    @FXML
    private Button btnSalir;

    @FXML
    private ChoiceBox<?> choiceCategoria;

    @FXML
    private TableColumn<?, ?> colApellidos;

    @FXML
    private TableColumn<?, ?> colAportacionSal;

    @FXML
    private TableColumn<?, ?> colCategoria;

    @FXML
    private TableColumn<?, ?> colCodigo;

    @FXML
    private TableColumn<?, ?> colIndemnizacion;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private TableColumn<?, ?> colSalBruto;

    @FXML
    private TableColumn<?, ?> colSalNeto;

    @FXML
    private TableColumn<?, ?> colSueldo;

    @FXML
    private TableColumn<?, ?> colTotalCosteLab;

    @FXML
    private TableColumn<?, ?> colTotalNomina;

    @FXML
    private TableView<?> tabEmpleados;

    @FXML
    private TableView<?> tabNomina;

    @FXML
    private TextField txfApellido;

    @FXML
    private TextField txfNombre;

    @FXML
    void accesoDarAltaProd(MouseEvent event) {
        controller.cargarProductos();
    }

    @FXML
    void addProducto(MouseEvent event) throws MercaDAWException {

    }

    @FXML
    void salir(MouseEvent event) {
        controller.cargarApp();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //choiceCategoria.getItems().setAll(TipoProducto.values());
    }
}
