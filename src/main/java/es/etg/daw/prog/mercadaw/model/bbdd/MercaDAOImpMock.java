package es.etg.daw.prog.mercadaw.model.bbdd;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import es.etg.daw.prog.mercadaw.model.entities.compras.Cliente;
import es.etg.daw.prog.mercadaw.model.entities.compras.Compra;
import es.etg.daw.prog.mercadaw.model.entities.empleados.Empleado;
import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;



/**
 * La clase MercaDAOImpMock provee de datos de prueba para el desarrollo del software.
 * \author Jesús Pérez Enríquez.
 */
public class MercaDAOImpMock implements MercaDAO{

    @Override
    public void iniciarBBDD() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iniciarBBDD'");
    }

    @Override
    public int insertar(Empleado emp) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public int insertar(Producto prod) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public int insertar(Compra compra) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public int insertar(Cliente client) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public Producto visualizarProducto() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualizarProducto'");
    }

    @Override
    public List<Producto> visualizarProductos() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualizarProductos'");
    }

    @Override
    public List<Cliente> visualizarClientes() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualizarClientes'");
    }

    @Override
    public List<Empleado> visualizarEmpleados() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualizarEmpleados'");
    }

    @Override
    public List<Compra> visualizarCompras() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualizarCompras'");
    }

}
