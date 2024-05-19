package es.etg.daw.prog.mercadaw.model.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;
import es.etg.daw.prog.mercadaw.model.util.reader.Lector;
import es.etg.daw.prog.mercadaw.model.util.reader.LectorJSON;

public class JSONTest {
    @Test
    public void cargarCadenaVaciaTestProducto() {
        String cadena = "";
        Lector lector = new LectorJSON();

        MercaDAWException thorwn = Assertions.assertThrows(MercaDAWException.class, () -> {
            lector.leerProducto(cadena);
        });

    }

     @Test
    public void cargarCadenaVaciaTestEmpleado() {
        String cadena = "";
        Lector lector = new LectorJSON();

        MercaDAWException thorwn = Assertions.assertThrows(MercaDAWException.class, () -> {
            lector.leerEmpleado(cadena);
        });

    }

     @Test
    public void cargarCadenaVaciaTestCliente() {
        String cadena = "";
        Lector lector = new LectorJSON();

        MercaDAWException thorwn = Assertions.assertThrows(MercaDAWException.class, () -> {
            lector.leerCliente(cadena);
        });

    }
}
