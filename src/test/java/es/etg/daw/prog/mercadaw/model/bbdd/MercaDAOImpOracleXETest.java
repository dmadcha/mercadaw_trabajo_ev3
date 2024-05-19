package es.etg.daw.prog.mercadaw.model.bbdd;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import es.etg.daw.prog.mercadaw.model.entities.compras.Cliente;
import es.etg.daw.prog.mercadaw.model.entities.compras.Compra;
import es.etg.daw.prog.mercadaw.model.entities.empleados.Empleado;
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

        Empleado emp = new Empleado(0, "Paco", "Fiestas", null);
        bbdd.insertar(emp);
    }

    @Test
    public void insertarProductoTest() throws Exception{
        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();

        Producto pr1 = ProductoFactory.obtener("Alimentacion", 0, "ACEITE", "OLIVA", 2, 8, 1, 1, 1, 10.99, "Aceite de oliva");
        Producto pr2 = ProductoFactory.obtener("Cosmetica", 1, "Crema Hidratante Facial", "BellaPiel", 10, 5, 200, 1, 75, 15.50, "Crema hidratante facial con ácido hialurónico y vitamina E. Ideal para todo tipo de pieles, proporciona hidratación profunda y protección contra los radicales libres."); 
        Producto pr3 = ProductoFactory.obtener("Drogueria", 2, "Detergente Líquido", "CleanWave", 30, 12, 1500, 1, 200, 8.75, "Detergente líquido para ropa, apto para todo tipo de tejidos y colores. Fórmula concentrada que elimina las manchas más difíciles y deja la ropa con un aroma fresco y duradero.");

        bbdd.insertar(pr1);
        bbdd.insertar(pr2);
        bbdd.insertar(pr3);

        

    }

    @Test
    public void insertarClienteTest() throws Exception{
        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();

        Cliente cl1 = new Cliente(0, "María López", "maria@example.com", 28001);
        Cliente cl2 = new Cliente(1, "Juan Martínez", "juan@example.com", 25842);
        
        bbdd.insertar(cl1);
        bbdd.insertar(cl2);

    }

    @Test
    public void insertarCompraTest() throws Exception{
        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();

        Cliente cl1 = new Cliente(0, "María López", "maria@example.com", 28001);

        Producto pr1 = ProductoFactory.obtener("Alimentacion", 0, "Aceite de Oliva Virgen Extra", "OlivaDorada", 25, 8, 1, 1, 150, 10.99, "Aceite de oliva virgen extra de la mejor calidad, prensado en frío y sin aditivos. Perfecto para ensaladas, cocinar y dar sabor a tus platos favoritos.");
        Producto pr2 = ProductoFactory.obtener("Cosmetica", 1, "Crema Hidratante Facial", "BellaPiel", 10, 5, 200, 1, 75, 15.50, "Crema hidratante facial con ácido hialurónico y vitamina E. Ideal para todo tipo de pieles, proporciona hidratación profunda y protección contra los radicales libres."); 
        Producto pr3 = ProductoFactory.obtener("Drogueria", 2, "Detergente Líquido", "CleanWave", 30, 12, 1500, 1, 200, 8.75, "Detergente líquido para ropa, apto para todo tipo de tejidos y colores. Fórmula concentrada que elimina las manchas más difíciles y deja la ropa con un aroma fresco y duradero.");

        List<Producto> productos = new ArrayList<Producto>();

        productos.add(pr1);
        productos.add(pr2);
        productos.add(pr3);

        Date fecha = new Date(1003);

        Compra compra = new Compra(0, fecha, cl1, productos);
        bbdd.insertar(compra);
    }



    @Test
    public void visualizarClienteTest() throws Exception{
        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();
        Cliente cl = new Cliente(0, "María López", "maria@example.com", 28001);
        Cliente cliente = bbdd.visualizarCliente(0);
        boolean sonIguales = false;

        if (cliente.getId() == cl.getId()) {
            sonIguales = true;
        }

        assertTrue(sonIguales);
    }

    @Test
    public void visualizarClientesTest() throws Exception{
        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();
        List<Cliente> clientesEsperados = new ArrayList<>();
        List<Cliente> clientes = bbdd.visualizarClientes();

        Cliente cl = new Cliente(0, "María López", "maria@example.com", 28001);
        Cliente c2 = new Cliente(1, "Juan Martínez", "juan@example.com", 25842);
        
        boolean sonIguales = false;

        clientesEsperados.add(cl);
        clientesEsperados.add(c2);


        if (clientes.get(0).getId() == clientesEsperados.get(0).getId()) {
            sonIguales = true;
        }

        assertTrue(sonIguales);
    }


    @Test
    public void visualizarEmpleadosTest() throws Exception{
        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();
        List<Empleado> empleadosEsperados = new ArrayList<>();
        List<Empleado> empleados = bbdd.visualizarEmpleados();

        Empleado emp = new Empleado(0, "Paco", "Fiestas", null);
        
        boolean sonIguales = false;

        empleadosEsperados.add(emp);
        


        if (empleadosEsperados.get(0).getId() == empleados.get(0).getId()) {
            sonIguales = true;
        }

        assertTrue(sonIguales);
    }


    @Test
    public void visualizarProductoTest() throws Exception{
        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();
        Producto pr1 = ProductoFactory.obtener("Alimentacion", 0, "Aceite de Oliva Virgen Extra", "OlivaDorada", 25, 8, 1, 1, 150, 10.99, "Aceite de oliva virgen extra de la mejor calidad, prensado en frío y sin aditivos. Perfecto para ensaladas, cocinar y dar sabor a tus platos favoritos.");
        Producto pr2 = bbdd.visualizarProducto(0);
        boolean sonIguales = false;

        if (pr2.getId() == pr1.getId()) {
            sonIguales = true;
        }

        assertTrue(sonIguales);
    }
    
    @Test
    public void visualizarProductosTest() throws Exception{

        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();
        List<Producto> productosEsperado = new ArrayList<>();
        List<Producto> productos = bbdd.visualizarProductos();

        Producto pr1 = ProductoFactory.obtener("Alimentacion", 0, "ACEITE", "OLIVA", 2, 8, 1, 1, 1, 10.99, "Aceite de oliva");
        Producto pr2 = ProductoFactory.obtener("Cosmetica", 1, "Crema Hidratante Facial", "BellaPiel", 10, 5, 200, 1, 75, 15.50, "Crema hidratante facial con ácido hialurónico y vitamina E. Ideal para todo tipo de pieles, proporciona hidratación profunda y protección contra los radicales libres."); 
        Producto pr3 = ProductoFactory.obtener("Drogueria", 2, "Detergente Líquido", "CleanWave", 30, 12, 1500, 1, 200, 8.75, "Detergente líquido para ropa, apto para todo tipo de tejidos y colores. Fórmula concentrada que elimina las manchas más difíciles y deja la ropa con un aroma fresco y duradero.");
        

        boolean sonIguales = false;

        productosEsperado.add(pr1);
        productosEsperado.add(pr2);
        productosEsperado.add(pr3);

        


        if (productosEsperado.get(0).getId() == productos.get(0).getId()) {
            sonIguales = true;
        }

        assertTrue(sonIguales);
    }


    @Test
    public void visualizarComprasTest() throws Exception{

        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();
        List<Compra> comprasEsperadas = new ArrayList<>();
        List<Compra> compras = bbdd.visualizarCompras();

        Cliente cl1 = new Cliente(0, "María López", "maria@example.com", 28001);

        Producto pr1 = ProductoFactory.obtener("Alimentacion", 0, "Aceite de Oliva Virgen Extra", "OlivaDorada", 25, 8, 1, 1, 150, 10.99, "Aceite de oliva virgen extra de la mejor calidad, prensado en frío y sin aditivos. Perfecto para ensaladas, cocinar y dar sabor a tus platos favoritos.");
        Producto pr2 = ProductoFactory.obtener("Cosmetica", 1, "Crema Hidratante Facial", "BellaPiel", 10, 5, 200, 1, 75, 15.50, "Crema hidratante facial con ácido hialurónico y vitamina E. Ideal para todo tipo de pieles, proporciona hidratación profunda y protección contra los radicales libres."); 
        Producto pr3 = ProductoFactory.obtener("Drogueria", 2, "Detergente Líquido", "CleanWave", 30, 12, 1500, 1, 200, 8.75, "Detergente líquido para ropa, apto para todo tipo de tejidos y colores. Fórmula concentrada que elimina las manchas más difíciles y deja la ropa con un aroma fresco y duradero.");

        List<Producto> productos = new ArrayList<Producto>();

        productos.add(pr1);
        productos.add(pr2);
        productos.add(pr3);

        Date fecha = new Date(1003);

        Compra compra = new Compra(0, fecha, cl1, productos);

        comprasEsperadas.add(compra);

        boolean sonIguales = false;


        if (comprasEsperadas.get(0).getId() == compras.get(0).getId()) {
            sonIguales = true;
        }

        assertTrue(sonIguales);
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
