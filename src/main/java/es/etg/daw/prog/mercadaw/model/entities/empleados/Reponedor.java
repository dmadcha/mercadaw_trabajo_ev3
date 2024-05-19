package es.etg.daw.prog.mercadaw.model.entities.empleados;

import java.sql.Date;

public class Reponedor extends Empleado{
    private double sueldo;

    public Reponedor(Integer id, String nombre, String apellidos, Date fechaInicio) {
        super(id, nombre, apellidos, fechaInicio);
        this.sueldo = SUELDO_REPON;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return TipoEmpleado.REPONEDOR.toString();
    }
}
