package es.etg.daw.prog.mercadaw.model.entities.compras;

public class Cliente {
    private static int numClientes;

    private Integer id;
    private String nombre;
    private String correo;
    private String codPostal;

    public Cliente(Integer id, String nombre, String correo, String codPostal) {
        if (id == null) {
            this.id = numClientes;
            numClientes++;
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

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

}
