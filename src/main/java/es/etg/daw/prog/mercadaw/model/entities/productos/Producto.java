package es.etg.daw.prog.mercadaw.model.entities.productos;

public abstract class Producto implements Producible {

    private static int numProductos;

    private Integer id;
    private String nombre;
    private String marca;
    private double altura;
    private double anchura;
    private double peso;
    private int numElementos;
    private String descripcion;
    private int stock;
    protected double iva;

    public Producto(Integer id, String nombre, String marca, double altura, double anchura,
            double peso, int numElementos, int stock, String descripcion) {
        if (id == null) {
            this.id = numProductos;
            numProductos++;
        } else {
            this.id = id;
        }
        this.nombre = nombre;
        this.marca = marca;
        this.altura = altura;
        this.anchura = anchura;
        this.peso = peso;
        this.numElementos = numElementos;
        this.stock = stock;
        this.descripcion = descripcion;

    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public static int getNumProductos() {
        return numProductos;
    }

    public static void setNumProductos(int numProductos) {
        Producto.numProductos = numProductos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getAnchura() {
        return anchura;
    }

    public void setAnchura(double anchura) {
        this.anchura = anchura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getNumElementos() {
        return numElementos;
    }

    public void setNumElementos(int numElementos) {
        this.numElementos = numElementos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public double getPrecioVenta() {
        // TODO Auto-generated method stub
        return 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
