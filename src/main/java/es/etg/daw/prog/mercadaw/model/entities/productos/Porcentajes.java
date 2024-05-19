package es.etg.daw.prog.mercadaw.model.entities.productos;

/**
 * La enumeracion Recargos representa los porcentajes posibles y su valor correspondiente.
 * \author Diego Madroñero Chamorro.
 */
public enum Porcentajes {
    PORCENTAJE_5(5),
    PORCENTAJE_10(10),
    PORCENTAJE_15(15);

    private double porcentaje;

    private Porcentajes(double porcentaje){
        this.porcentaje = porcentaje;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }    
}
