package es.etg.daw.prog.mercadaw.model.util;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;
import es.etg.daw.prog.mercadaw.model.util.reader.Lector;
import es.etg.daw.prog.mercadaw.model.util.reader.LectorJSON;

public class JSONTest {

    @Test
    public void cargarProducto() throws MercaDAWException, SQLException {
        final String cadena = "[\n" +
                "    {\n" +
                "      \"Tipo\": \"Cosmetica\",\n" +
                "      \"Id\": \"1\",\n" +
                "      \"Nombre\": \"Producto1\",\n" +
                "      \"Marca\": \"Marca1\",\n" +
                "      \"Altura\": \"1.1\",\n" +
                "      \"Anchura\": \"1.2\",\n" +
                "      \"Peso\": \"1.3\",\n" +
                "      \"NumElementos\": \"3\",\n" +
                "      \"Descripcion\": \"Descripcion1\",\n" +
                "      \"Stock\": \"10\",\n" +
                "      \"Precio\": \"100.0\"\n" +
                "    }\n" +
                "  ]";

        Lector lector = new LectorJSON();

        lector.leerProducto(cadena);

    }

    @Test
    public void cargarEmpleado() throws MercaDAWException, SQLException {

        final String cadena = "[\n" + 
                "    {\n" + 
                "       \"Tipo\":\"Cajero\",\n" + 
                "       \"Id\":\"1\",\n" + 
                "       \"Nombre\":\"Paco\",\n" + 
                "       \"Apellidos\":\"Taco\",\n" + 
                "       \"FechaInicio\":\"2023-09-05\",\n" + 
                "    }\n" + 
                "   ]";
        Lector lector = new LectorJSON();

        lector.leerEmpleado(cadena);

    }

    @Test
    public void cargarCliente() throws MercaDAWException, SQLException {
        final String cadena = "[\n" +
                "    {\n" +
                "      \"Id\": \"1\",\n" +
                "      \"Nombre\": \"Alex\",\n" +
                "      \"Correo\": \"alex@gmail.com\",\n" +
                "      \"CodigoPostal\": \"12345\",\n" +
                "    }\n" +
                "  ]";

        Lector lector = new LectorJSON();

        lector.leerCliente(cadena);

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
