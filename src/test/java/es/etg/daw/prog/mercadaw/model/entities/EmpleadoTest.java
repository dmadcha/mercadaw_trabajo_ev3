package es.etg.daw.prog.mercadaw.model.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import es.etg.daw.prog.mercadaw.model.entities.empleados.Empleado;
import es.etg.daw.prog.mercadaw.model.entities.empleados.EmpleadoFactory;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;

public class EmpleadoTest {
    @BeforeAll
    @Test
    public void crearEmpleadoTest() throws MercaDAWException{
        Empleado e1 = EmpleadoFactory.obtener("Empleado", null, "Jesús", "Herrera", Date.valueOf("2005-08-14"));
        assertEquals(1, e1.getId());
        Empleado e2 = EmpleadoFactory.obtener("Cajero", null, "Iván", "Madroñero", Date.valueOf("2001-09-11"));
        assertEquals(2, e2.getId());
    }

    // Julian si quieres pruebas las haces tu no puedo mas
}
