package es.etg.daw.prog.mercadaw.model.util.input;

public class FicheroFactory {
    public static Fichero obtener(FormatoBinarios formato){
        if (formato == FormatoBinarios.BINARIO ) {
            return new FicheroBinario();
        }else{
            return new FicheroMock();
        }
    }
}
