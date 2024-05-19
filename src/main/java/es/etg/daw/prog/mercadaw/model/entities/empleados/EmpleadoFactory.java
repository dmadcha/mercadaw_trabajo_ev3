package es.etg.daw.prog.mercadaw.model.entities.empleados;

import java.sql.Date;

import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;

/**
 * La factoría EmpleadoFactory crea empleados según el tipo de estos.
 * \author Diego Madroñero Chamorro.
 */
public class EmpleadoFactory {

    /**
     * El metodo obtener es el utilizado para inicializar los empleados, pasandole los datos y el tipo de empleado que se quiera crear.
     * \param El tipo de empleado, ya sea Reponedor, Cajero, Encargado o Empleado.
     * \param El ID del empleado (nulo para generarlo automaticamente)
     * \param El nombre del empleado
     * \param Los apellidos del empleado 
     * \param La fecha de contratación del empleado
     * \return Un empleado
     * \throws MercaDAWException
     */
    public static Empleado obtener(String tipoString, Integer id, String nombre, String apellidos, Date fechaInicio) throws MercaDAWException{
        
        TipoEmpleado tipoEmpleado;
        try {
            tipoEmpleado = TipoEmpleado.valueOf(tipoString.toUpperCase());
        } catch (Exception e) {
            throw new MercaDAWException();
        }

        if (tipoEmpleado.equals(TipoEmpleado.REPONEDOR)) {
            return new Reponedor(id, nombre, apellidos, fechaInicio);
        } else if (tipoEmpleado.equals(TipoEmpleado.CAJERO)) {
            return new Cajero(id, nombre, apellidos, fechaInicio);
        } else if (tipoEmpleado.equals(TipoEmpleado.ENCARGADO)) {
            return new Encargado(id, nombre, apellidos, fechaInicio);
        } else if (tipoEmpleado.equals(TipoEmpleado.EMPLEADO)) {
            return new Empleado(id, nombre, apellidos, fechaInicio);
        } else
        throw new MercaDAWException();
    }
}
