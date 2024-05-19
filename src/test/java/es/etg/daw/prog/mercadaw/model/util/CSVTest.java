package es.etg.daw.prog.mercadaw.model.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;
import es.etg.daw.prog.mercadaw.model.util.reader.Lector;
import es.etg.daw.prog.mercadaw.model.util.reader.LectorCSV;

public class CSVTest {

    @Test
    public void cargarProducto() throws MercaDAWException {
        final String cadena =  "Tipo,Id,Nombre,Marca,Altura,Anchura,Peso,NumElementos,Descripcion,stock,precio\n" + //
                                        "Cosmetica,1,Gel,MercaDAW,1.1,1.1,1.1,3,Mola,1,100.0\n" + //
                                        "";
        Lector lector = new LectorCSV();

        lector.leerProducto(cadena);

    }

    @Test
    public void cargarEmpleado() throws MercaDAWException {

        final String cadena =  "Tipo,Id,Nombre,Apellidos,Fecha\n" + //
                                        "Cajero,1,Luis,Felipe Lorca,2023-09-05\n" + //
                                        "";

        Lector lector = new LectorCSV();

        lector.leerEmpleado(cadena);

    }

    @Test
    public void cargarCliente() throws MercaDAWException {
        final String cadena =  "Id,Nombre,Correo,CodigoPostal\n" + //
                                        "1,Paco,paco@gmail.com,12345\n" + //
                                        "";
        Lector lector = new LectorCSV();

        lector.leerCliente(cadena);

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
    public void cargarVacioTestEmpelado() {
        String cadena = "";
        Lector lector = new LectorCSV();

        MercaDAWException thorwn = Assertions.assertThrows(MercaDAWException.class, () -> {
            lector.leerEmpleado(cadena);
        });

    }

    @Test
    public void cargarVacioTestCliente() {
        String cadena = "";
        Lector lector = new LectorCSV();

        MercaDAWException thorwn = Assertions.assertThrows(MercaDAWException.class, () -> {
            lector.leerCliente(cadena);
        });

    }

}
