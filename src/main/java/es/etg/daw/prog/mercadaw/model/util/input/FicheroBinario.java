package es.etg.daw.prog.mercadaw.model.util.input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FicheroBinario extends FicheroImp {

    @Override
    public void escribir(File fichero, String texto) {

        try (FileOutputStream fos = new FileOutputStream(fichero)) {

            byte codigos[] = texto.getBytes();

            fos.write(codigos);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public byte[] leer(File fichero) {

        byte[] datos = null;

        try (FileInputStream fis = new FileInputStream(fichero)) {
            datos = fis.readAllBytes();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return datos;

    }

}