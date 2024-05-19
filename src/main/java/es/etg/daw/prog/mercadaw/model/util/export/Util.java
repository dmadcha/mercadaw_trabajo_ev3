package es.etg.daw.prog.mercadaw.model.util.export;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util implements ExportableUtil {

    @Override
    public void exportar(String nombreArcSal, String nombreArcEnt, String extension, String rutaArcEnt) throws Exception{
        
        String[] command = {
            "sudo", "docker", "run", "--rm",
            "--volume", rutaArcEnt + ":/data",
            "--user", getUser() + ":" + getGrupo(),
            "pandoc/extra", nombreArcEnt, "-o", nombreArcSal.format(nombreArcSal, extension)
        };

        try {
            Runtime.getRuntime().exec(command);
                
        } catch (IOException e) {
            e.printStackTrace();   
        }
    }

    // Método para obtener el ID del usuario actual
    @Override
    public String getUser() throws Exception{

        String[] command = {"id", "-u"};
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        return reader.readLine();
        
    }

    // Método para obtener el ID del usuario actual
    @Override
    public String getGrupo() throws Exception{
        
        String[] command = {"id", "-g"};
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        return reader.readLine();
    }

}
