package es.etg.daw.prog.mercadaw.model.entities.compras;

public class Cliente {
    private static int numClientes;

    private String nombre;
    private String correo;
    private String codPostal;

    public Cliente(String nombre, String correo, String codPostal) {
        this.nombre = nombre;
        this.correo = correo;
        this.codPostal = codPostal;

        numClientes++;
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
