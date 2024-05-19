package es.etg.daw.prog.mercadaw.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.poi.EmptyFileException;

import es.etg.daw.prog.mercadaw.App;
import es.etg.daw.prog.mercadaw.model.bbdd.Database;
import es.etg.daw.prog.mercadaw.model.bbdd.MercaDAO;
import es.etg.daw.prog.mercadaw.model.bbdd.MercaDAOFactory;
import es.etg.daw.prog.mercadaw.model.entities.empleados.Empleado;
import es.etg.daw.prog.mercadaw.model.entities.empleados.EmpleadoFactory;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;
import es.etg.daw.prog.mercadaw.model.util.export.Util;
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

    public void exportar(String ruta) throws Exception {
        Util util = new Util();
        util.exportar(ruta);
    }

    public void importar(String ruta) {
        Fichero fichero = FicheroFactory.obtener(Formato.BINARIO);
        fichero.leer(ruta);
    }

    public void getEmpleados(Empleado empleado) throws SQLException, MercaDAWException {
        MercaDAO database = MercaDAOFactory.obtener(Database.ORACLE);
        Empleado empleado2 = EmpleadoFactory.obtener("EMPLEADO", null, "Erik", "Herrera", null);
        database.insertar(empleado2);
    }

    private void mostrarAviso(String msg, AlertType tipo){
        Alert alerta = new Alert(tipo);
        alerta.setHeaderText(null);
        alerta.setTitle(MSG_ERROR);
        alerta.setContentText(msg);
        alerta.showAndWait();
    }
}