package es.etg.daw.prog.mercadaw.model.entities.productos;

public class ProductoBuilder {
    private String nombre;
    private String marca;
    private double precio;
    private int iva;
    private double altura;
    private double anchura;
    private double peso;
    private int numElementos;
    private String descripcion;
    
    public String getNombre() {
        return nombre;
    }
    public String getMarca() {
        return marca;
    }
    public double getPrecio() {
        return precio;
    }
    public int getIva() {
        return iva;
    }
    public double getAltura() {
        return altura;
    }
    public double getAnchura() {
        return anchura;
    }
    public double getPeso() {
        return peso;
    }
    public int getNumElementos() {
        return numElementos;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public ProductoBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public ProductoBuilder setMarca(String marca) {
        this.marca = marca;
        return this;
    }
    public ProductoBuilder setPrecio(double precio) {
        this.precio = precio;
        return this;
    }
    public ProductoBuilder setIva(int iva) {
        this.iva = iva;
        return this;
    }
    public ProductoBuilder setAltura(double altura) {
        this.altura = altura;
        return this;
    }
    public ProductoBuilder setAnchura(double anchura) {
        this.anchura = anchura;
        return this;
    }
    public ProductoBuilder setPeso(double peso) {
        this.peso = peso;
        return this;
    }
    public ProductoBuilder setNumElementos(int numElementos) {
        this.numElementos = numElementos;
        return this;
    }
    public ProductoBuilder setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }
}
