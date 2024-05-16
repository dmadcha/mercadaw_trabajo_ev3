package es.etg.daw.prog.mercadaw.model.bbdd;

import java.util.List;
import java.util.Map;

import es.etg.daw.prog.mercadaw.model.entities.Cliente;
import es.etg.daw.prog.mercadaw.model.entities.Compra;
import es.etg.daw.prog.mercadaw.model.entities.Empleado;
import es.etg.daw.prog.mercadaw.model.entities.Producto;

/**
 * La interfaz MercaDAO expone los metodos de acceso a la base de datos.
 * \author Jesús Pérez Enríquez.
 */
public interface MercaDAO {


    public void crearTablas();
    
    /**
     * Inserta el empleado en la Base de datos.
     * \param empleado Empleado a insertar.
     */
    public void insertar(Empleado emp);


    /**
     * Inserta el producto en la Base de datos.
     * \param producto Producto a insertar.
     */
    public void insertar(Producto prod);

    /**
     * Inserta la compra en la Base de datos.
     * \param compra Compra a insertar.
     */
    public void insertar(Compra compra);

    /**
     * Inserta el cliente en la Base de datos.
     * \param client Cliente a insertar.
     */
    public void insertar(Cliente client);
    
    /**
     * Devuelve los datos de un producto.
     * \param 
     * \return 
     */
    public Producto visualizarProducto();

    /**
     * Devuelve la lista de Productos de la BD completa.
     * \return Una lista de Productos.
     */
    public List<Producto> visualizarProductos();

    /**
     * Devuelve la lista de Clientes de la BD completa.
     * \return Una lista de Clientes.
     */
    public List<Cliente> visualizarClientes();

    /**
     * Devuelve la lista de Clientes de la BD completa.
     * \return Una lista de Clientes.
     */
    public List<Empleado> visualizarEmpleados();
    public List<Compra> visualizarCompras();
    public Map<Producto, Integer > visualizarStock();
}