package es.etg.daw.prog.mercadaw.model.util.export;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util implements ExportableUtil {

    @Override
    public void exportar(String ruta) throws Exception {
        String archivoSalida = "EXPORT.%s";
        String extension = "pdf";

        String[] command = {
                "sudo", "docker", "run", "--rm",
                "--volume", ruta + ":/data",
                "--user", getUser() + ":" + getGrupo(),
                "pandoc/extra", "README.md", "-o", archivoSalida.format(archivoSalida, extension)
        };

        try {
            Process process = Runtime.getRuntime().exec(command);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getUser() throws Exception{
        String[] command = { "id", "-u" };
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        return reader.readLine();
    }

    @Override
    public String getGrupo() throws Exception{

        String[] command = { "id", "-g" };
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        return reader.readLine();
    }

}
