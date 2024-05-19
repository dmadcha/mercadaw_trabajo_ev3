package es.etg.daw.prog.mercadaw.model.bbdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import es.etg.daw.prog.mercadaw.model.entities.compras.Cliente;
import es.etg.daw.prog.mercadaw.model.entities.compras.Compra;
import es.etg.daw.prog.mercadaw.model.entities.empleados.Empleado;
import es.etg.daw.prog.mercadaw.model.entities.empleados.EmpleadoFactory;
import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;
import es.etg.daw.prog.mercadaw.model.entities.productos.ProductoFactory;

public class MercaDAOImpOracleXETest {
    @Test
    public void iniciarBBDDTest() throws Exception{
        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();
        bbdd.iniciarBBDD();
    }



    @Test
    public void insertarEmpleadoTest() throws Exception{
        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();

        Empleado emp1 = EmpleadoFactory.obtener("REPONEDOR", 1, "Paco", "Fiestas", null);
        Empleado emp2 = EmpleadoFactory.obtener("CAJERO", 2, "Juan", "Chicle", null);
        Empleado emp3 = EmpleadoFactory.obtener("EMPLEADO", 3, "Tony", "Stark", null);
        Empleado emp4 = EmpleadoFactory.obtener("ENCARGADO", 4, "Bruce", "Wane", null);


        int inserccionesEsperadas = 4;
        int insercciones = 0;

        insercciones += bbdd.insertar(emp1);
        insercciones += bbdd.insertar(emp2);
        insercciones += bbdd.insertar(emp3);
        insercciones += bbdd.insertar(emp4);        


        assertEquals(inserccionesEsperadas, insercciones);

    }

    @Test
    public void insertarProductoTest() throws Exception{
        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();

        Producto pr1 = ProductoFactory.obtener("Alimentacion", 1, "ACEITE", "OLIVA", 2, 8, 1, 1, 1, 10.99, "Aceite de oliva");
        Producto pr2 = ProductoFactory.obtener("Cosmetica", 2, "Crema Hidratante Facial", "BellaPiel", 10, 5, 200, 1, 75, 15.50, "Crema hidratante facial con ácido hialurónico y vitamina E. Ideal para todo tipo de pieles, proporciona hidratación profunda y protección contra los radicales libres."); 
        Producto pr3 = ProductoFactory.obtener("Drogueria", 3, "Detergente Líquido", "CleanWave", 30, 12, 1500, 1, 200, 8.75, "Detergente líquido para ropa, apto para todo tipo de tejidos y colores. Fórmula concentrada que elimina las manchas más difíciles y deja la ropa con un aroma fresco y duradero.");

        int inserccionesEsperadas = 3;
        int insercciones = 0;


        insercciones += bbdd.insertar(pr1);
        insercciones += bbdd.insertar(pr2);
        insercciones += bbdd.insertar(pr3);

        assertEquals(inserccionesEsperadas, insercciones);


        

    }

    @Test
    public void insertarClienteTest() throws Exception{
        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();

        Cliente cl1 = new Cliente(1, "María López", "maria@example.com", 28001);
        Cliente cl2 = new Cliente(2, "Juan Martínez", "juan@example.com", 25842);
        
        int inserccionesEsperadas = 2;
        int insercciones = 0;


        insercciones += bbdd.insertar(cl1);
        insercciones += bbdd.insertar(cl2);

        assertEquals(inserccionesEsperadas, insercciones);

    }

    @Test
    public void insertarCompraTest() throws Exception{
        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();
       
        List<Producto> productos = new ArrayList<Producto>();

        Cliente cl1 = new Cliente(1, "María López", "maria@example.com", 28001);

        Producto pr1 = ProductoFactory.obtener("Alimentacion", 1, "Aceite de Oliva Virgen Extra", "OlivaDorada", 25, 8, 1, 1, 150, 10.99, "Aceite de oliva virgen extra de la mejor calidad, prensado en frío y sin aditivos. Perfecto para ensaladas, cocinar y dar sabor a tus platos favoritos.");
        Producto pr2 = ProductoFactory.obtener("Cosmetica", 2, "Crema Hidratante Facial", "BellaPiel", 10, 5, 200, 1, 75, 15.50, "Crema hidratante facial con ácido hialurónico y vitamina E. Ideal para todo tipo de pieles, proporciona hidratación profunda y protección contra los radicales libres."); 
        Producto pr3 = ProductoFactory.obtener("Drogueria", 3, "Detergente Líquido", "CleanWave", 30, 12, 1500, 1, 200, 8.75, "Detergente líquido para ropa, apto para todo tipo de tejidos y colores. Fórmula concentrada que elimina las manchas más difíciles y deja la ropa con un aroma fresco y duradero.");

        Compra compra = new Compra(1, null, cl1, productos);

        productos.add(pr1);
        productos.add(pr2);
        productos.add(pr3); 

        int inserccionesEsperadas = productos.size();
        int insercciones = 0;

          

        insercciones += bbdd.insertar(compra);

        assertEquals(inserccionesEsperadas, insercciones);

    }



    @Test
    public void visualizarClienteTest() throws Exception{
        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();
        Cliente cl = new Cliente(1, "María López", "maria@example.com", 28001);
        Cliente cliente = bbdd.visualizarCliente(1);
        boolean funciona = false;

        if (cliente.getId() == cl.getId()) {
            funciona = true;
        }

        assertTrue(funciona);
    }

    @Test
    public void visualizarClientesTest() throws Exception{
        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();
        List<Cliente> clientesEsperados = new ArrayList<>();
        List<Cliente> clientes = bbdd.visualizarClientes();

        Cliente cl = new Cliente(1, "María López", "maria@example.com", 28001);
        Cliente c2 = new Cliente(2, "Juan Martínez", "juan@example.com", 25842);
        
        boolean funciona = false;

        clientesEsperados.add(cl);
        clientesEsperados.add(c2);


        if (clientes.get(0).getId() == clientesEsperados.get(0).getId()) {
            funciona = true;
        }

        assertTrue(funciona);
    }


    @Test
    public void visualizarEmpleadosTest() throws Exception{
        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();
        List<Empleado> empleadosEsperados = new ArrayList<>();
        List<Empleado> empleados = bbdd.visualizarEmpleados();

        Empleado emp1 = EmpleadoFactory.obtener("REPONEDOR", 1, "Paco", "Fiestas", null);
        Empleado emp2 = EmpleadoFactory.obtener("CAJERO", 2, "Juan", "Chicle", null);
        Empleado emp3 = EmpleadoFactory.obtener("EMPLEADO", 3, "Tony", "Stark", null);
        Empleado emp4 = EmpleadoFactory.obtener("ENCARGADO", 4, "Bruce", "Wane", null);
        
        boolean funciona = false;

        empleadosEsperados.add(emp1);
        empleadosEsperados.add(emp2);
        empleadosEsperados.add(emp3);
        empleadosEsperados.add(emp4);


        if (empleados.get(0).getId() == emp1.getId()) {
            funciona = true;
        }

        assertTrue(funciona);        
    }


    @Test
    public void visualizarProductoTest() throws Exception{
        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();
        Producto pr1 = ProductoFactory.obtener("Alimentacion", 1, "Aceite de Oliva Virgen Extra", "OlivaDorada", 25, 8, 1, 1, 150, 10.99, "Aceite de oliva virgen extra de la mejor calidad, prensado en frío y sin aditivos. Perfecto para ensaladas, cocinar y dar sabor a tus platos favoritos.");
        Producto pr2 = bbdd.visualizarProducto(1);
        boolean funciona = false;

        if (pr2.getId() == pr1.getId()) {
            funciona = true;
        }

        assertTrue(funciona);
    }
    
    @Test
    public void visualizarProductosTest() throws Exception{

        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();
        List<Producto> productosEsperado = new ArrayList<>();
        List<Producto> productos = bbdd.visualizarProductos();

        Producto pr1 = ProductoFactory.obtener("Alimentacion", 1, "ACEITE", "OLIVA", 2, 8, 1, 1, 1, 10.99, "Aceite de oliva");
        Producto pr2 = ProductoFactory.obtener("Cosmetica", 2, "Crema Hidratante Facial", "BellaPiel", 10, 5, 200, 1, 75, 15.50, "Crema hidratante facial con ácido hialurónico y vitamina E. Ideal para todo tipo de pieles, proporciona hidratación profunda y protección contra los radicales libres."); 
        Producto pr3 = ProductoFactory.obtener("Drogueria", 3, "Detergente Líquido", "CleanWave", 30, 12, 1500, 1, 200, 8.75, "Detergente líquido para ropa, apto para todo tipo de tejidos y colores. Fórmula concentrada que elimina las manchas más difíciles y deja la ropa con un aroma fresco y duradero.");
        

        boolean funciona = false;

        productosEsperado.add(pr1);
        productosEsperado.add(pr2);
        productosEsperado.add(pr3);

        


        if (productosEsperado.get(0).getId() == productos.get(0).getId()) {
            funciona = true;
        }

        assertTrue(funciona);
    }


    @Test
    public void visualizarComprasTest() throws Exception{

        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();
        
        List<Compra> comprasEsperadas = new ArrayList<>();
        List<Compra> comprasResultado = bbdd.visualizarCompras();
        Cliente cl1 = new Cliente(1, "María López", "maria@example.com", 28001);

        List<Producto> productos = new ArrayList<Producto>();
        Producto pr1 = ProductoFactory.obtener("Alimentacion", 1, "Aceite de Oliva Virgen Extra", "OlivaDorada", 25, 8, 1, 1, 150, 10.99, "Aceite de oliva virgen extra de la mejor calidad, prensado en frío y sin aditivos. Perfecto para ensaladas, cocinar y dar sabor a tus platos favoritos.");
        Producto pr2 = ProductoFactory.obtener("Cosmetica", 2, "Crema Hidratante Facial", "BellaPiel", 10, 5, 200, 1, 75, 15.50, "Crema hidratante facial con ácido hialurónico y vitamina E. Ideal para todo tipo de pieles, proporciona hidratación profunda y protección contra los radicales libres."); 
        Producto pr3 = ProductoFactory.obtener("Drogueria", 3, "Detergente Líquido", "CleanWave", 30, 12, 1500, 1, 200, 8.75, "Detergente líquido para ropa, apto para todo tipo de tejidos y colores. Fórmula concentrada que elimina las manchas más difíciles y deja la ropa con un aroma fresco y duradero.");
        
        
        productos.add(pr1);
        productos.add(pr2);
        productos.add(pr3);

        Compra compra = new Compra(productos.size(), null, cl1, productos);

        comprasEsperadas.add(compra);

        boolean funciona = false;


        if (comprasEsperadas.get(0).getId() == comprasResultado.get(0).getId()) {
            funciona = true;
        }

        assertTrue(funciona);
    }

    @Test
    public void borrarTablas() throws Exception{
        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();
        Statement st = bbdd.getConnection().createStatement();

        final String EMPELADOS = "DROP TABLE EMPLEADOS";
        final String COMPRAS = "DROP TABLE COMPRAS";
        final String PRODUCTOS = "DROP TABLE PRODUCTOS";
        final String CLIENTES = "DROP TABLE CLIENTES";


        st.execute(EMPELADOS);
        st.execute(COMPRAS);
        st.execute(PRODUCTOS);
        st.execute(CLIENTES);

        st.close();
    }
}
