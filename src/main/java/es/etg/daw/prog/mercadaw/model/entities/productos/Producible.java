package es.etg.daw.prog.mercadaw.model.entities.productos;

/**
 * La interfaz Producible expone los principales metodos de calculo del precio de venta de los productos.
 * \author Diego Madroñero Chamorro.
 */
public interface Producible {
    public static final int PESO_MIN = 1;
    public static final int PESO_MAX = 5;
    public static final double ALTURA_MIN = 0.5;
    public static final double ANCHURA_MIN = 0.5;
    public static final double IVA_ALIM = 0.04;
    public static final double IVA_COSM = 0.10;
    public static final double IVA_DROG = 0.21;

    /**
     * Calcula em precio de venta de un producto.
     * \return Un double con el precio final de venta del
     */
    public double getPrecioVenta();
}
