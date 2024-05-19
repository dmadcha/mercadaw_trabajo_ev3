package es.etg.daw.prog.mercadaw.model.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;

import es.etg.daw.prog.mercadaw.model.util.export.Util;

public class ExportOfficeTest {
    @Test
    void exportar() {
        
        String ruta = "/home/usuario/Desktop/mercadaw_trabajo_ev3/Prueba.md"; // Ruta válida en tu sistema de archivos
        Util exportador = new Util();

        assertDoesNotThrow(() -> {
            exportador.exportar(ruta);
        });

        String rutaPDF = "/home/usuario/Desktop/mercadaw_trabajo_ev3/Prueba";
        File archivoPDF = new File(rutaPDF);
        assertTrue(archivoPDF.exists());
    }
}