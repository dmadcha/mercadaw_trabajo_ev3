package es.etg.daw.prog.mercadaw.model.entities.productos;

import static es.etg.daw.prog.mercadaw.model.entities.productos.Porcentajes.PORCENTAJE_10;
import static es.etg.daw.prog.mercadaw.model.entities.productos.Porcentajes.PORCENTAJE_15;
import static es.etg.daw.prog.mercadaw.model.entities.productos.Porcentajes.PORCENTAJE_5;
import static es.etg.daw.prog.mercadaw.model.entities.productos.Recargos.RECARGO_10;
import static es.etg.daw.prog.mercadaw.model.entities.productos.Recargos.RECARGO_15;
import static es.etg.daw.prog.mercadaw.model.entities.productos.Recargos.RECARGO_5;

public abstract class Producto implements Producible {
    public static final String ATT_ID = "id";
    public static final String ATT_NOMBRE = "nombre";
    public static final String ATT_MARCA = "marca";
    public static final String ATT_CATEGORIA = "categoria";
    public static final String ATT_ALTURA = "altura";
    public static final String ATT_ANCHURA = "anchura";
    public static final String ATT_PESO = "peso";
    public static final String ATT_ELEMENTOS = "elementos";
    public static final String ATT_DESCRIPCION = "descripcion";
    public static final String ATT_STOCK = "stock";
    public static final String ATT_PRECIO = "precio";
    public static final String ATT_IVA = "iva";

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
    private double precio;
    protected double iva;

    public Producto(Integer id, String nombre, String marca, double altura, double anchura,
            double peso, int numElementos, int stock, double precio, String descripcion) {
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

    public double getRecargoAltura() {
        double recargoAltura = 0;

        if (altura > ALTURA_MIN) {
            recargoAltura = getPrecioVenta() * RECARGO_10.getRecargo();
        } else {
            recargoAltura = getPrecioVenta() * RECARGO_5.getRecargo();
        }

        return recargoAltura;
    }

    public double getPorcentajeAltura() {
        double porcentajeAltura = 0;

        if (altura > ALTURA_MIN) {
            porcentajeAltura = PORCENTAJE_10.getPorcentaje();
        } else  {
            porcentajeAltura = PORCENTAJE_5.getPorcentaje();
        }

        return porcentajeAltura;
    }

    public double getRecargoAnchura() {
        double recargoAnchura = 0;

        if (anchura > ALTURA_MIN) {
            recargoAnchura = getPrecioVenta() * RECARGO_10.getRecargo();
        } else {
            recargoAnchura = getPrecioVenta() * RECARGO_5.getRecargo();
        }

        return recargoAnchura;
    }

    public double getPorcentajeAnchura() {
        double porcentajeAnchura = 0;

        if (anchura > ALTURA_MIN) {
            porcentajeAnchura = PORCENTAJE_10.getPorcentaje();
        } else  {
            porcentajeAnchura = PORCENTAJE_5.getPorcentaje();
        }

        return porcentajeAnchura;
    }

    public double getRecargoNumElementos(){
        final int NUM_ELEMENTOS_MAX = 2;
        final double GASTO_ADICIONAL = 0.10;

        double recargoNumElementos = 0;

        if (numElementos > NUM_ELEMENTOS_MAX) {
            recargoNumElementos = getPrecioVenta() * GASTO_ADICIONAL;
        } 

        return recargoNumElementos;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (obj == null)
            return false;

        Producto otro = (Producto) obj;
        if (!otro.id.equals(this.id))
            return false;
        if (!otro.nombre.equals(this.nombre))
            return false;
        if (!otro.marca.equals(this.marca))
            return false;
        if (otro.altura != this.altura)
            return false;
        if (otro.anchura != this.anchura)
            return false;
        if (otro.peso != this.peso)
            return false;
        if (otro.numElementos != this.numElementos)
            return false;
        if (otro.precio != this.precio)
            return false;
        if (otro.stock != this.stock)
            return false;
        if (!otro.descripcion.equals(this.descripcion))
            return false;
        return true;
    }
}
