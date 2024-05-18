package es.etg.daw.prog.mercadaw.model.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;


import org.junit.jupiter.api.Test;

import es.etg.daw.prog.mercadaw.model.util.input.FicheroBinario;

public class FicheroBinarioTest {

    File fichero = new File("test.txt");

    FicheroBinario ficheroBinario = new FicheroBinario();
    @Test
    public void leerEscribirTest() throws Exception {
        String textoOriginal = "Hola, este es un texto de prueba.";

        ficheroBinario.escribir(fichero, textoOriginal);

        byte[] datosLeidos = ficheroBinario.leer(fichero);

        String textoLeido = new String(datosLeidos);

        assertEquals(textoOriginal, textoLeido);
    }
}