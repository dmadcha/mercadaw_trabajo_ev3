package es.etg.daw.prog.mercadaw.model.entities.empleados;

public class Cajero extends Empleado{
    private double sueldo;

    public Cajero(int id, String nombre, String apellidos) {
        super(id, nombre, apellidos);
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
