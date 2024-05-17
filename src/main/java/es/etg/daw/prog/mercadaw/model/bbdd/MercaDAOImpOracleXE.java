package es.etg.daw.prog.mercadaw.model.bbdd;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.etg.daw.prog.mercadaw.model.entities.compras.Cliente;
import es.etg.daw.prog.mercadaw.model.entities.compras.Compra;
import es.etg.daw.prog.mercadaw.model.entities.empleados.Empleado;
import es.etg.daw.prog.mercadaw.model.entities.empleados.EmpleadoFactory;
import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;


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
        Statement st = connection.createStatement();

        bbdd.crearEmpleados(st);
        bbdd.crearClientes(st);
        bbdd.crearProductos(st);
        bbdd.crearCompras(st);
        
        st.close();
    }

    /**
     * Este metodo crea la tabla y vista de Empleados en la base de datos
     * \throws SQLException
     */
    public void crearEmpleados(Statement st)throws SQLException{

        final String TABLA_EMPLEADOS = "CREATE TABLE Empleados( " +
                                        "cod_emple NUMERIC(4) PRIMARY KEY, " +
                                        "nombre VARCHAR(255), " +
                                        "apellidos VARCHAR(255), " +
                                        "categoria VARCHAR(255)) ";

        final String VISTA_EMPLEADOS = "CREATE OR REPLACE VIEW Vista_Empleados AS " +
                                        "SELECT cod_emple, nombre, apellidos, categoria " +
                                        "FROM Empleados";

        st.execute(TABLA_EMPLEADOS);
        st.execute(VISTA_EMPLEADOS);
    }

    /**
     * Este metodo crea la tabla y vista de Clientes en la base de datos
     * \throws SQLException
     */
    public void crearClientes(Statement st)throws SQLException{

        final String TABLA_CLIENTES = "CREATE TABLE Clientes( " +
                                        "cod_client NUMERIC(4) PRIMARY KEY, " +
                                        "cod_postal NUMERIC(5), " +
                                        "correo VARCHAR(255), " +
                                        "nombre VARCHAR(255))";

        final String VISTA_CLIENTES = "CREATE OR REPLACE VIEW Vista_Clientes AS " +
                                        "SELECT cod_client, cod_postal, correo, nombre " +
                                        "FROM Clientes";

        st.execute(TABLA_CLIENTES);
        st.execute(VISTA_CLIENTES);
    }

    /**
     * Este metodo crea la tabla y vista de Productos en la base de datos
     * \throws SQLException
     */
    public void crearProductos(Statement st)throws SQLException{

        final String TABLA_PRODUCTOS = "CREATE TABLE Productos( " +
                                        "cod_product NUMERIC(4) PRIMARY KEY, " +
                                        "nombre VARCHAR(255), " +
                                        "marca VARCHAR(255), " +
                                        "descr VARCHAR(255), " +
                                        "categoria VARCHAR(255), " +
                                        "iva NUMERIC(5,4), " +
                                        "altura NUMERIC(5,4), " +
                                        "anchura NUMERIC(5,4), " +
                                        "peso NUMERIC(5,4), " +
                                        "num_elementos NUMERIC(2), " +
                                        "stock NUMERIC(5))";

        final String VISTA_PRODUCTOS = "CREATE OR REPLACE VIEW Vista_Productos AS " +
                                        "SELECT cod_product, nombre, marca, categoria, " +
                                        "iva, altura, anchura, peso, num_elementos, descr, stock " + 
                                        "FROM Productos";

        st.execute(TABLA_PRODUCTOS);
        st.execute(VISTA_PRODUCTOS);
    }
    
    
    /**
     * Este metodo crea la tabla y vista de Compras en la base de datos
     * \throws SQLException
     */
    public void crearCompras(Statement st)throws SQLException{

        final String TABLA_COMPRAS = "CREATE TABLE Compras (" +
                                                "cod_compra NUMERIC(4) PRIMARY KEY, " +
                                                "cod_product NUMERIC(4), " +
                                                "cod_client NUMERIC(4), " +
                                                "fecha DATE, " +
                                                "FOREIGN KEY (cod_product) REFERENCES Productos(cod_product)," +
                                                "FOREIGN KEY (cod_client) REFERENCES Clientes(cod_client))";

        final String VISTA_COMPRAS = "CREATE OR REPLACE VIEW Vista_Compras AS " +
                                        "SELECT cod_compra, cod_product, cod_client, fecha " +
                                        "FROM Compras";


        st.execute(TABLA_COMPRAS);
        st.execute(VISTA_COMPRAS);
    }



    @Override
    public int insertar(Empleado emp) throws SQLException{
        int numRegistrosActualizados = 0;
        final String sql = "INSERT INTO Empleados VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setInt(1, emp.getId());
        ps.setString(2, emp.getNombre());
        ps.setString(3, emp.getApellidos());
        ps.setString(4, emp.toString());
        ps.setDouble(5, emp.getSueldo());
    

        numRegistrosActualizados = ps.executeUpdate();
        ps.close();

        return numRegistrosActualizados;
    }

    @Override
    public int insertar(Producto prod) throws SQLException{
        int numRegistrosActualizados = 0;
        final String sql = "INSERT INTO Empleados VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setInt(1, prod.getId());
        ps.setString(2, prod.getNombre());
        ps.setString(3, prod.getMarca());
        ps.setString(4, prod.());
        ps.setDouble(5, prod.getSueldo());
    

        numRegistrosActualizados = ps.executeUpdate();
        ps.close();

        return numRegistrosActualizados;
    }

    @Override
    public int insertar(Compra compra) throws SQLException{
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public int insertar(Cliente client) throws SQLException{
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
        
        Producto producto = null;
            
        
        rs.close();
        ps.close();

        return producto;
    }

    @Override
    public List<Producto> visualizarProductos() throws SQLException{
        final String QUERY = "SELECT nombre, apellido, nacimiento FROM PRODUCTOS";

        List<Producto> productos = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(QUERY);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){

            // TODO Datos del Producto
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");

            
            Producto producto = null;
            productos.add(producto);
        }
        rs.close();
        ps.close();

        return productos;
    }

    @Override
    public List<Cliente> visualizarClientes() throws SQLException{
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualizarClientes'");
    }

    @Override
    public List<Empleado> visualizarEmpleados() throws SQLException{
        final String QUERY = "SELECT cod_emple, nombre, apellidos, categoria " +
                                "FROM Empleados";


        List<Empleado> empleados = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(QUERY);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){

            int id = rs.getInt("cod_emple");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellidos");
            String categoria = rs.getString("categoria");
            
            

            Empleado empleado = EmpleadoFactory.obtener(categoria, nombre, apellido); 
            empleados.add(empleado);
        }

        rs.close();
        ps.close();

        return empleados;
    }

    @Override
    public List<Compra> visualizarCompras() throws SQLException{
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualizarCompras'");
    }
    
}
