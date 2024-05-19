package es.etg.daw.prog.mercadaw.model.entities.empleados;

import java.sql.Date;

import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;

public class EmpleadoFactory {
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
