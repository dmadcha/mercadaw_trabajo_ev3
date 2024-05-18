package es.etg.daw.prog.mercadaw.model.bbdd;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import es.etg.daw.prog.mercadaw.model.entities.compras.Cliente;
import es.etg.daw.prog.mercadaw.model.entities.compras.Compra;
import es.etg.daw.prog.mercadaw.model.entities.empleados.Empleado;
import es.etg.daw.prog.mercadaw.model.entities.productos.Alimentacion;
import es.etg.daw.prog.mercadaw.model.entities.productos.Cosmetica;
import es.etg.daw.prog.mercadaw.model.entities.productos.Drogueria;
import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;

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
    public void insertarCompraTest() throws Exception{
        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();

        Cliente cliente = new Cliente(null, "Paco", "@pack", "28001");

        Producto producto = new Drogueria(null, "Perfumes", "OneDirecction", 0.15, 0.20, 0.3, 1, "Una nueva fragancia olores exclusivos del himalalla");
        Producto producto2 = new Cosmetica(null, "Maquillaje Embalaje", "Cajas", 0.25, 0.60, 0.7, 4, "Este maqullaje te dejará la cara en forma de embalaje");
        Producto producto3 = new Alimentacion(null, "Patatas Adelgazadoras", "Sano", 0.8, 0.6, 1.2, 9, "Estas patatas grasientas hacen perder peso de forma incremental");

        List<Producto> productos = new ArrayList<Producto>();

        productos.add(producto);
        productos.add(producto2);
        productos.add(producto3);

        Date fecha = new Date(1003);

        Compra compra = new Compra(null, fecha, cliente, productos);
        bbdd.insertar(compra);
    }

}
