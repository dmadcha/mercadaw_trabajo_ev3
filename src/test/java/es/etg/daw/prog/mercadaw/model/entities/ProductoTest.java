package es.etg.daw.prog.mercadaw.model.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import es.etg.daw.prog.mercadaw.model.bbdd.MercaDAO;
import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;
import es.etg.daw.prog.mercadaw.model.entities.productos.ProductoFactory;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;

public class ProductoTest {
    
    Producto producto1;
    Producto producto2;
    MercaDAO db;

    // Importante abrir la base de datos primero (Ejecutar el docker compose up y la prueba de jesus)
    @Test
    public void testCrearProducto() throws MercaDAWException, SQLException{
        producto1 = ProductoFactory.obtener("Drogueria", null, "Cafetera Express", "BaristaPro", 35, 20, 4.5, 1, 23, 342.92, "Su diseño compacto y elegante se adapta a cualquier cocina");
        producto2 = ProductoFactory.obtener("Drogueria", null, "Juego de Ollas de Cocina", "ChefMaster", 45, 30, 6.2, 10, 42, 210, "Son ideales para cocinar todo tipo de recetas.");
        assertEquals(1, producto1.getId());
        assertEquals(2, producto2.getId());
    }

    @Test
    public void testCalcularIva() throws MercaDAWException, SQLException{
        producto1 = ProductoFactory.obtener("Alimentacion", null, "nom", "marc", 0.20, 0.20, 0.4, 1, 1, 1, "Si");

        double resultado = producto1.getRecargoPeso();
        double resultadoEsperado = 0.06;
        int margenError = 2;

        assertEquals(resultadoEsperado, resultado, margenError);
    }

    @Test
    public void testPesoMinimo() throws MercaDAWException, SQLException{
        producto1 = ProductoFactory.obtener("Alimentacion", null, "nom", "marc", 1, 1, 1, 1, 1, 1, "Si");
        
        double resultado = producto1.getRecargoPeso();
        double resultadoEsperado = 0.06;
        int margenError = 2;

        assertEquals(resultadoEsperado, resultado, margenError);
    }

    @Test
    public void testAlturaMaxima() throws MercaDAWException, SQLException{
        producto1 = ProductoFactory.obtener("Alimentacion", null, "nom", "marc", 0.6, 1, 1, 1, 1, 1, "Si");
        

        double resultado = producto1.getRecargoAltura();
        double resultadoEsperado = 0.13;
        int margenError = 2;

        assertEquals(resultadoEsperado, resultado, margenError);
    }

    @Test
    public void testAnchuraMinima() throws MercaDAWException, SQLException{
        producto1 = ProductoFactory.obtener("Alimentacion", null, "nom", "marc", 1, 0.1, 1, 1, 1, 1, "Si");
        
        double resultado = producto1.getRecargoAnchura();
        double resultadoEsperado = 0.06;
        int margenError = 2;

        assertEquals(resultadoEsperado, resultado, margenError);
    }

    @Test
    public void testNumElementosMax() throws MercaDAWException, SQLException{
        producto1 = ProductoFactory.obtener("Alimentacion", null, "nom", "marc", 1, 1, 1, 3, 1, 1, "Si");
        
        double resultado = producto1.getRecargoNumElementos();
        double resultadoEsperado = 1.35;
        int margenError = 2;

        assertEquals(resultadoEsperado, resultado, margenError);
    }

    @Test
    public void testPrecioFinal() throws MercaDAWException, SQLException{
        producto1 = ProductoFactory.obtener("Alimentacion", null, "nom", "marc", 0.20, 0.20, 0.4, 1, 1, 1, "Si");

        double resultado = producto1.getPrecioFinalEuros();
        double resultadoEsperado = 1.44;
        int margenError = 2;

        assertEquals(resultadoEsperado, resultado, margenError);
    }
}
