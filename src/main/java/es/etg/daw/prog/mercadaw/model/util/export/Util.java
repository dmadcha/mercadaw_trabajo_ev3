package es.etg.daw.prog.mercadaw.model.util.export;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.poi.ooxml.POIXMLDocument;

public abstract class Util implements ExportableUtil {

     @Override
    public abstract byte[] crearFichero(Documento documento) throws Exception ;

    protected byte[] convertir(POIXMLDocument documento) throws IOException{
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        documento.write(out); 
        out.close();
        return out.toByteArray();
    }
    
}
