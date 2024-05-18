package es.etg.daw.prog.mercadaw.controller;

import java.io.IOException;

import es.etg.daw.prog.mercadaw.App;
import es.etg.daw.prog.mercadaw.view.MainViewController;
import es.etg.daw.prog.mercadaw.view.ViewController;
import es.etg.daw.prog.mercadaw.view.Vista;
import es.etg.daw.prog.mercadaw.view.compra.DarAltaCompraViewController;
import es.etg.daw.prog.mercadaw.view.compra.ListarCompraViewController;
import es.etg.daw.prog.mercadaw.view.empleado.DarAltaEmpleadoViewController;
import es.etg.daw.prog.mercadaw.view.empleado.ListarEmpleadoViewController;
import es.etg.daw.prog.mercadaw.view.empleado.NominaViewController;
import es.etg.daw.prog.mercadaw.view.producto.DarAltaProductoViewController;
import es.etg.daw.prog.mercadaw.view.producto.ListarProductoViewController;
import es.etg.daw.prog.mercadaw.view.producto.ListarStockViewController;
import es.etg.daw.prog.mercadaw.view.producto.VentaProductoViewController;
import es.etg.daw.prog.mercadaw.view.sistema.CargaDatosViewController;
import es.etg.daw.prog.mercadaw.view.sistema.ExportarDatosViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MercaDAWController extends Application{
    public static Stage currentStage;

    @Override
    public void start(Stage stage) throws Exception {
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
        } else if (Vista.LISTAR_COMP == vista) {
            controller = fxmlLoader.<ListarCompraViewController>getController();   
        } else if (Vista.LISTAR_EMPLE == vista) {
            controller = fxmlLoader.<ListarEmpleadoViewController>getController();   
        } else if (Vista.NOMINA == vista) {
            controller = fxmlLoader.<NominaViewController>getController();   
        } else if (Vista.LISTAR_PROD == vista) {
            controller = fxmlLoader.<ListarProductoViewController>getController();    
        } else if (Vista.LISTAR_STOCK == vista) {
            controller = fxmlLoader.<ListarStockViewController>getController();   
        } else if (Vista.VENTA_PROD == vista) {
            controller = fxmlLoader.<VentaProductoViewController>getController();   
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

        }
    }
    public void cargarListarProductos() {
        try {
            cargarVista(Vista.LISTAR_PROD);
        } catch (Exception e) {

        }
    }
    public void cargarListarStock() {
        try {
            cargarVista(Vista.LISTAR_STOCK);
        } catch (Exception e) {

        }
    }
    public void cargarVentaProductos() {
        try {
            cargarVista(Vista.VENTA_PROD);
        } catch (Exception e) {

        }
    }

    /* Empleados */
    public void cargarEmpleados() {
        try {
            cargarVista(Vista.DAR_ALTA_EMPLE);
        } catch (Exception e) {

        }
    }
    public void cargarListarEmpleados() {
        try {
            cargarVista(Vista.LISTAR_EMPLE);
        } catch (Exception e) {

        }
    }
    public void cargarNomina() {
        try {
            cargarVista(Vista.NOMINA);
        } catch (Exception e) {

        }
    }

    /* Compras */
    public void cargarCompras() {
        try {
            cargarVista(Vista.DAR_ALTA_COMP);
        } catch (Exception e) {

        }
    }
    public void cargarListarCompras() {
        try {
            cargarVista(Vista.LISTAR_COMP);
        } catch (Exception e) {

        }
    }

    /* Sistemas */
    public void cargarImportar() {
        try {
            cargarVista(Vista.CARGA_DATOS);
        } catch (Exception e) {

        }
    }
    public void cargarExportar() {
        try {
            cargarVista(Vista.EXPORTAR_DATOS);
        } catch (Exception e) {

        }
    }

    /* Main */
    public void cargarApp() {
        try {
            cargarVista(Vista.MAIN);
        } catch (Exception e) {

        }
    }
}
