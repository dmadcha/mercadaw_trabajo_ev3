package es.etg.daw.prog.mercadaw.model.entities.empleados;

public class Empleado implements Contratable {
    public static final String ATT_ID_EMPLE = "id";
    public static final String ATT_NOM_EMPLE = "nombre";
    public static final String ATT_APELLIDO = "apellidos";
    public static final String ATT_CATEGORIA = "categoria";
    public static final String ATT_SUELDO = "sueldo";

    private static int numEmpleados;

    private Integer id;
    private String nombre;
    private String apellidos;
    private double sueldo;

    public Empleado(Integer id, String nombre, String apellidos) {

        if (id == null) {
            this.id = numEmpleados;
            numEmpleados++;
        } else {
            this.id = id;
        }
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sueldo = SUELDO_EMPLE;
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

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;

        if (obj ==null)
            return false;

        Empleado otro = (Empleado) obj;
        if(otro.id != this.id)
            return false;
        if(!otro.nombre.equals(this.nombre))
            return false;
        if(!otro.apellidos.equals(this.apellidos))
            return false;
        if(otro.sueldo != this.sueldo)
            return false;
            
        return true;
    }

}
