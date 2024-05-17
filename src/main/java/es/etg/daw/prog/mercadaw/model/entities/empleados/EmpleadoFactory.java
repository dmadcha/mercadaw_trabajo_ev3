package es.etg.daw.prog.mercadaw.model.entities.empleados;

import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;

public class EmpleadoFactory {
    public static Empleado obtener(TipoEmpleado tipo, String nombre, String apellidos) throws MercaDAWException{
        if (tipo.equals(TipoEmpleado.REPONEDOR)) {
            return new Reponedor(nombre, apellidos);
        } else if (tipo.equals(TipoEmpleado.CAJERO)) {
            return new Cajero(nombre, apellidos);
        } else if (tipo.equals(TipoEmpleado.ENCARGADO)) {
            return new Encargado(nombre, apellidos);
        } else if (tipo.equals(TipoEmpleado.EMPLEADO)) {
            return new Empleado(nombre, apellidos);
        } else
        throw new MercaDAWException();
    }
}
