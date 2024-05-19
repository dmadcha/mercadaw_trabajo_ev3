package es.etg.daw.prog.mercadaw.model.entities.empleados;

import java.sql.Date;

/**
 * La clase Cajero representa un cajero de MercaDAW.
 * \author Diego Madroñero Chamorro.
 */
public class Cajero extends Empleado{
    private double sueldo;

    /**
     * Constructor que inicializa cajeros, generando el ID de estas automaticamente.
     * \param id
     * \param nombre
     * \param apellidos
     * \param fechaInicio
     */
    public Cajero(Integer id, String nombre, String apellidos, Date fechaInicio) {
        super(id, nombre, apellidos, fechaInicio);
        this.sueldo = SUELDO_CAJER;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return TipoEmpleado.CAJERO.toString();
    }
}
