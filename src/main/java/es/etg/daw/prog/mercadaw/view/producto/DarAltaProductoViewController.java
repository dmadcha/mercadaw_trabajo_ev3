package es.etg.daw.prog.mercadaw.view.producto;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.poi.sl.draw.DrawSlide;

import es.etg.daw.prog.mercadaw.controller.MercaDAWController;
import es.etg.daw.prog.mercadaw.model.entities.productos.Alimentacion;
import es.etg.daw.prog.mercadaw.model.entities.productos.Producible;
import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;
import es.etg.daw.prog.mercadaw.model.entities.productos.ProductoFactory;
import es.etg.daw.prog.mercadaw.model.entities.productos.TipoProducto;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;
import es.etg.daw.prog.mercadaw.view.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class DarAltaProductoViewController extends ViewController implements Initializable {
    private MercaDAWController controller = new MercaDAWController();

    @FXML
    private Button btnAñadirProd;

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
    private ChoiceBox<TipoProducto> choiceCategoria;

    @FXML
    private TextArea txaDescripcion;

    @FXML
    private TextField txfAltura;

    @FXML
    private TextField txfAnchura;

    @FXML
    private TextField txfElementos;

    @FXML
    private TextField txfIva;

    @FXML
    private TextField txfMarca;

    @FXML
    private TextField txfNombre;

    @FXML
    private TextField txfPeso;

    @FXML
    private TextField txfPrecio;

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
    void addProducto(MouseEvent event) throws MercaDAWException {
        String nombre = txfNombre.getText();
        String marca = txfMarca.getText();
        //TipoProducto categoria = choiceCategoria.getValue();
        String descripcion = txaDescripcion.getText();
        double altura = Double.parseDouble(txfAltura.getText());
        double anchura = Double.parseDouble(txfAnchura.getText());
        double peso = Double.parseDouble(txfPeso.getText());
        double precio = Double.parseDouble(txfPrecio.getText());
        //double iva = Double.parseDouble(txfIva.getText());
        int numElementos = Integer.parseInt(txfElementos.getText());
    }

    @FXML
    void salir(MouseEvent event) {
        controller.cargarApp();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceCategoria.getItems().setAll(TipoProducto.values());
    }
}
