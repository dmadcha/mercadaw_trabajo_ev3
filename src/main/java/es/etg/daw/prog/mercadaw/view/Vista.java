package es.etg.daw.prog.mercadaw.view;

/**
 * Esta clase contiene las rutas hacia las diferentes vistas de nuestra aplicación.
 * @author: Erik Herrera Llamas
 * @version: 1.0
 */
public enum Vista {
    MAIN("view/MainView.fxml"),
    CARGA_DATOS("view/sistema/CargaDatosView.fxml"),
    EXPORTAR_DATOS("view/sistema/ExportarDatosView.fxml"),
    DAR_ALTA_PROD("view/producto/DarAltaProductoView.fxml"),
    LISTAR_PROD("view/producto/ListarProductoView.fxml"),
    LISTAR_STOCK("view/producto/ListarStockView.fxml"),
    VENTA_PROD("view/producto/VentaProductoView.fxml"),
    DAR_ALTA_EMPLE("view/empleado/DarAltaEmpleadoView.fxml"),
    LISTAR_EMPLE("view/empleado/ListarEmpleadoView.fxml"),
    NOMINA("view/empleado/NominaView.fxml"),
    DAR_ALTA_COMP("view/compra/DarAltaCompraView.fxml"),
    LISTAR_COMP("view/compra/ListarCompraView.fxml");

    private String ruta;

    private Vista(String ruta) {
        this.ruta = ruta;
    }
    public String getRuta() {
        return ruta;
    }
}
