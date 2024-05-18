package es.etg.daw.prog.mercadaw.model.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.etg.daw.prog.mercadaw.model.util.input.FicheroBinario;

public class FicheroBinarioTest {

    private static final String TEST_FILE = "fichero.txt";

   

    @Test
    public void escribitTest() throws Exception{
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        File archivo = new File("test.txt");
        String texto = "Hola, mundo!";

        escribir(archivo, texto);

        assertEquals(texto, outputStream.toString());
    }
    @Test
    public void leerTest() throws Exception {
        FicheroBinario fileTest = new FicheroBinario();
        byte[] expectedBytes = "Hola, mundo!".getBytes();
        byte[] actualBytes = fileTest.leer(TEST_FILE);
        assertArrayEquals(expectedBytes, actualBytes);
    }

    

}
