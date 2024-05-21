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
import es.etg.daw.prog.mercadaw.model.entities.empleados.TipoDespido;
import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;
import es.etg.daw.prog.mercadaw.model.exception.BBDDException;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;
import es.etg.daw.prog.mercadaw.model.util.input.Fichero;
import es.etg.daw.prog.mercadaw.model.util.input.FicheroFactory;
import es.etg.daw.prog.mercadaw.model.util.input.FormatoBinarios;
import es.etg.daw.prog.mercadaw.model.util.reader.Formato;
import es.etg.daw.prog.mercadaw.model.util.reader.Lector;
import es.etg.daw.prog.mercadaw.model.util.reader.LectorFactory;
import es.etg.daw.prog.mercadaw.view.MainViewController;
import es.etg.daw.prog.mercadaw.view.ViewController;
import es.etg.daw.prog.mercadaw.view.Vista;
import es.etg.daw.prog.mercadaw.view.compra.DarAltaClienteViewController;
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
    public static final String REDONDEO = "%.2f";
    public static final String MSG_ERROR = "ERROR";

    public static Stage currentStage;
    
    @Override
    public void start(Stage stage) throws Exception{
        

        try {
            MercaDAO database = getBBDD();
            database.iniciarBBDD();
        } catch (Exception e) {
        }

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
        } else if (Vista.DAR_ALTA_COMP == vista) {
            controller = fxmlLoader.<DarAltaCompraViewController>getController();  
        } else if (Vista.DAR_ALTA_CLIENT == vista) {
            controller = fxmlLoader.<DarAltaClienteViewController>getController();     
        } else if (Vista.EXPORTAR_DATOS == vista) {
            controller = fxmlLoader.<ExportarDatosViewController>getController();   
        } else if (Vista.CARGA_DATOS == vista) {
            controller = fxmlLoader.<CargaDatosViewController>getController();   
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
    public void cargarClientes() {
        try {
            cargarVista(Vista.DAR_ALTA_CLIENT);
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

    public void importar(String ruta) throws MercaDAWException, SQLException {        
        final String EMPLEADO = "EMPLEADO";
        final String CLIENTE = "CLIENTE";
        final String PRODUCTO = "PRODUCTO";
        final String COMPRA = "COMPRA";


        MercaDAO database = getBBDD();
        Fichero fichero = FicheroFactory.obtener(FormatoBinarios.BINARIO);
        byte[] bytesContenido = fichero.leer(ruta);

        String contenidoStr = new String(bytesContenido);
        Lector lector = LectorFactory.obtener(Formato.JSON);

        if (ruta.indexOf(".csv")>= 0) {
            lector = LectorFactory.obtener(Formato.CSV);
        }

        if (ruta.indexOf(EMPLEADO)>=0) {
            List<Empleado> empleados = lector.leerEmpleado(contenidoStr);
            for (int i = 0; i < empleados.size(); i++) {
                database.insertar(empleados.get(i));
            }
        } else if (ruta.indexOf(CLIENTE)>=0) {
            List<Cliente> clientes = lector.leerCliente(contenidoStr);
            for (int i = 0; i < clientes.size(); i++) {
                database.insertar(clientes.get(i));
            }
        } else if (ruta.indexOf(PRODUCTO)>=0) {
            List<Compra> compras = lector.leerCompra(contenidoStr);
            for (int i = 0; i < compras.size(); i++) {
                database.insertar(compras.get(i));
            }
        } else if (ruta.indexOf(COMPRA)>=0) {
            List<Producto> productos = lector.leerProducto(contenidoStr);
            for (int i = 0; i < productos.size(); i++) {
                database.insertar(productos.get(i));
            }
        }
    }

    public List<Empleado> darAlta(Empleado empleado) throws MercaDAWException {
        MercaDAO database = getBBDD();
        database.insertar(empleado);

        return database.visualizarEmpleados();
    }

    public List<Producto> darAlta(Producto producto) throws MercaDAWException {
        MercaDAO database = getBBDD();
        database.insertar(producto);

        return database.visualizarProductos();
    }

    public List<Cliente> darAlta(Cliente cliente) throws MercaDAWException {
        MercaDAO database = getBBDD();
        database.insertar(cliente);

        return database.visualizarClientes();
    }

    public List<Compra> darAlta(Compra compra) throws MercaDAWException {
        MercaDAO database = getBBDD();
        database.insertar(compra);
        
        return database.visualizarCompras();
    }

    public Cliente visualizarCliente(int client) throws MercaDAWException {
        MercaDAO database = getBBDD();
        return database.visualizarCliente(client);
    }

    public String calcularPrecioVenta(Producto producto){
        String msg ="Producto("+producto.getId()+"): "+producto.getNombre()+"\n\t"+
                            "Precio de venta: "+String.format(REDONDEO, producto.getPrecioVenta())+" \n\t"+
                            "Recargo por Peso("+producto.getPorcentajePeso()+"%): "+String.format(REDONDEO, producto.getRecargoPeso())+" \n\t"+
                            "Recargo por Altura("+producto.getPorcentajeAltura()+"%): "+String.format(REDONDEO, producto.getRecargoAltura())+" \n\t"+
                            "Recargo por Anchura("+producto.getPorcentajeAnchura()+"%): "+String.format(REDONDEO, producto.getRecargoAnchura())+" \n\t"+
                            "Recargo por Número de Piezas("+producto.getNumElementos()+"): "+String.format(REDONDEO, producto.getRecargoNumElementos())+" \n\n\t"+
                            "PRECIO TOTAL: "+String.format(REDONDEO, producto.getPrecioFinalEuros())+"€ /"+String.format(REDONDEO, producto.getPrecioFinalDolares())+"$\n\t"+
                            "IVA("+producto.getIva()*100+"%): "+String.format(REDONDEO, producto.getIvaCalculado());
        
        return msg;
    }

    public String calcularNomina(Empleado empleado, TipoDespido despido){
        String msg ="Empleado("+empleado.getId()+"): "+empleado.getNombre()+"\n\t"+
                        "Salario Bruto: "+String.format(REDONDEO, empleado.getSalarioBruto())+"\n\t"+
                        "Salario Neto: "+String.format(REDONDEO, empleado.getSalarioNeto())+"\n\t"+
                        "Aportaciones SS del empresario: "+String.format(REDONDEO, empleado.getAportaciones())+"\n\t"+
                        "Indemniazción: "+String.format(REDONDEO, empleado.getIndemnizacion(despido));
        return msg;
    }

    public void exportarNomina(String ruta, String nomina){
        Fichero fichero = FicheroFactory.obtener(FormatoBinarios.BINARIO);
        fichero.escribir(ruta, nomina);
    }

    public List<Empleado> cargarTablaEmpleado() throws MercaDAWException{
        MercaDAO database = getBBDD();
        return database.visualizarEmpleados();
    }

    public List<Producto> cargarTablaProducto() throws MercaDAWException{
        MercaDAO database = getBBDD();
        return database.visualizarProductos();
    }

    public List<Cliente> cargarTablaCliente() throws MercaDAWException{
        MercaDAO database = getBBDD();
        return database.visualizarClientes();
    }

    public List<Compra> cargarTablaCompra() throws MercaDAWException{
        MercaDAO database = getBBDD();
        return database.visualizarCompras();
    }

    private void mostrarAviso(String msg, AlertType tipo){
        Alert alerta = new Alert(tipo);
        alerta.setHeaderText(null);
        alerta.setTitle(MSG_ERROR);
        alerta.setContentText(msg);
        alerta.showAndWait();
    }

    public MercaDAO getBBDD() throws BBDDException{
        return MercaDAOFactory.obtener(Database.ORACLE);
    }
}