package es.etg.daw.prog.mercadaw.model.bbdd;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import es.etg.daw.prog.mercadaw.model.entities.empleados.Empleado;
import es.etg.daw.prog.mercadaw.model.util.export.DocumentoFactory;
import es.etg.daw.prog.mercadaw.model.util.export.Exportable;

@TestMethodOrder(OrderAnnotation.class)
public class ExportOfficeTest {

    private static MercaDAW mercadaw = new MercaDAW();

    @BeforeAll
    public static void init() {
        List<Empleado> empleados = new ArrayList<>();

        Empleado.add(new Empleado("nuevo1", "nuevo1", 1));
        Empleado.add(new Empleado("nuevo2", "nuevo2", 2));
        Empleado.add(new Empleado("nuevo3", "nuevo3", 3));

        mercadaw.setEmpleados(empleados);

    }

    @Test
    public void exportarPDF() throws Exception {
        FileOutputStream fichero = new FileOutputStream("test.pdf");

        fichero.write(DocumentoFactory.obtener(Exportable.PDF).crearFichero(mercadaw));
        fichero.close();
    }

    @Test
    public void exportarExcel() throws Exception {
        FileOutputStream fichero = new FileOutputStream("test.xlsx");

        fichero.write(DocumentoFactory.obtener(Exportable.EXCEL).crearFichero(mercadaw));
        fichero.close();
    }

}
