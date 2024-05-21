package es.etg.daw.prog.mercadaw.model.util;

import org.junit.jupiter.api.Test;

import es.etg.daw.prog.mercadaw.model.util.export.Util;

public class ExportTest {

     @Test
    public void test() throws Exception{

        Util util = new Util();

        util.exportar("EXPORT", "README.md", "pdf", "/home/usuario/Descargas/mercadaw_trabajo_ev3/");

    }
}
