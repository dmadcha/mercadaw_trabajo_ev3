package es.etg.daw.prog.mercadaw.model.util.export;

import java.util.Map;

/**
 * La interfaz Documento nos permite definir las partes en la que estará compuesto un documento.
 * \Iván Rafael Redondo.
 */
public interface Documento {

    public String getTituto();
    public Map<String, Object[]> getContenido();
    public String getPie();
}
