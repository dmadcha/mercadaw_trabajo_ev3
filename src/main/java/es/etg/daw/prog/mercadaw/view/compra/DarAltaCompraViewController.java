package es.etg.daw.prog.mercadaw.view.compra;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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
import es.etg.daw.prog.mercadaw.model.entities.compras.Cliente;
import es.etg.daw.prog.mercadaw.model.entities.compras.Compra;
import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;


/**
 * Vista de dar alta compra.
 * \author Erik Herrera Llamas
 */
public class DarAltaCompraViewController extends ViewController implements Initializable{
    private ObservableList<Compra> compras;
    private ObservableList<Producto> produtos;



    @FXML
    private Button btnGesionClientes;

    @FXML
    private Button btnAnadirCompra;

    @FXML
    private Button btnAnadirProducto;

    @FXML
    private Button btnSalir;

    @FXML
    private TableColumn<Compra, Integer> colCodigoComp;

    @FXML
    private TableColumn<Cliente, Integer> colCodigoCli;

    @FXML
    private TableColumn<Cliente, Integer> colNombCli;


    @FXML
    private TableColumn<Producto, Integer> colCodigoProdCompra;

    @FXML
    private TableColumn<Producto, Integer> colNombProdCompra;

    @FXML
    private TableColumn<Compra, Date> colFecha;

    @FXML
    private TableView<Compra> tabCompras;

    @FXML
    private TableColumn<Producto, Integer> colCodigoProd;

    @FXML
    private TableColumn<Producto, Double> colPrecio;

    @FXML
    private TableColumn<Producto, Integer> colNombProd; 

    @FXML
    private TableView<Producto> tabProductos;

    @FXML
    private TextField txfCodCliente;

    List<Producto> products = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources){
        iniciarTabla();
        try {
            insertar(controller.cargarTablaCompra());
        } catch (Exception e) {
            //TODO: MENSAJE ERROR (CARGA INICAL DE LA TABLA FALLIDA)
        }        
    }

    public void insertar(List<Compra> comprs){
        this.compras.setAll(comprs);
        this.tabCompras.setItems(compras);
    }

    @FXML
    void seleccionarProducto(MouseEvent event) {

        Producto producto = this.tabProductos.getSelectionModel().getSelectedItem();

        if(producto == null){
            //TODO MENSAJE ERROR
        }
    }

    @FXML
    void obtenerPrecioVenta(MouseEvent event) {
        Producto producto = this.tabProductos.getSelectionModel().getSelectedItem();
        
        
    }
    
    @FXML
    void accesoDarAltaClientes(MouseEvent event) {
        controller.cargarCompras();
    }

    @FXML
    void addCompra(MouseEvent event) throws MercaDAWException{
        try {
            int id = Integer.parseInt(txfCodCliente.getText());
            
            Date fecha = Date.valueOf(LocalDate.now());

            Compra compra = new Compra(null, fecha, null, products);
            List<Compra> comprasBd = controller.darAlta(compra);
            if (compras.contains(compra)) {
                mostrarAviso(MSG_ERROR, AlertType.ERROR);
            } else {
                insertar(comprasBd);
            }
        } catch (NumberFormatException e) {
            mostrarAviso(MSG_ERROR, AlertType.ERROR);
        }
    }

    public void iniciarTabla(){
        compras = FXCollections.observableArrayList();

        this.colCodigoCli.setCellValueFactory(new PropertyValueFactory<>(Compra.ATT_ID_COMP));
        this.colCodigoCli.setCellValueFactory(new PropertyValueFactory<>(Cliente.ATT_ID_CLI));
        this.colNombCli.setCellValueFactory(new PropertyValueFactory<>(Cliente.ATT_NOMB_CLI));
        this.colCodigoProdCompra.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_ID));
        this.colNombProdCompra.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_NOMBRE));
        this.colFecha.setCellValueFactory(new PropertyValueFactory<>(Compra.ATT_FECH_COMP));

        this.colCodigoProd.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_ID));
        this.colNombProd.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_NOMBRE));
        this.colPrecio.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_PRECIO));

    }

}
