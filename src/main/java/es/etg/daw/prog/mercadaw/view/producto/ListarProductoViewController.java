package es.etg.daw.prog.mercadaw.view.producto;

import es.etg.daw.prog.mercadaw.controller.MercaDAWController;
import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;
import es.etg.daw.prog.mercadaw.model.entities.productos.TipoProducto;
import es.etg.daw.prog.mercadaw.view.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ListarProductoViewController extends ViewController {
    private MercaDAWController controller = new MercaDAWController();

    @FXML
    private Button btnConsultarDatos;

    @FXML
    private Button btnDarAltaProd;

    @FXML
    private Button btnListarStock;

    @FXML
    private Button btnPrecioVenta;

    @FXML
    private Button btnSalir;

    @FXML
    private TableColumn<Producto, Double> colAltura;

    @FXML
    private TableColumn<Producto, Double> colAnchura;

    @FXML
    private TableColumn<Producto, TipoProducto> colCategoria;

    @FXML
    private TableColumn<Producto, Integer> colCodigo;

    @FXML
    private TableColumn<Producto, String> colDescripcion;

    @FXML
    private TableColumn<Producto, Integer> colElemento;

    @FXML
    private TableColumn<Producto, Double> colIVA;

    @FXML
    private TableColumn<Producto, String> colMarca;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Producto, Double> colPeso;

    @FXML
    private TableColumn<Producto, Double> colPrecio;

    @FXML
    private TableView<Producto> tabProducto;

    @FXML
    void accesoConsultarDatos(MouseEvent event) {
        controller.cargarListarProductos();
    }

    @FXML
    void accesoDarAltaProd(MouseEvent event) {
        controller.cargarProductos();
    }

    @FXML
    void accesoListarStock(MouseEvent event) {
        controller.cargarListarStock();
    }

    @FXML
    void accesoPrecioVenta(MouseEvent event) {
        controller.cargarVentaProductos();
    }

    @FXML
    void salir(MouseEvent event) {
        controller.cargarApp();
    }

    @FXML
    public void inicializarTabla() {
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_NOMBRE));
        this.colMarca.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_MARCA));
        this.colCategoria.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_CATEGORIA));
        this.colPrecio.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_PRECIO));
        this.colIVA.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_IVA));
        this.colAltura.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_ALTURA));
        this.colAnchura.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_ANCHURA));   
        this.colPeso.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_PESO));   
        this.colElemento.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_ELEMENTOS));    
        this.colDescripcion.setCellValueFactory(new PropertyValueFactory<>(Producto.ATT_DESCRIPCION));   
    }

    public void setProductos(ObservableList<Producto> productos) {
        tabProducto.setItems(productos);
    }
}