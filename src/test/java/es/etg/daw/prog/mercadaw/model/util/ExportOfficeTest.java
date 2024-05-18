package es.etg.daw.prog.mercadaw.model.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import es.etg.daw.prog.mercadaw.model.util.export.Util;

public class ExportOfficeTest {

    @Test
    public void exportarTest() {
        Util util = new Util();
        String rutaPrueba = "/home/usuario/Desktop/mercadaw_trabajo_ev3/test.txt"; // Directorio que contiene test.txt

        // Redirigir la salida estándar para capturar cualquier error
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        try {
            util.exportar(rutaPrueba);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Verificar que no hay errores en la salida estándar
        assertEquals("", outputStream.toString().trim(), "La salida no debe contener errores");

        // Verificar que el archivo PDF se haya creado
        File archivoPDF = new File(rutaPrueba + "/test.pdf");
        assertTrue(archivoPDF.exists(), "El archivo PDF debería existir");

    }
}