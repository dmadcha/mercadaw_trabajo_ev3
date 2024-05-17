package es.etg.daw.prog.mercadaw.model.entities.productos;

import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;

public class ProductoFactory {
    public static Producto obtener(TipoProducto tipo, String nombre, String marca, double precio, double altura, double anchura, int peso, int numElementos, String descripcion) throws MercaDAWException{
        if (tipo.equals(TipoProducto.ALIMENTACION)) {
            return new Alimentacion(nombre, marca, precio, altura, anchura, peso, numElementos, descripcion);
        } else if (tipo.equals(TipoProducto.COSMETICA)) {
            return new Cosmetica(nombre, marca, precio, altura, anchura, peso, numElementos, descripcion);
        } else if (tipo.equals(TipoProducto.DROGUERIA)) {
            return new Drogueria(nombre, marca, precio, altura, anchura, peso, numElementos, descripcion);
        } else 
        throw new MercaDAWException();
    }
}
