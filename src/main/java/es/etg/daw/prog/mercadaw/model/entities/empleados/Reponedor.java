package es.etg.daw.prog.mercadaw.model.entities.empleados;

public class Reponedor extends Empleado{
    private double sueldo;

    public Reponedor(String nombre, String apellidos) {
        super(nombre, apellidos);
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
