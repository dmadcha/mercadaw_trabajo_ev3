package es.etg.daw.prog.mercadaw.model.bbdd;

import java.sql.SQLException;
import java.util.List;

import es.etg.daw.prog.mercadaw.model.entities.compras.Cliente;
import es.etg.daw.prog.mercadaw.model.entities.compras.Compra;
import es.etg.daw.prog.mercadaw.model.entities.empleados.Empleado;
import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;

/**
 * La interfaz MercaDAO expone los metodos de acceso a la base de datos.
 * \author Jesús Pérez Enríquez.
 */
public interface MercaDAO {

    /**
     * Prepara la base de datos. (Crea las tablas y vistas).
     * \throws SQLException
     */
    public void iniciarBBDD() throws SQLException;

    /**
     * Inserta el empleado en la Base de datos.
     * \param empleado Empleado a insertar.
     */
    public int insertar(Empleado emp) throws SQLException;

    /**
     * Inserta el producto en la Base de datos.
     * \param producto Producto a insertar.
     */
    public int insertar(Producto prod) throws SQLException;

    /**
     * Inserta la compra en la Base de datos.
     * \param compra Compra a insertar.
     */
    public int insertar(Compra compra) throws SQLException;

    /**
     * Inserta el cliente en la Base de datos.
     * \param client Cliente a insertar.
     */
    public int insertar(Cliente client) throws SQLException;
    
    /**
     * 
     * @param id
     * @return
     */
    public Producto visualizarProducto(int id) throws SQLException, MercaDAWException;

    /**
     * Devuelve la lista de Clientes de la BD completa.
     * \return Una lista de Clientes.
     */
    public List<Producto> visualizarProductos() throws SQLException, MercaDAWException;

    /**
     * 
     * @param id
     * @return
     */
    public Cliente visualizarCliente(int id) throws SQLException;

    /**
     * Devuelve la lista de Clientes de la BD completa.
     * \return Una lista de Clientes.
     */
    public List<Cliente> visualizarClientes() throws SQLException;

    /**
     * Devuelve la lista de Empleados de la BD completa.
     * \return Una lista de Empleados.
     */
    public List<Empleado> visualizarEmpleados() throws SQLException, MercaDAWException;

    /**
     * Devuelve la lista de Compras de la BD completa.
     * \return Una lista de Compras.
     */
    public List<Compra> visualizarCompras() throws SQLException, MercaDAWException;
}