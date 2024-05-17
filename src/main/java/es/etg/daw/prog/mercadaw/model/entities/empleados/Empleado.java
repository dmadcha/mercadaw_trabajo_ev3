package es.etg.daw.prog.mercadaw.model.entities.empleados;

public class Empleado implements Contratable {

    private static int numEmpleados;

    private int id;
    private String nombre;
    private String apellidos;
    private double sueldo;

    public Empleado(int id, String nombre, String apellidos) {
        this.id = numEmpleados;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sueldo = SUELDO_EMPLE;

        numEmpleados++;
    }

    public static int getNumEmpleados() {
        return numEmpleados;
    }

    public static void setNumEmpleados(int numEmpleados) {
        Empleado.numEmpleados = numEmpleados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public double calcularNomina() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularNomina'");
    }

    @Override
    public String toString() {
        return TipoEmpleado.EMPLEADO.toString();
    }

}
