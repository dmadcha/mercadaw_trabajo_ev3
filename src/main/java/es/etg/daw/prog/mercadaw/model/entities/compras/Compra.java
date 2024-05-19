package es.etg.daw.prog.mercadaw.model.entities.compras;

import java.sql.Date;
import java.util.List;

import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;

public class Compra {
    private static int numCompras;

    private Integer id;
    private Date fecha;
    private Cliente cliente;
    private List<Producto> productos;

    public Compra(Integer id, Date fecha, Cliente cliente, List<Producto> productos) {
        if (id == null) {
            numCompras+= productos.size();
            this.id = numCompras;
        } else {
            this.id = id;
        }
        this.fecha = fecha;
        this.cliente = cliente;
        this.productos = productos;

        
    }

    public static int getNumCompras() {
        return numCompras;
    }

    public static void setNumCompras(int numCompras) {
        Compra.numCompras = numCompras;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
