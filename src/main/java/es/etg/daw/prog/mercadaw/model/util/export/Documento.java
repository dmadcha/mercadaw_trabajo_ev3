package es.etg.daw.prog.mercadaw.model.util.export;

import java.util.Map;

public interface Documento {

    public String getTituto();
    public Map<String, Object[]> getContenido();
    public String getPie();
}
