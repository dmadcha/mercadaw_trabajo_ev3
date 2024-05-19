package es.etg.daw.prog.mercadaw.model.bbdd;

import java.sql.Date;
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
import es.etg.daw.prog.mercadaw.model.entities.productos.ProductoFactory;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;


/**
 * La clase MercaDAOImpOracleXE implementa el comportamiento con la base de datos.
 * \author Jesús Pérez Enríquez.
 */
public class MercaDAOImpOracleXE extends MarcaDAOImp {

    public static final String PROD_ID = "cod_product";
    public static final String PROD_NOMB = "nombre";
    public static final String PROD_MARC = "marca";
    public static final String PROD_DESC = "descr";
    public static final String PROD_CATE = "categoria";
    public static final String PROD_PREC = "precio";
    public static final String PROD_ALTU = "altura";
    public static final String PROD_ANCH = "anchura";
    public static final String PROD_PESO = "peso";
    public static final String PROD_ELEM = "num_elementos";
    public static final String PROD_STOK = "stock";

    public static final String EMPLE_ID = "cod_emple";
    public static final String EMPLE_NOMB = "nombre";
    public static final String EMPLE_APEL = "apellidos";
    public static final String EMPLE_CATE = "categoria";
    public static final String EMPLE_FECH = "fecha_inic";
    public static final String CLIEN_ID = "cod_client";
    public static final String CLIEN_POST = "cod_postal";
    public static final String CLIEN_CORR = "correo";
    public static final String CLIEN_NOMB = "nombre";

    public static final String COMP_ID = "cod_compra";
    public static final String COMP_FECH = "fecha";


    private final String URL = "jdbc:oracle:thin:%s/%s@localhost:1521/XEPDB1";
    private final String DATABASE_USER = "SYSTEM";
    private final String DATABASE_PASS = "secret";



    public MercaDAOImpOracleXE() throws SQLException{
        connection = DriverManager.getConnection(String.format(URL, DATABASE_USER, DATABASE_PASS));
    }

    @Override
    public void iniciarBBDD() throws SQLException{
        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();
        Statement st = connection.createStatement();

        bbdd.crearEmpleados(st);
        bbdd.crearClientes(st);
        bbdd.crearProductos(st);
        bbdd.crearCompras(st);
        
        st.close();
    }
    @Override
    /**
     * Este metodo crea la tabla y vista de Empleados en la base de datos
     * \throws SQLException
     */
    public void crearEmpleados(Statement st) throws SQLException{

        final String TABLA_EMPLEADOS = "CREATE TABLE Empleados( " +
                                        EMPLE_ID + " NUMERIC(4) PRIMARY KEY, " +
                                        EMPLE_NOMB + " VARCHAR(255), " +
                                        EMPLE_APEL + " VARCHAR(255), " +
                                        EMPLE_CATE + " VARCHAR(255), " +
                                        EMPLE_FECH + " DATE)";
        final String VISTA_EMPLEADOS = "CREATE OR REPLACE VIEW Vista_Empleados AS " +
                                        "SELECT "+EMPLE_ID+", "+EMPLE_NOMB+", "+EMPLE_APEL+", "+EMPLE_CATE+", "+EMPLE_FECH+" FROM Empleados";

        st.execute(TABLA_EMPLEADOS);
        st.execute(VISTA_EMPLEADOS);
    }
    @Override
    /**
     * Este metodo crea la tabla y vista de Clientes en la base de datos
     * \throws SQLException
     */
    public void crearClientes(Statement st) throws SQLException{

        final String TABLA_CLIENTES = "CREATE TABLE Clientes( " +
                                        CLIEN_ID +" NUMERIC(4) PRIMARY KEY, " +
                                        CLIEN_NOMB + " VARCHAR(255), " +
                                        CLIEN_CORR + " VARCHAR(255), " +
                                        CLIEN_POST + " NUMERIC(5)) ";

        final String VISTA_CLIENTES = "CREATE OR REPLACE VIEW Vista_Clientes AS " +
                                        "SELECT "+CLIEN_ID+", "+CLIEN_POST+", "+CLIEN_NOMB+", "+CLIEN_CORR+" FROM Clientes";

        st.execute(TABLA_CLIENTES);
        st.execute(VISTA_CLIENTES);
    }
    @Override
    /**
     * Este metodo crea la tabla y vista de Productos en la base de datos
     * \throws SQLException
     */
    public void crearProductos(Statement st) throws SQLException{

        final String TABLA_PRODUCTOS = "CREATE TABLE Productos( " +
                                        PROD_ID + " NUMERIC(4) PRIMARY KEY, " +
                                        PROD_NOMB + " VARCHAR(255), " +
                                        PROD_MARC + " VARCHAR(255), " +
                                        PROD_ALTU + " NUMERIC(20,4), " +
                                        PROD_ANCH + " NUMERIC(20,4), " +
                                        PROD_PESO + " NUMERIC(20,4), " +
                                        PROD_ELEM + " NUMERIC(5), "   +
                                        PROD_STOK + " NUMERIC(5), "   +
                                        PROD_PREC + " NUMERIC(20,4), " +
                                        PROD_DESC + " VARCHAR(255), " +
                                        PROD_CATE + " VARCHAR(255)) " ;
                                        
                                        
                                        

                                        

        final String VISTA_PRODUCTOS = "CREATE OR REPLACE VIEW Vista_Productos AS " 
                                        +"SELECT "+PROD_ID+", "+PROD_NOMB+", "+PROD_MARC+", "+PROD_DESC+", "+PROD_CATE+", "
                                        +PROD_ALTU+", "+PROD_PREC+", "+PROD_ANCH+", "+PROD_PESO+", "+PROD_ELEM+", "+PROD_STOK+" FROM Productos";

        st.execute(TABLA_PRODUCTOS);
        st.execute(VISTA_PRODUCTOS);
    }
    
    @Override
    /**
     * Este metodo crea la tabla y vista de Compras en la base de datos
     * \throws SQLException
     */
    public void crearCompras(Statement st) throws SQLException{

        final String TABLA_COMPRAS = "CREATE TABLE Compras (" +
                                        COMP_ID + " NUMERIC(4) PRIMARY KEY, " +
                                        COMP_FECH + " DATE, " +
                                        CLIEN_ID + " NUMERIC(4), " +
                                        PROD_ID + " NUMERIC(4), " +
                                        "FOREIGN KEY ("+PROD_ID+") REFERENCES Productos("+PROD_ID+"), " +
                                        "FOREIGN KEY ("+CLIEN_ID+") REFERENCES Clientes("+CLIEN_ID+"))";

        final String VISTA_COMPRAS = "CREATE OR REPLACE VIEW Vista_Compras AS " +
                                        "SELECT "+COMP_ID+", "+PROD_ID+", "+CLIEN_ID+", "+COMP_FECH+" FROM Compras";
                                        

        st.execute(TABLA_COMPRAS);
        st.execute(VISTA_COMPRAS);
    }

    @Override
    public int insertar(Empleado emp) throws SQLException{
        int numRegistrosActualizados = 0;
        final String SQL = "INSERT INTO Empleados VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(SQL);

        ps.setInt(1, emp.getId());
        ps.setString(2, emp.getNombre());
        ps.setString(3, emp.getApellidos());
        ps.setString(4, emp.toString());
        ps.setDate(5, emp.getFechaInicio());
    

        numRegistrosActualizados = ps.executeUpdate();
        ps.close();

        return numRegistrosActualizados;
    }

    @Override
    public int insertar(Producto prod) throws SQLException{
        int numRegistrosActualizados = 0;
        final String SQL = "INSERT INTO Productos VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(SQL);

        ps.setInt(1, prod.getId());
        ps.setString(2, prod.getNombre());
        ps.setString(3, prod.getMarca());
        ps.setDouble(4, prod.getAltura());
        ps.setDouble(5, prod.getAnchura());
        ps.setDouble(6, prod.getPeso());
        ps.setInt(7, prod.getNumElementos());
        ps.setInt(8, prod.getStock());
        ps.setDouble(9, prod.getPrecio());
        ps.setString(10, prod.getDescripcion());
        ps.setString(11, prod.toString());

        numRegistrosActualizados = ps.executeUpdate();
        ps.close();

        return numRegistrosActualizados;
    }

    @Override
    public int insertar(Compra compra) throws SQLException{
        
        final String SQL = "INSERT INTO Compras VALUES (?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(SQL);

        int numRegistrosActualizados = 0;
        int id = compra.getId();

        for (int i = 0; i < compra.getProductos().size(); i ++) {
           

            ps.setInt(1, id);
            ps.setDate(2, compra.getFecha());
            ps.setInt(3, compra.getCliente().getId());
            
            ps.setInt(4, compra.getProductos().get(i).getId());
            
            numRegistrosActualizados += ps.executeUpdate();

            id++;
        }
        
        ps.close();

        return numRegistrosActualizados;
    }

    @Override
    public int insertar(Cliente client) throws SQLException{
        int numRegistrosActualizados = 0;
        final String SQL = "INSERT INTO Clientes VALUES (?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(SQL);

        ps.setInt(1, client.getId());
        ps.setString(2, client.getNombre());
        ps.setString(3, client.getCorreo());
        ps.setInt(4, client.getCodPostal());
        
        

        numRegistrosActualizados = ps.executeUpdate();
        ps.close();

        return numRegistrosActualizados;
    }

    @Override
    public Producto visualizarProducto(int id)throws SQLException, MercaDAWException {

        final String QUERY = "SELECT "+PROD_ID+", "+PROD_NOMB+", "+PROD_MARC+", "+PROD_DESC+", "+PROD_CATE+", "
                                +PROD_ALTU+", "+PROD_PREC+", "+PROD_ANCH+", "+PROD_PESO+", "+PROD_ELEM+", "+PROD_STOK+
                                " FROM Vista_Productos WHERE "+PROD_ID+"= ?";

        Producto producto = null;

        PreparedStatement ps = connection.prepareStatement(QUERY);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){

            String nombre = rs.getString(PROD_NOMB);
            String marca = rs.getString(PROD_MARC);
            String descr = rs.getString(PROD_DESC);
            String cate = rs.getString(PROD_CATE);
            double altu = rs.getDouble(PROD_ALTU);
            double anchu = rs.getDouble(PROD_ANCH);
            double peso = rs.getDouble(PROD_PESO);
            double precio = rs.getDouble(PROD_PREC);
            int num_elementos = rs.getInt(PROD_ELEM);
            int stock = rs.getInt(PROD_STOK);

            
            producto = ProductoFactory.obtener(cate, id, nombre, marca, altu, anchu, peso, num_elementos, stock, precio, descr);
        }

        rs.close();
        ps.close();

        return producto;
    }

    @Override
    public List<Producto> visualizarProductos() throws SQLException, MercaDAWException{

        final String QUERY = "SELECT "+PROD_ID+", "+PROD_NOMB+", "+PROD_MARC+", "+PROD_DESC+", "+PROD_CATE+", "
                            +PROD_ALTU+", "+PROD_PREC+", "+PROD_ANCH+", "+PROD_PESO+", "+PROD_ELEM+", "+PROD_STOK+" FROM Vista_Productos";
        
        List<Producto> productos = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(QUERY);
        ResultSet rs = ps.executeQuery();


        while(rs.next()){

            int id = rs.getInt(PROD_ID);
            String nombre = rs.getString(PROD_NOMB);
            String marca = rs.getString(PROD_MARC);
            String descr = rs.getString(PROD_DESC);
            String cate = rs.getString(PROD_CATE);
            double altu = rs.getDouble(PROD_ALTU);
            double anchu = rs.getDouble(PROD_ANCH);
            double peso = rs.getDouble(PROD_PESO);
            double precio = rs.getDouble(PROD_PREC);
            int num_elementos = rs.getInt(PROD_ELEM);
            int stock = rs.getInt(PROD_STOK);

            
            Producto producto = ProductoFactory.obtener(cate, id, nombre, marca, altu, anchu, peso, num_elementos, stock, precio, descr);
            productos.add(producto);
        }
        rs.close();
        ps.close();

        return productos;
    }

    @Override
    public Cliente visualizarCliente(int id) throws SQLException{

        final String QUERY = "SELECT "+CLIEN_ID+", "+CLIEN_POST+", "+CLIEN_NOMB+", "+CLIEN_CORR+" FROM Vista_Clientes WHERE "+CLIEN_ID+" = ?";


        PreparedStatement ps = connection.prepareStatement(QUERY);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        Cliente cliente = null;

        while(rs.next()){

            int codPostal = rs.getInt(CLIEN_POST);
            String nombre = rs.getString(CLIEN_NOMB);
            String correo = rs.getString(CLIEN_CORR);

            cliente = new Cliente(id, nombre, correo, codPostal); 
        }

        rs.close();
        ps.close();

        return cliente;
    }

    @Override
    public List<Cliente> visualizarClientes() throws SQLException{
        final String QUERY = "SELECT "+CLIEN_ID+", "+CLIEN_POST+", "+CLIEN_NOMB+", "+CLIEN_CORR+" FROM Vista_Clientes";


        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(QUERY);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){

            int id = rs.getInt(CLIEN_ID);
            int codPostal = rs.getInt(CLIEN_POST);
            String nombre = rs.getString(CLIEN_NOMB);
            String correo = rs.getString(CLIEN_CORR);

            Cliente cliente = new Cliente(id, nombre, correo, codPostal); 
            clientes.add(cliente);
        }

        rs.close();
        ps.close();

        return clientes;
    }

    @Override
    public List<Empleado> visualizarEmpleados() throws SQLException, MercaDAWException{
        final String QUERY = "SELECT "+EMPLE_ID+", "+EMPLE_NOMB+", "+EMPLE_APEL+", "+EMPLE_CATE+", "+EMPLE_FECH+" FROM Vista_Empleados";
        
        


        List<Empleado> empleados = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(QUERY);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){

            int id = rs.getInt(EMPLE_ID);
            String nombre = rs.getString(EMPLE_NOMB);
            String apellido = rs.getString(EMPLE_APEL);
            String categoria = rs.getString(EMPLE_CATE);
            Date fecha = rs.getDate(EMPLE_FECH);
            

            Empleado empleado = EmpleadoFactory.obtener(categoria, id, nombre, apellido, fecha); 
            empleados.add(empleado);
        }

        rs.close();
        ps.close();

        return empleados;
    }

    @Override
    public List<Compra> visualizarCompras() throws SQLException, MercaDAWException{
        final String QUERY = "SELECT "+COMP_ID+", "+PROD_ID+", "+CLIEN_ID+", "+COMP_FECH+" FROM Vista_Compras";

        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();
        List<Compra> compras = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(QUERY);
        ResultSet rs = ps.executeQuery();
        Compra compra;
        while(rs.next()){

            int id = rs.getInt(COMP_ID);
            Date fecha = rs.getDate(COMP_FECH);
            int prod = rs.getInt(PROD_ID);
            int cliente = rs.getInt(CLIEN_ID);
            
            
            Cliente cli = bbdd.visualizarCliente(cliente);
            Producto pr = bbdd.visualizarProducto(prod);

            List<Producto> productos = new ArrayList<>();
            productos.add(pr);

            compra = new Compra(id, fecha, cli, productos); 
            compras.add(compra);
        }

        rs.close();
        ps.close();

        return compras;
    } 
}
