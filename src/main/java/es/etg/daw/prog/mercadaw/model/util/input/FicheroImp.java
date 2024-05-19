package es.etg.daw.prog.mercadaw.model.util.input;

/**
 * La clase abstracta FicheroImp utiliza Fichero, pero no las implementa, si no que permite la herencia
 * para que cada clase los pueda implementar como deba.
 * \author Iván Rafael Redondo.
 */
public abstract class FicheroImp implements Fichero{

    @Override
    public void escribir(String ruta, String texto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'leer'");
    }

   @Override
    public byte[] leer(String fichero) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'leer'");
    }

  
    
}