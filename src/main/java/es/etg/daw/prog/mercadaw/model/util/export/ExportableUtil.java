package es.etg.daw.prog.mercadaw.model.util.export;


/**
 * La interfaz ExportableUtil nos permitira que la clase Util pueda 
 * exportar con cualquier tipo de extensión.
 * \author Iván Rafael Redondo.
 */
public interface ExportableUtil {

  public void exportar(String nombreArcSal, String nombreArcEnt, String extension, String rutaArcEnt) throws Exception;
  public String getUser() throws Exception;
  public String getGrupo() throws Exception;
} 
