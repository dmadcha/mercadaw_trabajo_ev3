package es.etg.daw.prog.mercadaw.model.bbdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.etg.daw.prog.mercadaw.model.entities.Cliente;
import es.etg.daw.prog.mercadaw.model.entities.Compra;
import es.etg.daw.prog.mercadaw.model.entities.Empleado;
import es.etg.daw.prog.mercadaw.model.entities.Producto;

/**
 * La clase MercaDAOImpMock provee de datos de prueba para el desarrollo del software.
 * \author Jesús Pérez Enríquez.
 */
public class MercaDAOImpMock implements MercaDAO{

    @Override
    public void insertar(Empleado emp) {
    }

    @Override
    public void insertar(Producto prod) {
    }

    @Override
    public void insertar(Compra compra) {
    }

    @Override
    public void insertar(Cliente client) {
    }

    @Override
    public Producto visualizarProducto() {
        return new Producto();
    }

    @Override
    public List<Producto> visualizarProductos() {
        return new ArrayList<Producto>();
    }

    @Override
    public List<Cliente> visualizarClientes() {
        return new ArrayList<Cliente>();
    }

    @Override
    public List<Empleado> visualizarEmpleados() {
        return new ArrayList<Empleado>();
    }

    @Override
    public List<Compra> visualizarCompras() {
        return new ArrayList<Compra>();
    }

    @Override
    public Map<Producto, Integer> visualizarStock() {
        return new HashMap<Producto,Integer>();
    }
}
