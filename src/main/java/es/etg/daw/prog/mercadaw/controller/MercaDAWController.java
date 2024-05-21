package es.etg.daw.prog.mercadaw.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import es.etg.daw.prog.mercadaw.App;
import es.etg.daw.prog.mercadaw.model.bbdd.Database;
import es.etg.daw.prog.mercadaw.model.bbdd.MercaDAO;
import es.etg.daw.prog.mercadaw.model.bbdd.MercaDAOFactory;
import es.etg.daw.prog.mercadaw.model.entities.compras.Cliente;
import es.etg.daw.prog.mercadaw.model.entities.compras.Compra;
import es.etg.daw.prog.mercadaw.model.entities.empleados.Empleado;
import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;
import es.etg.daw.prog.mercadaw.model.util.input.Fichero;
import es.etg.daw.prog.mercadaw.model.util.input.FicheroFactory;
import es.etg.daw.prog.mercadaw.model.util.input.Formato;
import es.etg.daw.prog.mercadaw.view.MainViewController;
import es.etg.daw.prog.mercadaw.view.ViewController;
import es.etg.daw.prog.mercadaw.view.Vista;
import es.etg.daw.prog.mercadaw.view.compra.DarAltaCompraViewController;
import es.etg.daw.prog.mercadaw.view.empleado.DarAltaEmpleadoViewController;
import es.etg.daw.prog.mercadaw.view.producto.DarAltaProductoViewController;
import es.etg.daw.prog.mercadaw.view.sistema.CargaDatosViewController;
import es.etg.daw.prog.mercadaw.view.sistema.ExportarDatosViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MercaDAWController extends Application{
    public static final String MSG_ERROR = "ERROR";

    public static Stage currentStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        //MercaDAO database = MercaDAOFactory.obtener(Database.ORACLE);
        //database.iniciarBBDD();

        currentStage = stage;

        stage.setMinWidth(600);
        stage.setMinHeight(500);

        stage.setTitle("MercaDAW");
        cargarVista(Vista.MAIN);

    }

    private ViewController cargarVista(Vista vista) throws IOException{
        ViewController controller = null;

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(vista.getRuta()));
        Parent root = (Parent)fxmlLoader.load();  

        if (Vista.MAIN == vista) {
            controller = fxmlLoader.<MainViewController>getController();
        } else if (Vista.DAR_ALTA_PROD == vista) {
            controller = fxmlLoader.<DarAltaProductoViewController>getController();         
        } else if (Vista.DAR_ALTA_EMPLE == vista) {
            controller = fxmlLoader.<DarAltaEmpleadoViewController>getController();        
        } else if (Vista.CARGA_DATOS == vista) {
            controller = fxmlLoader.<CargaDatosViewController>getController();               
        } else if (Vista.DAR_ALTA_COMP == vista) {
            controller = fxmlLoader.<DarAltaCompraViewController>getController();     
        } else if (Vista.EXPORTAR_DATOS == vista) {
            controller = fxmlLoader.<ExportarDatosViewController>getController();   
        }

        controller.setMercaDAWController(this);

        Scene scene = new Scene(root); 
    
        currentStage.setScene(scene);
        currentStage.show();

        return controller;   
    }

    /* Productos */
    public void cargarProductos() {
        try {
            cargarVista(Vista.DAR_ALTA_PROD);
        } catch (Exception e) {
            mostrarAviso(MSG_ERROR, AlertType.ERROR);
        }
    }

    /* Empleados */
    public void cargarEmpleados() {
        try {
            cargarVista(Vista.DAR_ALTA_EMPLE);
        } catch (Exception e) {
            mostrarAviso(MSG_ERROR, AlertType.ERROR);
        }
    }

    /* Compras */
    public void cargarCompras() {
        try {
            cargarVista(Vista.DAR_ALTA_COMP);
        } catch (Exception e) {
            mostrarAviso(MSG_ERROR, AlertType.ERROR);
        }
    }

    /* Sistemas */
    public void cargarImportar() {
        try {
            cargarVista(Vista.CARGA_DATOS);
        } catch (Exception e) {
            mostrarAviso(MSG_ERROR, AlertType.ERROR);
        }
    }
    public void cargarExportar() {
        try {
            cargarVista(Vista.EXPORTAR_DATOS);
        } catch (Exception e) {
            mostrarAviso(MSG_ERROR, AlertType.ERROR);
        }
    }

    /* Main */
    public void cargarApp() {
        try {
            cargarVista(Vista.MAIN);
        } catch (Exception e) {
            mostrarAviso(MSG_ERROR, AlertType.ERROR);
        }
    }

    public void importar(String ruta) {
        Fichero fichero = FicheroFactory.obtener(Formato.BINARIO);
        fichero.leer(ruta);
    }

    public List<Empleado> darAlta(Empleado empleado) throws MercaDAWException {
        MercaDAO database = MercaDAOFactory.obtener(Database.ORACLE);
        database.insertar(empleado);

        return database.visualizarEmpleados();
    }

    public List<Producto> darAlta(Producto producto) throws MercaDAWException {
        MercaDAO database = MercaDAOFactory.obtener(Database.ORACLE);
        database.insertar(producto);

        return database.visualizarProductos();
    }

    public List<Cliente> darAlta(Cliente cliente) throws MercaDAWException {
        MercaDAO database = MercaDAOFactory.obtener(Database.ORACLE);
        database.insertar(cliente);

        return database.visualizarClientes();
    }

    public List<Compra> darAlta(Compra compra) throws MercaDAWException {
        MercaDAO database = MercaDAOFactory.obtener(Database.ORACLE);
        database.insertar(compra);
        
        return database.visualizarCompras();
    }

    public String calcularPrecioVenta(Producto producto){
        String msg ="Producto("+producto.getId()+"): "+producto.getNombre()+"\n\t"+
                            "Precio de venta: "+producto.getPrecioVenta()+" \n\t"+
                            "Recargo por Peso("+producto.getPorcentajePeso()+"%): "+producto.getRecargoPeso()+" \n\t"+
                            "Recargo por Altura("+producto.getPorcentajeAltura()+"%): "+producto.getRecargoAltura()+" \n\t"+
                            "Recargo por Anchura("+producto.getPorcentajeAnchura()+"%): "+producto.getRecargoAnchura()+" \n\t"+
                            "Recargo por Número de Piezas("+producto.getNumElementos()+"): "+producto.getRecargoNumElementos()+" \n\n\t"+
                            "PRECIO TOTAL: "+producto.getPrecioFinalEuros()+"€ /"+producto.getPrecioFinalDolares()+"\n\t"+
                            "IVA("+producto.getIva()*100+"%): "+producto.getIvaCalculado();
        
        return msg;
    }

    public List<Empleado> cargarTablaEmpleado() throws MercaDAWException{
        MercaDAO database = MercaDAOFactory.obtener(Database.ORACLE);
        return database.visualizarEmpleados();
    }

    public List<Producto> cargarTablaProducto() throws MercaDAWException{
        MercaDAO database = MercaDAOFactory.obtener(Database.ORACLE);
        return database.visualizarProductos();
    }

    public List<Cliente> cargarTablaCliente() throws MercaDAWException{
        MercaDAO database = MercaDAOFactory.obtener(Database.ORACLE);
        return database.visualizarClientes();
    }

    public List<Compra> cargarTablaCompra() throws MercaDAWException{
        MercaDAO database = MercaDAOFactory.obtener(Database.ORACLE);
        return database.visualizarCompras();
    }

    private void mostrarAviso(String msg, AlertType tipo){
        Alert alerta = new Alert(tipo);
        alerta.setHeaderText(null);
        alerta.setTitle(MSG_ERROR);
        alerta.setContentText(msg);
        alerta.showAndWait();
    }
}