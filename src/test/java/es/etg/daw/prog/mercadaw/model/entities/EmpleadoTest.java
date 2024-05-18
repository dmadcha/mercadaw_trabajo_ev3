package es.etg.daw.prog.mercadaw.model.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import es.etg.daw.prog.mercadaw.model.entities.empleados.Empleado;
import es.etg.daw.prog.mercadaw.model.entities.empleados.EmpleadoFactory;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;

public class EmpleadoTest {
    @Test
    public void crearEmpleadoTest() throws MercaDAWException{
        EmpleadoFactory.obtener("Empleado", null, "Jesús", "Herrera");
        assertEquals(1, Empleado.getNumEmpleados());
        EmpleadoFactory.obtener("Cajero", null, "Iván", "Madroñero");
        assertEquals(2, Empleado.getNumEmpleados());
    }
}
