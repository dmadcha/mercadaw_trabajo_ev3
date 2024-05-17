package es.etg.daw.prog.mercadaw.model.bbdd;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


import es.etg.daw.prog.mercadaw.model.exception.BBDDException;

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
    public void insertar(es.etg.daw.prog.mercadaw.model.entities.empleados.Empleado emp) throws BBDDException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public void insertar(es.etg.daw.prog.mercadaw.model.entities.productos.Producto prod) throws BBDDException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public void insertar(es.etg.daw.prog.mercadaw.model.entities.compras.Compra compra) throws BBDDException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public void insertar(es.etg.daw.prog.mercadaw.model.entities.compras.Cliente client) throws BBDDException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public es.etg.daw.prog.mercadaw.model.entities.productos.Producto visualizarProducto() throws BBDDException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualizarProducto'");
    }

    @Override
    public List<es.etg.daw.prog.mercadaw.model.entities.productos.Producto> visualizarProductos() throws BBDDException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualizarProductos'");
    }

    @Override
    public List<es.etg.daw.prog.mercadaw.model.entities.compras.Cliente> visualizarClientes() throws BBDDException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualizarClientes'");
    }

    @Override
    public List<es.etg.daw.prog.mercadaw.model.entities.empleados.Empleado> visualizarEmpleados() throws BBDDException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualizarEmpleados'");
    }

    @Override
    public List<es.etg.daw.prog.mercadaw.model.entities.compras.Compra> visualizarCompras() throws BBDDException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualizarCompras'");
    }

    @Override
    public Map<es.etg.daw.prog.mercadaw.model.entities.productos.Producto, Integer> visualizarStock()
            throws BBDDException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualizarStock'");
    }


}
