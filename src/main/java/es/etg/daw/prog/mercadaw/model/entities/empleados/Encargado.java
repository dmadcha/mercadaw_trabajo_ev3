package es.etg.daw.prog.mercadaw.model.entities.empleados;

import java.sql.Date;

public class Encargado extends Empleado{
    private double sueldo;

    public Encargado(Integer id, String nombre, String apellidos, Date fechaInicio) {
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
