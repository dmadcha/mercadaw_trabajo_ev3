package es.etg.daw.prog.mercadaw.view.compra;

import es.etg.daw.prog.mercadaw.controller.MercaDAWController;
import es.etg.daw.prog.mercadaw.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * Vista de dar alta compra.
 * \author Erik Herrera Llamas
 */
public class DarAltaCompraViewController extends ViewController {
    private MercaDAWController controller = new MercaDAWController();

    @FXML
    private Button btnDarAltaComp;

    @FXML
    private Button btnSalir;

    @FXML
    private TableColumn<?, ?> colCodigoCli;

    @FXML
    private TableColumn<?, ?> colCodigoProd;

    @FXML
    private TableColumn<?, ?> colFecha;

    @FXML
    private TableView<?> tabCompras;

    @FXML
    private TextField txfCodCliente;

    @FXML
    private TextField txfCodProducto;

    @FXML
    void accesoDarAltaComp(MouseEvent event) {
        controller.cargarCompras();
    }

    @FXML
    void addCompra(MouseEvent event) {
        
    }

}
