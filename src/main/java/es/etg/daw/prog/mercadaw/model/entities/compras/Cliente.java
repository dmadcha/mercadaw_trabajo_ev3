package es.etg.daw.prog.mercadaw.model.entities.compras;

public class Cliente {
    private static int numClientes;

    private Integer id;
    private String nombre;
    private String correo;
    private int codPostal;

    public Cliente(Integer id, String nombre, String correo, int codPostal) {
        if (id == null) {
            numClientes++;
            this.id = numClientes;
        } else {
            this.id = id;
        }
        this.nombre = nombre;
        this.correo = correo;
        this.codPostal = codPostal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static int getNumClientes() {
        return numClientes;
    }

    public static void setNumClientes(int numClientes) {
        Cliente.numClientes = numClientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
    }

}
