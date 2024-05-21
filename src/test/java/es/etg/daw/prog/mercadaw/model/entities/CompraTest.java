package es.etg.daw.prog.mercadaw.model.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.etg.daw.prog.mercadaw.model.entities.compras.Cliente;
import es.etg.daw.prog.mercadaw.model.entities.compras.Compra;
import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;
import es.etg.daw.prog.mercadaw.model.entities.productos.ProductoFactory;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;

public class CompraTest {
    Producto producto1;
    Producto producto2;
    List<Producto> productos;
    Cliente cliente;
    Compra compra1;
    Compra compra2;

    @BeforeEach
    public void creacionCompra() throws MercaDAWException, SQLException {
        producto1 = ProductoFactory.obtener("Drogueria", null, "Cafetera Express", "BaristaPro", 35, 20, 4.5, 1, 23, 342.92, "La Cafetera Express Automática de BaristaPro ofrece una experiencia de café de calidad profesional en la comodidad de tu hogar. Con una bomba de presión de 15 bares y un sistema de calentamiento rápido, esta cafetera prepara espresso, cappuccino y latte con un sabor y aroma inigualables. Su diseño compacto y elegante se adapta a cualquier cocina");
        producto2 = ProductoFactory.obtener("Drogueria", null, "Juego de Ollas de Cocina", "ChefMaster", 45, 30, 6.2, 10, 42, 210, "El Juego de Ollas de Cocina ChefMaster incluye 10 piezas esenciales para cualquier cocina. Fabricadas con acero inoxidable de alta calidad y fondo de aluminio encapsulado para una distribución uniforme del calor, estas ollas y sartenes son ideales para cocinar todo tipo de recetas. El set incluye 2 cacerolas con tapa, 2 ollas con tapa, 1 sartén grande y 1 sartén pequeña, perfectas para cocineros principiantes y expertos. Apta para lavavajillas y compatible con todas las superficies de cocina, incluyendo inducción.");
        productos = new ArrayList<>();
        productos.add(producto1);
        productos.add(producto2);
        cliente = new Cliente(null, "Juan Pérez", "juan@example.com", 28001);
        compra1 = new Compra(null, Date.valueOf("2005-08-14"), cliente, productos);
        compra2 = new Compra(null, Date.valueOf("2001-09-11"), cliente, productos);
    }

    @Test 
    public void crearCompraTest() throws MercaDAWException {
        assertEquals(2, compra1.getId());
        assertEquals(4, compra2.getId());
    }
}
