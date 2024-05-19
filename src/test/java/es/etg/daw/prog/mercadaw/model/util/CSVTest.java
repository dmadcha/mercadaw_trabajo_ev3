package es.etg.daw.prog.mercadaw.model.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;
import es.etg.daw.prog.mercadaw.model.util.reader.Lector;
import es.etg.daw.prog.mercadaw.model.util.reader.LectorCSV;

public class CSVTest {

    @Test
    public void cargarProducto() {
        final String cadena = "Cosmetica,1,Producto1,Marca1,10.0,5.0,1.0,3,Descripción1,10,100.0\n" + //
                "";
        Lector lector = new LectorCSV();

        Assertions.assertDoesNotThrow(() -> {
            lector.leerProducto(cadena);
        });
    }

    @Test
    public void cargarEmpleado() {

        final String cadena = "11,Marco,Ronaldo,1000,19/02/2019\n" + //
                "";

        Lector lector = new LectorCSV();

        Assertions.assertDoesNotThrow(() -> {
            lector.leerEmpleado(cadena);
        });
    }

    @Test
    public void cargarCliente() {
        final String cadena = "7,Juan,unodos@gmail.com,1234" + //
                "";

        Lector lector = new LectorCSV();

        Assertions.assertDoesNotThrow(() -> {
            lector.leerProducto(cadena);
        });
    }

    @Test
    public void cargarCadenaVaciaTestProducto() {
        String cadena = "";
        Lector lector = new LectorCSV();

        MercaDAWException thorwn = Assertions.assertThrows(MercaDAWException.class, () -> {
            lector.leerCliente(cadena);
        });

    }

    @Test
    public void cargarCadenaVaciaTestEmpelado() {
        String cadena = "";
        Lector lector = new LectorCSV();

        MercaDAWException thorwn = Assertions.assertThrows(MercaDAWException.class, () -> {
            lector.leerEmpleado(cadena);
        });

    }

    @Test
    public void cargarCadenaVaciaTestCliente() {
        String cadena = "";
        Lector lector = new LectorCSV();

        MercaDAWException thorwn = Assertions.assertThrows(MercaDAWException.class, () -> {
            lector.leerCliente(cadena);
        });

    }

    

}
