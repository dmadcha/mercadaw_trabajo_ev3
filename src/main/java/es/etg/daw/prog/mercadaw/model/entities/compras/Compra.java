package es.etg.daw.prog.mercadaw.model.entities.compras;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import es.etg.daw.prog.mercadaw.model.bbdd.Database;
import es.etg.daw.prog.mercadaw.model.bbdd.MercaDAO;
import es.etg.daw.prog.mercadaw.model.bbdd.MercaDAOFactory;
import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;

/**
 * La clase Compra representa las compras realizadas por los clientes de MercaDAW.
 * \author Diego Madroñero Chamorro.
 */
public class Compra {

    public static final String ATT_ID_COMP = "id";
    public static final String ATT_FECH_COMP = "fecha";

    public static int numCompras;

    private MercaDAO db;
    private Integer id;
    private Date fecha;
    private Cliente cliente;
    private List<Producto> productos;

    /**
     * Constructor que inicializa compras, generando el ID de estas automaticamente.
     * \param id
     * \param fecha
     * \param cliente
     * \param productos
     * @throws MercaDAWException 
     */
    public Compra(Integer id, Date fecha, Cliente cliente, List<Producto> productos) throws MercaDAWException {
        
        if (id == null) {
            db = MercaDAOFactory.obtener(Database.ORACLE);
            numCompras = db.visualizarCompras().size();
            numCompras+= productos.size();
            this.id = numCompras;
        } else {
            this.id = id;
        }
        this.fecha = fecha;
        this.cliente = cliente;
        this.productos = productos;

        
    }

    public static int getNumCompras() {
        return numCompras;
    }

    public static void setNumCompras(int numCompras) {
        Compra.numCompras = numCompras;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
