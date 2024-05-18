package es.etg.daw.prog.mercadaw.model.entities.empleados;

public class Encargado extends Empleado{
    private double sueldo;

    public Encargado(Integer id, String nombre, String apellidos) {
        super(id, nombre, apellidos);
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
