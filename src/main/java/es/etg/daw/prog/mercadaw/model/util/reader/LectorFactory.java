package es.etg.daw.prog.mercadaw.model.util.reader;

public class LectorFactory {
    public static Lector obtener(Formato formato) {
        if (formato == Formato.CSV) {
            return new LectorCSV();
        } else {
            return new LectorJSON();
        }
    }
}
