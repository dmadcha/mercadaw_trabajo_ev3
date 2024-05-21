package es.etg.daw.prog.mercadaw.model.bbdd;

import java.sql.SQLException;
import java.util.List;

import es.etg.daw.prog.mercadaw.model.entities.compras.Cliente;
import es.etg.daw.prog.mercadaw.model.entities.compras.Compra;
import es.etg.daw.prog.mercadaw.model.entities.empleados.Empleado;
import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;
import es.etg.daw.prog.mercadaw.model.exception.BBDDException;

/**
 * La interfaz MercaDAO expone los metodos de acceso a la base de datos.
 * \author Jesús Pérez Enríquez.
 */
public interface MercaDAO {

    /**
     * Prepara la base de datos. (Crea las tablas y vistas).
     * \throws SQLException
     */
    public void iniciarBBDD() throws BBDDException;

    /**
     * Inserta el Empleado en la Base de datos.
     * \param empleado Empleado a insertar.
     * \return int Numero de insercciones completadas.
     * \throws SQLException
     */
    public int insertar(Empleado emp) throws BBDDException;

    /**
     * Inserta el Producto en la Base de datos.
     * \param producto Producto a insertar.
     * \return int Numero de insercciones completadas. 
     * \throws SQLException
     */
    public int insertar(Producto prod) throws BBDDException;

    /**
     * Inserta la Compra en la Base de datos.
     * \param compra Compra a insertar.
     * \return int Numero de insercciones completadas. 
     * \throws SQLException
     */
    public int insertar(Compra compra) throws BBDDException;

    /**
     * Inserta el Cliente en la Base de datos.
     * \param client Cliente a insertar.
     * \return int Numero de insercciones completadas. 
     * \throws SQLException
     */
    public int insertar(Cliente client) throws BBDDException;
    
    /**
     * Hace un select a la BD con la id pasada.
     * \param id Id del producto que quieres.
     * \return Producto con la id pasada por.
     * \throws SQLException, MercaDAWException
     */
    public Producto visualizarProducto(int id) throws BBDDException;

    /**
     * Devuelve la lista de Productos de la BD completa.
     * \return List<Producto> Los productos de la BD.
     * \throws SQLException, MercaDAWException
     */
    public List<Producto> visualizarProductos() throws BBDDException;

    /**
     * Visualiza el Cliente con la id del parametro.
     * \param id Id del Cliente que quieres.
     * \return Cliente El cliente con la id del parametro.
     * \throws SQLException
     */
    public Cliente visualizarCliente(int id) throws BBDDException;

    /**
     * Devuelve la lista de Clientes de la BD completa.
     * \return List<Cliente> Los clientes de la BD.
     * \throws SQLException
     */
    public List<Cliente> visualizarClientes() throws BBDDException;

    /**
     * Devuelve la lista de Empleados de la BD completa.
     * \return List<Empleado> Los empleados de la BD.
     * \throws SQLException, MercaDAWException
     */
    public List<Empleado> visualizarEmpleados() throws BBDDException;

    /**
     * Devuelve la lista de Compras de la BD completa.
     * \return List<Compra> Las compas de la BD.
     * \throws SQLException, MercaDAWException
     */
    public List<Compra> visualizarCompras() throws BBDDException;
}