package es.etg.daw.prog.mercadaw.model.util.input;

import java.io.File;

/**
 * Esta interface nos permite escribir y leer un fichero de forma binaria.
 * @author: Iván Rafael Redondo
 */
public interface Fichero {

  public void escribir(File fichero, String texto);
  public byte[] leer(File fichero);
} 
