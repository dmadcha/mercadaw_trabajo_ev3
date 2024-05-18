package es.etg.daw.prog.mercadaw.model.bbdd;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.etg.daw.prog.mercadaw.model.entities.compras.Cliente;
import es.etg.daw.prog.mercadaw.model.entities.compras.Compra;
import es.etg.daw.prog.mercadaw.model.entities.empleados.Empleado;
import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;
import es.etg.daw.prog.mercadaw.model.entities.productos.ProductoFactory;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;



/**
 * La clase MercaDAOImpMock provee de datos de prueba para el desarrollo del software.
 * \author Jesús Pérez Enríquez.
 */
public class MercaDAOImpMock implements MercaDAO{

    @Override
    public void iniciarBBDD() throws SQLException {
    }

    @Override
    public int insertar(Empleado emp) throws SQLException {
        return 1;
    }

    @Override
    public int insertar(Producto prod) throws SQLException {
        return 1;
    }

    @Override
    public int insertar(Compra compra) throws SQLException {
        return 1;
    }

    @Override
    public int insertar(Cliente client) throws SQLException {
        return 1;
    }

    @Override
    public Producto visualizarProducto(int id) throws MercaDAWException{
        return ProductoFactory.obtener(null, id, null, null, 0, 0, 0, 0, 0, 0, null);
    }

    @Override
    public List<Producto> visualizarProductos() throws MercaDAWException{
        
        Producto pr1 = ProductoFactory.obtener(null, null, null, null, 0, 0, 0, 0, 0, 0, null);
        Producto pr2 = ProductoFactory.obtener(null, null, null, null, 0, 0, 0, 0, 0, 0, null);
        Producto pr3 = ProductoFactory.obtener(null, null, null, null, 0, 0, 0, 0, 0, 0, null);
        
        List<Producto> productos = new ArrayList<>();
        
        productos.add(pr1);
        productos.add(pr2);
        productos.add(pr3);

        return productos;
    }

    @Override
    public Cliente visualizarCliente(int id){
        return new Cliente(null, "PRUEBA", "CORREO", 00000);
    }

    @Override
    public List<Cliente> visualizarClientes(){
        
        Cliente cl1 = new Cliente(null, "PRUEBA", "CORREO", 00000);
        Cliente cl2 = new Cliente(null, "PRUEBA", "CORREO", 00000);
        Cliente cl3 = new Cliente(null, "PRUEBA", "CORREO", 00000);

        List<Cliente> clientes = new ArrayList<>();
        
        clientes.add(cl1);
        clientes.add(cl2);
        clientes.add(cl3);

        return clientes;
    }

    @Override
    public List<Empleado> visualizarEmpleados() throws MercaDAWException {
        Empleado emp1 = new Empleado(null, "PRUEBA", "APELLIDOS");
        Empleado emp2 = new Empleado(null, "PRUEBA", "APELLIDOS");
        Empleado emp3 = new Empleado(null, "PRUEBA", "APELLIDOS");
        
        List<Empleado> empleados = new ArrayList<>();
        
        empleados.add(emp1);
        empleados.add(emp2);
        empleados.add(emp3);

        return empleados;
    }

    @Override
    public List<Compra> visualizarCompras() throws MercaDAWException {
        
        List<Producto> productos = new ArrayList<>();
        List<Compra> compras = new ArrayList<>();
        Cliente clie = new Cliente(null, "PRUEBA", "CORREO", 00000);

        Producto pr1 = ProductoFactory.obtener(null, null, null, null, 0, 0, 0, 0, 0, 0, null);
        Producto pr2 = ProductoFactory.obtener(null, null, null, null, 0, 0, 0, 0, 0, 0, null);
        Producto pr3 = ProductoFactory.obtener(null, null, null, null, 0, 0, 0, 0, 0, 0, null);
          
        productos.add(pr1);
        productos.add(pr2);
        productos.add(pr3);
        

        Compra compra = new Compra(null, null, clie, productos);
        Compra compra2 = new Compra(null, null, clie, productos);
        Compra compra3 = new Compra(null, null, clie, productos);

        compras.add(compra);
        compras.add(compra2);
        compras.add(compra3);
        
        return compras;
    }
}
