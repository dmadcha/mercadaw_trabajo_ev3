package es.etg.daw.prog.mercadaw.model.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;
import es.etg.daw.prog.mercadaw.model.util.reader.Lector;
import es.etg.daw.prog.mercadaw.model.util.reader.LectorJSON;

public class JSONTest {


     @Test
    public void cargarProducto() {
        final String cadena = "Cosmetica,1,Producto1,Marca1,10.0,5.0,1.0,3,Descripción1,10,100.0\n" + //
                "";
        Lector lector = new LectorJSON();

        Assertions.assertDoesNotThrow(() -> {
            lector.leerProducto(cadena);
        });
    }

     @Test
    public void cargarEmpleado() {

        final String cadena = "1,Juan,Luis,1000,19/02/2019\n" + //
                "";

        Lector lector = new LectorJSON();

        Assertions.assertDoesNotThrow(() -> {
            lector.leerEmpleado(cadena);
        });
    }

       @Test
    public void cargarCliente() {
        final String cadena = "7,Juan,unodos@gmail.com,1234" + //
                "";

        Lector lector = new LectorJSON();

        Assertions.assertDoesNotThrow(() -> {
            lector.leerCliente(cadena);
        });
    }

    @Test
    public void cargarVacioTestProducto() {
        String cadena = "";
        Lector lector = new LectorJSON();

        MercaDAWException thorwn = Assertions.assertThrows(MercaDAWException.class, () -> {
            lector.leerProducto(cadena);
        });

    }

     @Test
    public void cargarVacioTestEmpleado() {
        String cadena = "";
        Lector lector = new LectorJSON();

        MercaDAWException thorwn = Assertions.assertThrows(MercaDAWException.class, () -> {
            lector.leerEmpleado(cadena);
        });

    }

     @Test
    public void cargarVacioTestCliente() {
        String cadena = "";
        Lector lector = new LectorJSON();

        MercaDAWException thorwn = Assertions.assertThrows(MercaDAWException.class, () -> {
            lector.leerCliente(cadena);
        });

    }
}
