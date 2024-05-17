package es.etg.daw.prog.mercadaw.model.util.input;

import java.io.FileInputStream;

public class FicheroBinario extends FicheroImp {

     @Override
    public byte[] leer(String fichero){

        byte[] datos = null;   

        try (FileInputStream fis = new FileInputStream(fichero)) {
            datos = fis.readAllBytes();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return datos;

    }
}