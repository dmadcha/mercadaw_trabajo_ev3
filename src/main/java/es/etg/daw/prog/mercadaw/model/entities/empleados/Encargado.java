package es.etg.daw.prog.mercadaw.model.entities.empleados;

import java.sql.Date;

import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;

/**
 * La clase Encargado representa un encargado de MercaDAW.
 * \author Diego Madroñero Chamorro.
 */
public class Encargado extends Empleado{
    private double sueldo;

    /**
     * Constructor que inicializa encargados, generando el ID de estas automaticamente.
     * \param Id del empleado
     * \param Nombre del empleado
     * \param Apellidos del empleado
     * \param Fecha de contratación del empleado
     * \throws MercaDAWException  
     */
    public Encargado(Integer id, String nombre, String apellidos, Date fechaInicio) throws MercaDAWException {
        super(id, nombre, apellidos, fechaInicio);
        this.sueldo = SUELDO_ENCAR;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return TipoEmpleado.ENCARGADO.toString();
    }
}
