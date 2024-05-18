package es.etg.daw.prog.mercadaw.model.bbdd;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * La clase MercaDAOImp servirá para futuras actualizaciones.
 * \author Jesús Pérez Enríquez.
 */
public abstract class MarcaDAOImp implements MercaDAO{

    protected Connection connection;

    public abstract void crearEmpleados(Statement st) throws SQLException;
    public abstract void crearClientes(Statement st) throws SQLException;
    public abstract void crearCompras(Statement st) throws SQLException;
    public abstract void crearProductos(Statement st) throws SQLException;

}
