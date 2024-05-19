package es.etg.daw.prog.mercadaw.model.entities.productos;

/**
 * La enumeracion Recargos representa los recargos posibles y su valor correspondiente.
 * \author Diego Madroñero Chamorro.
 */
public enum Recargos {
    RECARGO_15(0.15),
    RECARGO_10(0.10),
    RECARGO_5(0.05);

    private double recargo;

    private Recargos(double recargo){
        this.recargo = recargo;
    }

    public double getRecargo() {
        return recargo;
    }

    public void setRecargo(double recargo) {
        this.recargo = recargo;
    }  
}
