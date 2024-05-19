package es.etg.daw.prog.mercadaw.model.util.reader;

import java.util.List;

import es.etg.daw.prog.mercadaw.model.entities.compras.Cliente;
import es.etg.daw.prog.mercadaw.model.entities.compras.Compra;
import es.etg.daw.prog.mercadaw.model.entities.empleados.Empleado;
import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;

public class LectorMock implements Lector{

    @Override
    public List<Producto> leerProducto(String codigo) throws MercaDAWException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'leerProducto'");
    }

    @Override
    public List<Empleado> leerEmpleado(String codigo) throws MercaDAWException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'leerEmpleado'");
    }

    @Override
    public List<Cliente> leerCliente(String codigo) throws MercaDAWException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'leerCliente'");
    }

    @Override
    public List<Compra> leerCompra(String codigo) throws MercaDAWException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'leerCompra'");
    }
    
}
