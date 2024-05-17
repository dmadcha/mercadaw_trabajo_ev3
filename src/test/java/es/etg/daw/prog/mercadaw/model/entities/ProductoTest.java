package es.etg.daw.prog.mercadaw.model.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import es.etg.daw.prog.mercadaw.model.entities.productos.Drogueria;
import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;

public class ProductoTest {
    @Test
    public void crearProducto(){
        Producto pr = new Drogueria();
        assertEquals(1, Producto.getNumProductos());
        Producto pr2 = new Drogueria();
        assertEquals(2, Producto.getNumProductos());
    }
}
