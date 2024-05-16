package es.etg.daw.prog.mercadaw.model.bbdd;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import es.etg.daw.prog.mercadaw.model.entities.Cliente;
import es.etg.daw.prog.mercadaw.model.entities.Compra;
import es.etg.daw.prog.mercadaw.model.entities.Empleado;
import es.etg.daw.prog.mercadaw.model.entities.Producto;


/**
 * La clase MercaDAOImpOracleXE implementa el comportamiento con la base de datos.
 * \author Jesús Pérez Enríquez.
 */
public class MercaDAOImpOracleXE extends MarcaDAOImp {

    private final String URL = "jdbc:oracle:thin:%s/%s@localhost:1521/XEPDB1";
    private final String DATABASE_USER = "SYSTEM";
    private final String DATABASE_PASS = "secret";

    public MercaDAOImpOracleXE() throws SQLException{
        connection = DriverManager.getConnection(String.format(URL, DATABASE_USER, DATABASE_PASS));
    }

    @Override
    public void insertar(Empleado emp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public void insertar(Producto prod) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public void insertar(Compra compra) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public void insertar(Cliente client) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public Producto visualizarProducto() throws SQLException{
        final String QUERY = "SELECT nombre, apellido, nacimiento FROM alumno WHERE ";

        PreparedStatement ps = connection.prepareStatement(QUERY);
        ResultSet rs = ps.executeQuery();

        // TODO Datos del Producto
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        
        Producto producto = new Producto();
            
        
        rs.close();
        ps.close();

        return producto;
    }

    @Override
    public List<Producto> visualizarProductos() throws SQLException{
        final String QUERY = "SELECT nombre, apellido, nacimiento FROM alumno";

        List<Producto> productos = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(QUERY);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){

            // TODO Datos del Producto
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");

            
            Producto producto = new Producto();
            productos.add(producto);
        }
        rs.close();
        ps.close();

        return productos;
    }

    @Override
    public List<Cliente> visualizarClientes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualizarClientes'");
    }

    @Override
    public List<Empleado> visualizarEmpleados() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualizarEmpleados'");
    }

    @Override
    public List<Compra> visualizarCompras() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualizarCompras'");
    }

    @Override
    public Map<Producto, Integer> visualizarStock() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualizarStock'");
    }
}
