package es.etg.daw.prog.mercadaw.model.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;
import es.etg.daw.prog.mercadaw.model.entities.productos.ProductoFactory;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;

public class ProductoTest {
    @Test
    public void crearProducto() throws MercaDAWException{
        ProductoFactory.obtener("Drogueria", null, "Cafetera Express", "BaristaPro", 35, 20, 4.5, 1, "La Cafetera Express Automática de BaristaPro ofrece una experiencia de café de calidad profesional en la comodidad de tu hogar. Con una bomba de presión de 15 bares y un sistema de calentamiento rápido, esta cafetera prepara espresso, cappuccino y latte con un sabor y aroma inigualables. Su diseño compacto y elegante se adapta a cualquier cocina");
        assertEquals(1, Producto.getNumProductos());
        ProductoFactory.obtener("Drogueria", null, "Juego de Ollas de Cocina", "ChefMaster", 45, 30, 6.2, 10, "El Juego de Ollas de Cocina ChefMaster incluye 10 piezas esenciales para cualquier cocina. Fabricadas con acero inoxidable de alta calidad y fondo de aluminio encapsulado para una distribución uniforme del calor, estas ollas y sartenes son ideales para cocinar todo tipo de recetas. El set incluye 2 cacerolas con tapa, 2 ollas con tapa, 1 sartén grande y 1 sartén pequeña, perfectas para cocineros principiantes y expertos. Apta para lavavajillas y compatible con todas las superficies de cocina, incluyendo inducción.");
        assertEquals(2, Producto.getNumProductos());
    }
}
