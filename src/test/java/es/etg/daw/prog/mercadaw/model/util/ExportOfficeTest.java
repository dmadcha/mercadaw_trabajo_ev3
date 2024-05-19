package es.etg.daw.prog.mercadaw.model.util;

import org.junit.jupiter.api.Test;

import es.etg.daw.prog.mercadaw.model.util.export.Util;

public class ExportOfficeTest {

     @Test
    public void test() throws Exception{

        Util util = new Util();

        util.exportar("EXPORT.%s", "Prueba.md", "pdf", "/home/usuario/Desktop/mercadaw_trabajo_ev3/");

    }
}
