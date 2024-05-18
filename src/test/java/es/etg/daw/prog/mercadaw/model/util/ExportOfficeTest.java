package es.etg.daw.prog.mercadaw.model.util;

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

    private static Empleado empleado = new Empleado();

    @BeforeAll
    public void init() {
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado(1, "nuevo1", "Apellido1"));
        empleados.add(new Empleado(2, "nuevo2", "Apellido2"));
        empleados.add(new Empleado(3, "nuevo3", "Apellido3"));

        empleado.setNumEmpleados(emplados);
    }

    @Test
    public void exportarPDF() throws Exception {
        try (FileOutputStream fichero = new FileOutputStream("test.pdf")) {
            byte[] data = DocumentoFactory.obtener(Exportable.PDF).crearFichero(empleados);
            fichero.write(data);
        }
    }

    @Test
    public void exportarExcel() throws Exception {
        try (FileOutputStream fichero = new FileOutputStream("test.xlsx")) {
            byte[] data = DocumentoFactory.crearFichero(empleados);
            fichero.write(data);
        }

    }
}