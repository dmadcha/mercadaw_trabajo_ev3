package es.etg.daw.prog.mercadaw.model.util.input;

public class FicheroFactory {
    public static Fichero obtener(Formato formato){
        if (formato == Formato.BINARIO ) {
            return new FicheroBinario();
        }else{
            return new FicheroMock();
        }
    }
}
