package es.etg.daw.prog.mercadaw.view.compra;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import es.etg.daw.prog.mercadaw.model.entities.compras.Cliente;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;
import es.etg.daw.prog.mercadaw.view.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class DarAltaClienteViewController  extends ViewController implements Initializable {
    private ObservableList<Cliente> clientes;

    @FXML
    private Button btnAnadirCliente;

    @FXML
    private Button btnGestionCompras;

    @FXML
    private Button btnSalir;

    @FXML
    private TableColumn<Cliente, Integer> colCodPostCli;

    @FXML
    private TableColumn<Cliente, Integer> colCodigoCli;

    @FXML
    private TableColumn<Cliente, String> colCorreoCli;

    @FXML
    private TableColumn<Cliente, String> colNombCli;

    @FXML
    private TableView<Cliente> tabClientes;

    @FXML
    private TextField txfCodPostalCliente;

    @FXML
    private TextField txfCorreoCliente;

    @FXML
    private TextField txfNombCliente;

    @FXML
    void accesoDarAltaCompras(MouseEvent event) {
        controller.cargarCompras();
    }

    @FXML
    void addCliente(MouseEvent event) throws MercaDAWException{
        try {

            String nombre = txfNombCliente.getText();
            String apellidos = txfCorreoCliente.getText();
            int codPostal = Integer.parseInt(txfCodPostalCliente.getText());

            Cliente cliente = new Cliente(null, nombre, apellidos, codPostal);
            List<Cliente> clientesBd = controller.darAlta(cliente);
            if (clientes.contains(cliente)) {
                mostrarAviso(MSG_ERROR, AlertType.ERROR);
            } else {
                insertar(clientesBd);
            }
        } catch (NumberFormatException e) {
            mostrarAviso(MSG_ERROR, AlertType.ERROR);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        iniciarTabla();
        try {
            insertar(controller.cargarTablaCliente());
        } catch (Exception e) {
            //TODO: MENSAJE ERROR (CARGA INICAL DE LA TABLA FALLIDA)
        }
    }
    public void insertar(List<Cliente> clients){
        this.clientes.setAll(clients);
        this.tabClientes.setItems(clientes);
    }

    public void iniciarTabla(){
        clientes = FXCollections.observableArrayList();

        this.colCodigoCli.setCellValueFactory(new PropertyValueFactory<>(Cliente.ATT_ID_CLI));
        this.colNombCli.setCellValueFactory(new PropertyValueFactory<>(Cliente.ATT_NOMB_CLI));
        this.colCorreoCli.setCellValueFactory(new PropertyValueFactory<>(Cliente.ATT_CORR_CLI));
        this.colCodPostCli.setCellValueFactory(new PropertyValueFactory<>(Cliente.ATT_CODP_CLI));


    }

}
