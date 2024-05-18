package es.etg.daw.prog.mercadaw.model.bbdd;


import java.sql.Date;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
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

        Empleado emp = new Empleado(0, "Paco", "Fiestas");
        bbdd.insertar(emp);
    }


    @Test
    public void insertarProductoTest() throws Exception{
        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();

        Producto pr1 = ProductoFactory.obtener("Alimentacion", null, "ACEITE", "OLIVA", 2, 8, 1, 1, 1, 10.99, "Aceite de oliva");
        Producto pr2 = ProductoFactory.obtener("Cosmetica", null, "Crema Hidratante Facial", "BellaPiel", 10, 5, 200, 1, 75, 15.50, "Crema hidratante facial con ácido hialurónico y vitamina E. Ideal para todo tipo de pieles, proporciona hidratación profunda y protección contra los radicales libres."); 
        Producto pr3 = ProductoFactory.obtener("Drogueria", null, "Detergente Líquido", "CleanWave", 30, 12, 1500, 1, 200, 8.75, "Detergente líquido para ropa, apto para todo tipo de tejidos y colores. Fórmula concentrada que elimina las manchas más difíciles y deja la ropa con un aroma fresco y duradero.");

        bbdd.insertar(pr1);
        bbdd.insertar(pr2);
        bbdd.insertar(pr3);

        

    }

    @Test
    public void insertarClienteTest() throws Exception{
        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();

        Cliente cl1 = new Cliente(null, "María López", "maria@example.com", 28001);
        Cliente cl2 = new Cliente(null, "Juan Martínez", "juan@example.com", 25842);
        
        bbdd.insertar(cl1);
        bbdd.insertar(cl2);

    }

    @Test
    public void insertarCompraTest() throws Exception{
        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();

        Cliente cliente = new Cliente(0, "Paco", "@pack", 28001);

        Producto pr1 = ProductoFactory.obtener("Alimentacion", 0, "Aceite de Oliva Virgen Extra", "OlivaDorada", 25, 8, 1, 1, 150, 10.99, "Aceite de oliva virgen extra de la mejor calidad, prensado en frío y sin aditivos. Perfecto para ensaladas, cocinar y dar sabor a tus platos favoritos.");
        Producto pr2 = ProductoFactory.obtener("Cosmetica", 1, "Crema Hidratante Facial", "BellaPiel", 10, 5, 200, 1, 75, 15.50, "Crema hidratante facial con ácido hialurónico y vitamina E. Ideal para todo tipo de pieles, proporciona hidratación profunda y protección contra los radicales libres."); 
        Producto pr3 = ProductoFactory.obtener("Drogueria", 2, "Detergente Líquido", "CleanWave", 30, 12, 1500, 1, 200, 8.75, "Detergente líquido para ropa, apto para todo tipo de tejidos y colores. Fórmula concentrada que elimina las manchas más difíciles y deja la ropa con un aroma fresco y duradero.");

        List<Producto> productos = new ArrayList<Producto>();

        productos.add(pr1);
        productos.add(pr2);
        productos.add(pr3);

        Date fecha = new Date(1003);

        Compra compra = new Compra(null, fecha, cliente, productos);
        bbdd.insertar(compra);
    }


    @BeforeAll
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
