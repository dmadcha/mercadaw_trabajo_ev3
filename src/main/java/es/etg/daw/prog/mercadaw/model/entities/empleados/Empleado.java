package es.etg.daw.prog.mercadaw.model.entities.empleados;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

/**
 * La clase Empleado representa un empleado de MercaDAW.
 * \author Diego Madroñero Chamorro.
 */
public class Empleado implements Contratable {

    private static int numEmpleados;

    private Integer id;
    private String nombre;
    private String apellidos;
    private double sueldo;
    private Date fechaInicio;

    /**
     * Constructor que inicializa empleados, generando el ID de estas automaticamente.
     * \param Id del empleado
     * \param Nombre del empleado
     * \param Apellidos del empleado
     * \param Fecha de contratación del empleado
     */
    public Empleado(Integer id, String nombre, String apellidos, Date fechaInicio) {

        if (id == null) {
            numEmpleados++;
            this.id = numEmpleados;
        } else {
            this.id = id;
        }
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaInicio = fechaInicio;
        this.sueldo = SUELDO_EMPLE;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    public static int getNumEmpleados() {
        return numEmpleados;
    }

    public static void setNumEmpleados(int numEmpleados) {
        Empleado.numEmpleados = numEmpleados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return TipoEmpleado.EMPLEADO.toString();
    }

    @Override
    public double getSalarioNeto() {
        double neto = 0;

        neto = getSalarioBruto() - getDeducciones();

        return neto;
    }

    @Override
    public double getSalarioBruto() {
        double bruto = 0;

        bruto = getSueldo() + getPPE();

        return bruto;
    }

    /**
     * Calcula y devuelve las pagas extra de un empleado.
     * \return Un double con la prorrata de pagas extra.
     */
    public double getPPE(){
        final int NUM_PAGAS = 2;
        final int NUM_MESES = 12;
        
        double ppe = 0;

        ppe = (NUM_PAGAS * getSueldo()) / NUM_MESES;

        return ppe;
    }
    /**
     * Calcula y devuelve las deducciones de la nomina de un empleado.
     * \return Un double con las deducciones.
     */
    public double getDeducciones(){
        final double TOTAL_DEDUC = 0.2047;

        double deducciones = 0;

        deducciones = getSueldo() * TOTAL_DEDUC;

        return deducciones;
    }

    @Override
    public double getAportaciones() {
        final double TOTAL_APORTAC = 0.3048;

        double aportaciones = 0;

        aportaciones = getSalarioBruto() * TOTAL_APORTAC;

        return aportaciones;
    }

    @Override
    public double getIndemnizacion(TipoDespido tipo) {
        double indemnizacion = 0;

        indemnizacion = getSalarioDiario() * getIndemnizacionLegal(tipo) * getAntiguedad();

        return indemnizacion;
    }

    /**
     * Devuelve los dias de indemnizacion legal que corresponden segun el tipo de despido.
     * \param tipo: Tipo del despido, ya sea procedente o improcedente.
     * \return Un double con los dias dias de indemnizacion legal.
     */
    public double getIndemnizacionLegal(TipoDespido tipo) {
        final int DIAS_INDEM_IMPRO = 33;
        final int DIAS_INDEM_PROC = 0;

        double indemLegal = 0;

        if (tipo.equals(TipoDespido.IMPROCEDENTE)) {
            indemLegal = DIAS_INDEM_IMPRO;
        } else {
            indemLegal = DIAS_INDEM_PROC;
        }
        return indemLegal;
    }

    /**
     * Calcula y devuelve el salario diario de un empleado.
     * \return Un double con el salario deiario.
     */
    public double getSalarioDiario(){
        final int NUM_DIAS = 30;

        double salarioDiario = 0;

        salarioDiario = getSalarioBruto() / NUM_DIAS;

        return salarioDiario;
    }

    /**
     * Calcula y devuelve la antigüedad de un empleado.
     * \return Un int con la antigüedad del empleado.
     */
    public int getAntiguedad(){
        LocalDate fechaInicial = fechaInicio.toLocalDate();
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaInicial, fechaActual);
        int anyos = periodo.getYears();
        
        return anyos;
    }
}
