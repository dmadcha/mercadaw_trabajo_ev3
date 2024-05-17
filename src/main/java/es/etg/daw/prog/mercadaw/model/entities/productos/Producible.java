package es.etg.daw.prog.mercadaw.model.entities.productos;

public interface Producible {
    public static double IVA_ALIM = 0.04;
    public static double IVA_COSM = 0.10;
    public static double IVA_DROG = 0.21;

    public double getPrecioVenta();
}
