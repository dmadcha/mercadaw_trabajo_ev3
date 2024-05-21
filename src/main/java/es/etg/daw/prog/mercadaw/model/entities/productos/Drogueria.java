package es.etg.daw.prog.mercadaw.model.entities.productos;

import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;

/**
 * La clase Drogueria representa un producto de droguería de MercaDAW.
 * \author Diego Madroñero Chamorro.
 */
public class Drogueria extends Producto{

    /**
     * Constructor que inicializa productos de droguería, generando el ID de estos automaticamente.
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
     * \throws MercaDAWException 
     */
    public Drogueria(Integer id, String nombre, String marca, double altura, double anchura, double peso,
            int numElementos, int stock, double precio, String descripcion) throws MercaDAWException {
        super(id, nombre, marca, altura, anchura, peso, numElementos, stock, precio, descripcion);
        this.iva = IVA_DROG;
    }

    @Override
    public String toString() {
        return TipoProducto.DROGUERIA.toString();
    }
}
