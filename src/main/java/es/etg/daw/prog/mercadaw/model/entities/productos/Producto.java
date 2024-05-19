package es.etg.daw.prog.mercadaw.model.entities.productos;

import static es.etg.daw.prog.mercadaw.model.entities.productos.Porcentajes.PORCENTAJE_10;
import static es.etg.daw.prog.mercadaw.model.entities.productos.Porcentajes.PORCENTAJE_15;
import static es.etg.daw.prog.mercadaw.model.entities.productos.Porcentajes.PORCENTAJE_5;
import static es.etg.daw.prog.mercadaw.model.entities.productos.Recargos.RECARGO_10;
import static es.etg.daw.prog.mercadaw.model.entities.productos.Recargos.RECARGO_15;
import static es.etg.daw.prog.mercadaw.model.entities.productos.Recargos.RECARGO_5;

/**
 * La clase Producto representa un producto de MercaDAW.
 * \author Diego Madroñero Chamorro.
 */
public abstract class Producto implements Producible {

    private static int numProductos = 0;

    private Integer id;
    private String nombre;
    private String marca;
    private double altura;
    private double anchura;
    private double peso;
    private int numElementos;
    private String descripcion;
    private int stock;
    private double precio;
    protected double iva;

    /**
     * Constructor que inicializa productos, generando el ID de estos automaticamente.
     * \param id
     * \param nombre
     * \param marca
     * \param altura
     * \param anchura
     * \param peso
     * \param numElementos
     * \param stock
     * \param precio
     * \param descripcion
     */
    public Producto(Integer id, String nombre, String marca, double altura, double anchura,
            double peso, int numElementos, int stock, double precio, String descripcion) {
        if (id == null) {
            numProductos++;
            this.id = numProductos;
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
        this.precio = precio;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public double getPrecioVenta() {
        final double INCREMENTO = 1.25;

        double precioVenta = 0;

        precioVenta = precio * INCREMENTO;

        return precioVenta;
    }

    /**
     * Calcula y devuelve el recargo dependiendo del peso del producto.
     * \return Un double con el recargo del peso.
     */
    public double getRecargoPeso() {
        double recargoPeso = 0;

        if (peso > PESO_MAX) {
            recargoPeso = getPrecioVenta() * RECARGO_15.getRecargo();
        } else if (peso > PESO_MIN) {
            recargoPeso = getPrecioVenta() * RECARGO_10.getRecargo();
        } else {
            recargoPeso = getPrecioVenta() * RECARGO_5.getRecargo();
        }

        return recargoPeso;
    }

    /**
     * Calcula y devuelve el porcentaje que se usa para calcular el recargo del peso.
     * \return Un double con el porcentaje del recargo del peso.
     */
    public double getPorcentajePeso() {
        double porcentajePeso = 0;

        if (peso > PESO_MAX) {
            porcentajePeso = PORCENTAJE_15.getPorcentaje();
        } else if (peso > PESO_MIN) {
            porcentajePeso = PORCENTAJE_10.getPorcentaje();
        } else {
            porcentajePeso = PORCENTAJE_5.getPorcentaje();
        }

        return porcentajePeso;
    }

    /**
     * Calcula y devuelve el recargo dependiendo de la altura del producto.
     * \return Un double con el recargo de la altura.
     */
    public double getRecargoAltura() {
        double recargoAltura = 0;

        if (altura > ALTURA_MIN) {
            recargoAltura = getPrecioVenta() * RECARGO_10.getRecargo();
        } else {
            recargoAltura = getPrecioVenta() * RECARGO_5.getRecargo();
        }

        return recargoAltura;
    }

    /**
     * Calcula y devuelve el porcentaje que se usa para calcular el recargo de la altura.
     * \return Un double con el porcentaje del recargo de la altura.
     */
    public double getPorcentajeAltura() {
        double porcentajeAltura = 0;

        if (altura > ALTURA_MIN) {
            porcentajeAltura = PORCENTAJE_10.getPorcentaje();
        } else  {
            porcentajeAltura = PORCENTAJE_5.getPorcentaje();
        }

        return porcentajeAltura;
    }

    /**
     * Calcula y devuelve el recargo dependiendo de la anchura del producto.
     * \return Un double con el recargo de la anchura.
     */
    public double getRecargoAnchura() {
        double recargoAnchura = 0;

        if (anchura > ALTURA_MIN) {
            recargoAnchura = getPrecioVenta() * RECARGO_10.getRecargo();
        } else {
            recargoAnchura = getPrecioVenta() * RECARGO_5.getRecargo();
        }

        return recargoAnchura;
    }

    /**
     * Calcula y devuelve el porcentaje que se usa para calcular el recargo de la anchura.
     * \return Un double con el porcentaje del recargo de la anchura.
     */
    public double getPorcentajeAnchura() {
        double porcentajeAnchura = 0;

        if (anchura > ALTURA_MIN) {
            porcentajeAnchura = PORCENTAJE_10.getPorcentaje();
        } else  {
            porcentajeAnchura = PORCENTAJE_5.getPorcentaje();
        }

        return porcentajeAnchura;
    }

    /**
     * Calcula y devuelve el recargo dependiendo del numero de elementos del producto.
     * \return Un double con el recargo del numero de elementos.
     */
    public double getRecargoNumElementos(){
        final int NUM_ELEMENTOS_MAX = 2;
        final double GASTO_ADICIONAL = 0.10;

        double recargoNumElementos = 0;

        if (numElementos > NUM_ELEMENTOS_MAX) {
            recargoNumElementos = getPrecioVenta() * GASTO_ADICIONAL;
        } 

        return recargoNumElementos;
    }
    
    /**
     * Calcula el precio final de venta de un producto con todos los recargos aplicados.
     * \return Un double con el precio final en euros.
     */
    public double getPrecioFinalEuros(){
        double precioEuros = 0;

        precioEuros = getPrecioVenta() + getRecargoPeso() + getRecargoAltura() + getRecargoAnchura() + getRecargoNumElementos();

        return precioEuros;
    }

    /**
     * Calcula y devuelve el precio final de venta de un producto convertido a dolares.
     * \return Un double con el precio final en dolares.
     */
    public double getPrecioFinalDolares(){
        final double CONVERSION = 0.9;

        double precioDolares = 0;

        precioDolares = getPrecioFinalEuros() / CONVERSION;

        return precioDolares;
    }

    /**
     * Calcula y devuelve el iva calculado de un producto.
     * \return Un double con el iva calculado.
     */
    public double getIvaCalculado(){
        double ivaCalculado = 0;

        ivaCalculado = getPrecioFinalEuros() * getIva();

        return ivaCalculado;
    }
}
