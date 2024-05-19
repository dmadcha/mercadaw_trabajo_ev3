package es.etg.daw.prog.mercadaw.model.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;
import es.etg.daw.prog.mercadaw.model.entities.productos.ProductoFactory;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;

public class ProductoTest {
    
    Producto producto1;
    Producto producto2;

    @Test
    public void testCrearProducto() throws MercaDAWException{
        producto1 = ProductoFactory.obtener("Drogueria", null, "Cafetera Express", "BaristaPro", 35, 20, 4.5, 1, 23, 342.92, "La Cafetera Express Automática de BaristaPro ofrece una experiencia de café de calidad profesional en la comodidad de tu hogar. Con una bomba de presión de 15 bares y un sistema de calentamiento rápido, esta cafetera prepara espresso, cappuccino y latte con un sabor y aroma inigualables. Su diseño compacto y elegante se adapta a cualquier cocina");
        producto2 = ProductoFactory.obtener("Drogueria", null, "Juego de Ollas de Cocina", "ChefMaster", 45, 30, 6.2, 10, 42, 210, "El Juego de Ollas de Cocina ChefMaster incluye 10 piezas esenciales para cualquier cocina. Fabricadas con acero inoxidable de alta calidad y fondo de aluminio encapsulado para una distribución uniforme del calor, estas ollas y sartenes son ideales para cocinar todo tipo de recetas. El set incluye 2 cacerolas con tapa, 2 ollas con tapa, 1 sartén grande y 1 sartén pequeña, perfectas para cocineros principiantes y expertos. Apta para lavavajillas y compatible con todas las superficies de cocina, incluyendo inducción.");
        assertEquals(1, producto1.getId());
        assertEquals(2, producto2.getId());
    }

    @Test
    public void testCalcularIva() throws MercaDAWException{
        producto1 = ProductoFactory.obtener("Alimentacion", null, "nom", "marc", 0.20, 0.20, 0.4, 1, 1, 1, "Si");

        double resultado = producto1.getRecargoPeso();
        double resultadoEsperado = 0.06;
        int margenError = 2;

        assertEquals(resultadoEsperado, resultado, margenError);
    }

    @Test
    public void testPesoMinimo() throws MercaDAWException{
        producto1 = ProductoFactory.obtener("Alimentacion", null, "nom", "marc", 1, 1, 1, 1, 1, 1, "Si");
        
        double resultado = producto1.getRecargoPeso();
        double resultadoEsperado = 0.06;
        int margenError = 2;

        assertEquals(resultadoEsperado, resultado, margenError);
    }

    @Test
    public void testAlturaMaxima() throws MercaDAWException{
        producto1 = ProductoFactory.obtener("Alimentacion", null, "nom", "marc", 0.6, 1, 1, 1, 1, 1, "Si");
        

        double resultado = producto1.getRecargoAltura();
        double resultadoEsperado = 0.13;
        int margenError = 2;

        assertEquals(resultadoEsperado, resultado, margenError);
    }

    @Test
    public void testAnchuraMinima() throws MercaDAWException{
        producto1 = ProductoFactory.obtener("Alimentacion", null, "nom", "marc", 1, 0.1, 1, 1, 1, 1, "Si");
        
        double resultado = producto1.getRecargoAnchura();
        double resultadoEsperado = 0.06;
        int margenError = 2;

        assertEquals(resultadoEsperado, resultado, margenError);
    }

    @Test
    public void testNumElementosMax() throws MercaDAWException{
        producto1 = ProductoFactory.obtener("Alimentacion", null, "nom", "marc", 1, 1, 1, 3, 1, 1, "Si");
        
        double resultado = producto1.getRecargoNumElementos();
        double resultadoEsperado = 1.35;
        int margenError = 2;

        assertEquals(resultadoEsperado, resultado, margenError);
    }

    @Test
    public void testPrecioFinal() throws MercaDAWException{
        producto1 = ProductoFactory.obtener("Alimentacion", null, "nom", "marc", 0.20, 0.20, 0.4, 1, 1, 1, "Si");

        double resultado = producto1.getPrecioFinalEuros();
        double resultadoEsperado = 1.44;
        int margenError = 2;

        assertEquals(resultadoEsperado, resultado, margenError);
    }
}
