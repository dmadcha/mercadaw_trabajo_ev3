package es.etg.daw.prog.mercadaw.model.util.input;


/**
 * Esta interface nos permite escribir y leer un fichero de forma binaria.
 * \author: Iván Rafael Redondo
 */
public interface Fichero {

  public void escribir(String fichero, String texto);
  public byte[] leer(String fichero);
} 
