package es.etg.daw.prog.mercadaw.model.bbdd;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public void crearTablaClientes()throws BBDDException{

        final String TABLA_CLIENTES = "CREATE TABLE Clientes (\n" +
                                        "  cod_postal NUMERIC NOT NULL,\n" +
                                        "  correo VARCHAR,\n" +
                                        "  nombre VARCHAR,\n" +
                                        "  cod_client NUMERIC NOT NULL,\n" +
                                        "  PRIMARY KEY (cod_client)\n" +
                                        ");";

        Statement st = connection.createStatement();
        st.execute(TABLA_CLIENTES);
        st.close();

    }

    @Override
    public void crearTablaProductos()throws BBDDException{

        final String TABLA_PRODUCTOS = "CREATE TABLE Producto (\n" +
                                        "  nombre VARCHAR NOT NULL,\n" +
                                        "  precio NUMERIC NOT NULL,\n" +
                                        "  marca VARCHAR NOT NULL,\n" +
                                        "  categoria VARCHAR NOT NULL,\n" +
                                        "  iva NUMERIC NOT NULL,\n" +
                                        "  altura NUMERIC NOT NULL,\n" +
                                        "  anchura NUMERIC NOT NULL,\n" +
                                        "  peso NUMERIC NOT NULL,\n" +
                                        "  num_elementos NUMERIC NOT NULL,\n" +
                                        "  desc VARCHAR NOT NULL,\n" +
                                        "  cod_produc NUMERIC NOT NULL,\n" +
                                        "  PRIMARY KEY (cod_produc)\n" +
                                        ");";

        Statement st = connection.createStatement();
        st.execute(TABLA_PRODUCTOS);
        st.close();

    }

    public void crearTablaEmpleados()throws BBDDException{

        final String TABLA_EMPLEADOS = "CREATE TABLE Empleado (\n" +
                                        "  cod_emple NUMERIC NOT NULL,\n" +
                                        "  nombre VARCHAR NOT NULL,\n" +
                                        "  apellidos VARCHAR NOT NULL,\n" +
                                        "  categoria VARCHAR NOT NULL,\n" +
                                        "  cod_produc NUMERIC NOT NULL,\n" +
                                        "  PRIMARY KEY (cod_emple),\n" +
                                        "  FOREIGN KEY (cod_produc) REFERENCES Producto(cod_produc)\n" +
                                        ");";

        Statement st = connection.createStatement();
        st.execute(TABLA_EMPLEADOS);
        st.close();

    }

    public void crearTablaCompras()throws BBDDException{

        final String TABLA_COMPRAS = "CREATE TABLE Compras (\n" +
                                                "  fecha DATE NOT NULL,\n" +
                                                "  cod_compra NUMERIC NOT NULL,\n" +
                                                "  cod_produc NUMERIC NOT NULL,\n" +
                                                "  cod_client NUMERIC NOT NULL,\n" +
                                                "  PRIMARY KEY (cod_compra),\n" +
                                                "  FOREIGN KEY (cod_produc) REFERENCES Producto(cod_produc),\n" +
                                                "  FOREIGN KEY (cod_client) REFERENCES Clientes(cod_client)\n" +
                                                ");";

        Statement st = connection.createStatement();
        st.execute(TABLA_COMPRAS);
        st.close();

    }

    @Override
    public void insertar(Empleado emp) throws BBDDException{
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public void insertar(Producto prod) throws BBDDException{
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public void insertar(Compra compra) throws BBDDException{
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public void insertar(Cliente client) throws BBDDException{
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
    public List<Cliente> visualizarClientes() throws BBDDException{
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualizarClientes'");
    }

    @Override
    public List<Empleado> visualizarEmpleados() throws BBDDException{
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualizarEmpleados'");
    }

    @Override
    public List<Compra> visualizarCompras() throws BBDDException{
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualizarCompras'");
    }

    @Override
    public Map<Producto, Integer> visualizarStock() throws BBDDException{
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualizarStock'");
    }
}
