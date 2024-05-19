package es.etg.daw.prog.mercadaw.model.util.reader;

import java.util.List;

import es.etg.daw.prog.mercadaw.model.entities.compras.Cliente;
import es.etg.daw.prog.mercadaw.model.entities.compras.Compra;
import es.etg.daw.prog.mercadaw.model.entities.empleados.Empleado;
import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;

/**
 * La interfaz Lector permite leer cada una de los entities disponibles .
 * \author Iván Rafael Redondo.
 */
public interface Lector {
    public List<Producto> leerProducto(String codigo) throws MercaDAWException;

    public List<Empleado> leerEmpleado(String codigo) throws MercaDAWException;

    public List<Cliente> leerCliente(String codigo) throws MercaDAWException;

    public List<Compra> leerCompra(String codigo) throws MercaDAWException;
}
