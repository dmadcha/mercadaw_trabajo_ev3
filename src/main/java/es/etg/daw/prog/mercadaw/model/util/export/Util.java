package es.etg.daw.prog.mercadaw.model.util.export;

import java.io.IOException;

/**
 * La clase Util sirve para exportar un documento usando pandoc y getUser() y getGrupo().
 * \author Iván Rafael Redondo.
 */
public class Util implements ExportableUtil {

    @Override
    public void exportar(String nombreArcSal, String nombreArcEnt, String extension, String rutaArcEnt) throws Exception{
        
        String[] user = {"id", "-u"};
        String[] grupo = {"id", "-g"};
        try {
            String userId = this.ejecutarComando(user).trim();
            String groupId = this.ejecutarComando(grupo).trim();
    
            String[] commando = {
                "docker", "run", "--rm",
                "--volume", rutaArcEnt + ":/data",
                "--user", userId + ":" + groupId,
                "pandoc/extra", nombreArcEnt, "-o", nombreArcSal + "." + extension
            };
    
            ProcessBuilder processBuilder = new ProcessBuilder(commando);
            processBuilder.start();
    
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String ejecutarComando(String[] ejec) throws IOException, InterruptedException {
        Runtime.getRuntime().exec(ejec);
        StringBuilder salida = new StringBuilder();
    
        return salida.toString();
    }
}
