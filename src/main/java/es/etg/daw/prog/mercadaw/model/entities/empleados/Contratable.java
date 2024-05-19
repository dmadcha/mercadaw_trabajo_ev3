package es.etg.daw.prog.mercadaw.model.entities.empleados;

public interface Contratable {
    public static final double SUELDO_EMPLE = 1000;
    public static final double SUELDO_REPON = 1200;
    public static final double SUELDO_CAJER = 1300;
    public static final double SUELDO_ENCAR = 1500;

    /**
     * Calcula y devuelve el salario neto de un empleado.
     * \return Un double con el salarioNeto
     * \author Diego Madroñero Chamorro
     */
    public double getSalarioNeto();

     /**
     * Calcula y devuelve el salario bruto de un empleado.
     * \return Un double con el salarioBruto
     * \author Diego Madroñero Chamorro
     */
    public double getSalarioBruto();

    /**
     * Calcula y devuelve las aportaciones salariales del empresario en la nomina de un empleado.
     * \return Un double con las aportaciones
     * \author Diego Madroñero Chamorro
     */
    public double getAportaciones();

    /**
     * Calcula y devuelve el salario neto de un empleado.
     * \return Un double con la indemnizacion
     * \author Diego Madroñero Chamorro
     */
    public double getIndemnizacion(TipoDespido tipo);
}
