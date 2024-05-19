package es.etg.daw.prog.mercadaw.view;

/**
 * Esta clase contiene las rutas hacia las diferentes vistas de nuestra aplicación.
 * \author Erik Herrera Llamas
 * \version 1.0
 */
public enum Vista {
    MAIN("view/MainView.fxml"),
    CARGA_DATOS("view/sistema/CargaDatosView.fxml"),
    EXPORTAR_DATOS("view/sistema/ExportarDatosView.fxml"),
    DAR_ALTA_PROD("view/producto/DarAltaProductoView.fxml"),
    DAR_ALTA_EMPLE("view/empleado/DarAltaEmpleadoView.fxml"),
    DAR_ALTA_COMP("view/compra/DarAltaCompraView.fxml");

    private String ruta;

    private Vista(String ruta) {
        this.ruta = ruta;
    }
    public String getRuta() {
        return ruta;
    }
}
