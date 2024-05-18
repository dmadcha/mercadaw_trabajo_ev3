package es.etg.daw.prog.mercadaw.model.util.export;

public interface ExportableUtil {

  public void exportar(String ruta) throws Exception;
  public String getUser() throws Exception;
  public String getGrupo() throws Exception;
} 
