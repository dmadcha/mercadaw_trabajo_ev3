package es.etg.daw.prog.mercadaw.model.entities.compras;

import java.sql.SQLException;

import es.etg.daw.prog.mercadaw.model.bbdd.Database;
import es.etg.daw.prog.mercadaw.model.bbdd.MercaDAO;
import es.etg.daw.prog.mercadaw.model.bbdd.MercaDAOFactory;

/**
 * La clase Cliente representa un cliente de MercaDAW.
 * \author Diego Madroñero Chamorro.
 */
public class Cliente {
    
    private static int numClientes;
    private MercaDAO db;

    private Integer id;
    private String nombre;
    private String correo;
    private int codPostal;

    /**
     * Constructor que inicializa clientes, generando el ID de estos automaticamente.
     * \param id
     * \param nombre
     * \param correo
     * \param codPostal
     * @throws SQLException 
     */
    public Cliente(Integer id, String nombre, String correo, int codPostal) throws SQLException {
        
        if (id == null) {
            db = MercaDAOFactory.obtener(Database.ORACLE);
            numClientes = db.visualizarClientes().size();
            numClientes++;
            this.id = numClientes;
        } else {
            this.id = id;
        }
        this.nombre = nombre;
        this.correo = correo;
        this.codPostal = codPostal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static int getNumClientes() {
        return numClientes;
    }

    public static void setNumClientes(int numClientes) {
        Cliente.numClientes = numClientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
    }

}
