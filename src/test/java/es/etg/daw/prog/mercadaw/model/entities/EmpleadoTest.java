package es.etg.daw.prog.mercadaw.model.entities;

import static es.etg.daw.prog.mercadaw.model.entities.empleados.TipoDespido.IMPROCEDENTE;
import static es.etg.daw.prog.mercadaw.model.entities.empleados.TipoDespido.PRODECENTE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import es.etg.daw.prog.mercadaw.model.entities.empleados.Empleado;
import es.etg.daw.prog.mercadaw.model.entities.empleados.EmpleadoFactory;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;

public class EmpleadoTest {
    private Empleado empleado1;
    private Empleado empleado2;

    @BeforeEach
    public void creacionEmpleados() throws MercaDAWException {
        empleado1 = EmpleadoFactory.obtener("Empleado", null, "Jesús", "Herrera", Date.valueOf("2005-08-14"));
        empleado2 = EmpleadoFactory.obtener("Cajero", null, "Iván", "Madroñero", Date.valueOf("2001-09-11"));
    }

    @Order(10)
    @Test 
    public void crearEmpleadoTest() {
        assertEquals(1, empleado1.getId());
        assertEquals(2, empleado2.getId());
    }

    @Order(11)
    @Test
    public void getSueldoTest(){
        double resultadoEsperado1 = 1000;
        double resultadoEsperado2 = 1300;
        double resultado1 = empleado1.getSueldo();
        double resultado2 = empleado2.getSueldo();
        int margenError = 2;

        assertEquals(resultadoEsperado1, resultado1, margenError);
        assertEquals(resultadoEsperado2, resultado2, margenError);
    }

    @Order(15)
    @Test
    public void getPPETest() {
        // ( 2 * sueldo ) / 12.
        double resultadoEsperado = (2 * empleado2.getSueldo()) / 12;
        double resultado = empleado2.getPPE();
        int margenError = 2;

        assertEquals(resultadoEsperado, resultado, margenError);
    }

    @Order(20)
    @Test
    public void getSalarioBrutoTest() {
        // sueldo + PPE.
        double resultadoEsperado = empleado1.getSueldo() + empleado1.getPPE();
        double resultado = empleado1.getSalarioBruto();
        int margenError = 2;

        assertEquals(resultadoEsperado, resultado, margenError);
    }

    @Order(16)
    @Test
    public void getDeduccionesTest() {
        // sueldo * 0.2047; 0.2047 = 20.47%
        double resultadoEsperado = empleado1.getSueldo() * 0.2047;
        double resultado = empleado1.getDeducciones();
        int margenError = 2;

        assertEquals(resultadoEsperado, resultado, margenError);
    }

    @Order(30)
    @Test
    public void getSalarioNetoTest() {
        // salarioBruto - deducciones
        double resultadoEsperado = empleado1.getSalarioBruto() - empleado1.getDeducciones();
        double resultado = empleado1.getSalarioNeto();
        int margenError = 2;

        assertEquals(resultadoEsperado, resultado, margenError);
    }

    @Order(40)
    @Test
    public void getAportacionesTest() {
        // salarioBruto * 0.3048; 0.3048 = 30.48% 
        double resultadoEsperado = empleado1.getSalarioBruto() * 0.3048;
        double resultado = empleado1.getAportaciones();
        int margenError = 2;

        assertEquals(resultadoEsperado, resultado, margenError);
    }

    @Order(50)
    @Test
    public void getIndemnizacion() {
        // Salario diario * IndemLegal * Antiguedad
        double resultadoEsperadoImproc = 1283.333337 * empleado1.getAntiguedad();
        double resultadoEsperadoProc = 0;
        double resultadoImproc = empleado1.getIndemnizacion(IMPROCEDENTE);
        double resultadoProc = empleado1.getIndemnizacion(PRODECENTE);
        int margenError = 2;

        assertEquals(resultadoEsperadoImproc, resultadoImproc, margenError);
        assertEquals(resultadoEsperadoProc, resultadoProc, margenError);
    }

    @Order(45)
    @Test
    public void getSalarioDiarioTest() {
        // SalarioBruto / DiasMes; DiasMes = 30;
        double resultadoEsperado = 38.89;
        double resultado = empleado1.getSalarioDiario();
        int margenError = 2;

        assertEquals(resultadoEsperado, resultado, margenError);
    }

    @Order(46)
    @Test
    public void getIndemnizacionLegalTest() {
        // Indem legal Despido Improcedente = 33
        double resultadoEsperadoImproc = 33;
        // Indem legal Despido Procedente = 0
        double resultadoEsperadoProc = 0;
        double resultadoImproc = empleado1.getIndemnizacionLegal(IMPROCEDENTE);
        double resultadoProc = empleado1.getIndemnizacionLegal(PRODECENTE);
        int margenError = 2;

        assertEquals(resultadoEsperadoImproc, resultadoImproc, margenError);
        assertEquals(resultadoEsperadoProc, resultadoProc, margenError);
    }

    @Order(47)
    @Test
    public void getAntiguedadTest() {
        // Como no contemplamos una fecha de despido, asumimos que la fecha de despido es hoy (la fecha en la que se ejecute el metodo).
        // El resultado esperado es el tiempo que hay desde la fecha de inicio del empleado hasta hoy.
        int resultadoEsperado = Period.between(empleado1.getFechaInicio().toLocalDate(), LocalDate.now()).getYears();
        int resultado = empleado1.getAntiguedad();
        int margenError = 2;

        assertEquals(resultadoEsperado, resultado, margenError);
    }
}
