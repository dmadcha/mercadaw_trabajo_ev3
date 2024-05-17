package es.etg.daw.prog.mercadaw.model.bbdd;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import es.etg.daw.prog.mercadaw.model.entities.compras.Cliente;
import es.etg.daw.prog.mercadaw.model.entities.compras.Compra;
import es.etg.daw.prog.mercadaw.model.entities.empleados.Empleado;
import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;
import es.etg.daw.prog.mercadaw.model.exception.BBDDException;


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
    public void iniciarBBDD() throws SQLException {
        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();
        
        bbdd.crearClientes();
        bbdd.crearCompras();
        bbdd.crearEmpleados();
        bbdd.crearProductos();
    }

    /**
     * Este metodo crea la tabla y vista de Clientes en la base de datos
     * @throws SQLException
     */
    public void crearClientes()throws SQLException{

        final String TABLA_CLIENTES = "CREATE OR REPLACE TABLE Clientes (\n" +
                                        "  cod_client NUMERIC(4) NOT NULL,\n" +
                                        "  cod_postal NUMERIC(5) NOT NULL,\n" +
                                        "  correo VARCHAR(255),\n" +
                                        "  nombre VARCHAR(255),\n" +
                                        "  PRIMARY KEY (cod_client)\n" +
                                        ");";

        final String VISTA_CLIENTES = "CREATE OR REPLACE VIEW Vista_Clientes AS " +
        "SELECT cod_postal, correo, cod_client, categoria, " +
        "iva, altura, anchura, peso, num_elementos, desc, stock " + 
        "FROM Clientes";

        Statement st = connection.createStatement();
        st.execute(TABLA_CLIENTES);
        st.execute(VISTA_CLIENTES);
        st.close();

    }

    /**
     * Este metodo crea la tabla y vista de Productos en la base de datos
     * @throws SQLException
     */
    public void crearProductos()throws SQLException{

        final String TABLA_PRODUCTOS = "CREATE OR REPLACE TABLE Productos (\n" +
                                        "  cod_produc NUMERIC(4) NOT NULL,\n" +
                                        "  nombre VARCHAR(255) NOT NULL,\n" +
                                        "  marca VARCHAR(255) NOT NULL,\n" +
                                        "  categoria VARCHAR(255) NOT NULL,\n" +
                                        "  iva NUMERIC NOT NULL,\n" +
                                        "  altura NUMERIC NOT NULL,\n" +
                                        "  anchura NUMERIC NOT NULL,\n" +
                                        "  peso NUMERIC NOT NULL,\n" +
                                        "  num_elementos NUMERIC NOT NULL,\n" +
                                        "  desc VARCHAR(255) NOT NULL,\n" +
                                        "  stock NUMERIC NOT NULL, \n" +
                                        "  PRIMARY KEY (cod_produc)\n" +
                                        ")";

        final String VISTA_PRODUCTOS = "CREATE OR REPLACE VIEW Vista_Productos AS " +
                                        "SELECT cod_produc, nombre, marca, categoria, " +
                                        "iva, altura, anchura, peso, num_elementos, desc, stock " + 
                                        "FROM Productos";


        Statement st = connection.createStatement();
        st.execute(TABLA_PRODUCTOS);
        st.execute(VISTA_PRODUCTOS);
        st.close();

    }
    
    /**
     * Este metodo crea la tabla y vista de Empleados en la base de datos
     * @throws SQLException
     */
    public void crearEmpleados()throws SQLException{

        final String TABLA_EMPLEADOS = "CREATE OR REPLACE TABLE Empleados (\n" +
                                        "  cod_emple NUMERIC(4) NOT NULL,\n" +
                                        "  nombre VARCHAR(255) NOT NULL,\n" +
                                        "  apellidos VARCHAR(255) NOT NULL,\n" +
                                        "  categoria VARCHAR(255) NOT NULL,\n" +
                                        "  cod_produc NUMERIC NOT NULL,\n" +
                                        "  PRIMARY KEY (cod_emple),\n" +
                                        "  FOREIGN KEY (cod_produc) REFERENCES Producto(cod_produc)\n" +
                                        ")";

        final String VISTA_EMPLEADOS = "CREATE OR REPLACE VIEW Vista_Empleados AS " +
                                        "SELECT cod_emple, nombre, appellidos, categoria, cod_produc " +
                                        "FROM Empleados";

        Statement st = connection.createStatement();
        st.execute(TABLA_EMPLEADOS);
        st.execute(VISTA_EMPLEADOS);
        st.close();

    }

    /**
     * Este metodo crea la tabla y vista de Compras en la base de datos
     * @throws SQLException
     */
    public void crearCompras()throws SQLException{

        final String TABLA_COMPRAS = "CREATE OR REPLACE TABLE Compras (\n" +
                                                "  cod_compra NUMERIC(4) NOT NULL,\n" +
                                                "  cod_produc NUMERIC(4) NOT NULL,\n" +
                                                "  cod_client NUMERIC(4) NOT NULL,\n" +
                                                "  fecha DATE NOT NULL,\n" +
                                                "  PRIMARY KEY (cod_compra),\n" +
                                                "  FOREIGN KEY (cod_produc) REFERENCES Producto(cod_produc),\n" +
                                                "  FOREIGN KEY (cod_client) REFERENCES Clientes(cod_client)\n" +
                                                ")";

        final String VISTA_COMPRAS = "CREATE OR REPLACE VIEW Vista_Compras AS " +
        "SELECT cod_compra, cod_produc, cod_client, fecha " +
        "FROM Compras";

        Statement st = connection.createStatement();
        st.execute(TABLA_COMPRAS);
        st.execute(VISTA_COMPRAS);
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
    public Producto visualizarProducto() throws BBDDException{
        final String QUERY = "SELECT nombre, apellido, nacimiento FROM alumno WHERE ";

        PreparedStatement ps = connection.prepareStatement(QUERY);
        ResultSet rs = ps.executeQuery();

        // TODO Datos del Producto
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        
        Producto producto = new ;
            
        
        rs.close();
        ps.close();

        return producto;
    }

    @Override
    public List<Producto> visualizarProductos() throws BBDDException{
        final String QUERY = "SELECT nombre, apellido, nacimiento FROM PRODUCTOS";

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
