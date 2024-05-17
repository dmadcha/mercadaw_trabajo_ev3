package es.etg.daw.prog.mercadaw.model.entities.empleados;

import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;

public class EmpleadoFactory {
    public static Empleado obtener(String tipoString, String nombre, String apellidos) throws MercaDAWException{
        
        TipoEmpleado tipoEmpleado;
        try {
            tipoEmpleado = TipoEmpleado.valueOf(tipoString.toUpperCase());
        } catch (Exception e) {
            throw new MercaDAWException();
        }

        if (tipoEmpleado.equals(TipoEmpleado.REPONEDOR)) {
            return new Reponedor(nombre, apellidos);
        } else if (tipoEmpleado.equals(TipoEmpleado.CAJERO)) {
            return new Cajero(nombre, apellidos);
        } else if (tipoEmpleado.equals(TipoEmpleado.ENCARGADO)) {
            return new Encargado(nombre, apellidos);
        } else if (tipoEmpleado.equals(TipoEmpleado.EMPLEADO)) {
            return new Empleado(nombre, apellidos);
        } else
        throw new MercaDAWException();
    }
}
