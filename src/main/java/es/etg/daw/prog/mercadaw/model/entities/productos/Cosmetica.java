package es.etg.daw.prog.mercadaw.model.entities.productos;

import java.sql.SQLException;

import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;

/**
 * La clase Cosmetica representa un producto de cosmética de MercaDAW.
 * \author Diego Madroñero Chamorro.
 */
public class Cosmetica extends Producto{

    /**
     * Constructor que inicializa productos de cosmética, generando el ID de estos automaticamente.
     * \param ID del producto
     * \param Nombre del producto
     * \param Marca del producto
     * \param Altura del producto
     * \param Anchura del producto
     * \param Peso del producto
     * \param Numero de elementos del producto
     * \param Stock del producto
     * \param Precio del producto
     * \param Descripcion del producto
     * @throws MercaDAWException 
     * @throws SQLException 
     */
    public Cosmetica(Integer id, String nombre, String marca, double altura, double anchura, double peso,
            int numElementos, int stock, double precio, String descripcion) throws SQLException, MercaDAWException {
        super(id, nombre, marca, altura, anchura, peso, numElementos, stock, precio, descripcion);
        this.iva = IVA_COSM;
    }

    @Override
    public String toString() {
        return TipoProducto.COSMETICA.toString();
    }
}
