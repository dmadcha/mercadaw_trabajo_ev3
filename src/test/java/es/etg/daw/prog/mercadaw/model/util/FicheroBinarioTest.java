package es.etg.daw.prog.mercadaw.model.bbdd;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.etg.daw.prog.mercadaw.model.util.input.FicheroBinario;

public class FicheroBinarioTest {

    private static final String TEST_FILE = "fichero.txt";

    @BeforeEach
    public void setUp() throws IOException {
        FileWriter writer = new FileWriter(TEST_FILE);
        writer.write("Hola, mundo!");
        writer.close();
    }

    @Test
    public void testLeerArchivoExistente() throws Exception {
        FicheroBinario fileTest = new FicheroBinario();
        byte[] expectedBytes = "Hola, mundo!".getBytes();
        byte[] actualBytes = fileTest.leer(TEST_FILE);
        assertArrayEquals(expectedBytes, actualBytes);
    }

}
