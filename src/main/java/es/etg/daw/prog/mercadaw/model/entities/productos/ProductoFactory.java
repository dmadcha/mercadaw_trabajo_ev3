package es.etg.daw.prog.mercadaw.model.entities.productos;

import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;

public class ProductoFactory {
    public static Producto obtener(String tipoString, String nombre, String marca, double altura, double anchura, double peso, int numElementos, String descripcion) throws MercaDAWException{
        
        TipoProducto tipoProducto;
        try {
            tipoProducto = TipoProducto.valueOf(tipoString.toUpperCase());
        } catch (Exception e) {
            throw new MercaDAWException();
        }
        if (tipoProducto.equals(TipoProducto.ALIMENTACION)) {
            return new Alimentacion(nombre, marca, altura, anchura, peso, numElementos, descripcion);
        } else if (tipoProducto.equals(TipoProducto.COSMETICA)) {
            return new Cosmetica(nombre, marca, altura, anchura, peso, numElementos, descripcion);
        } else if (tipoProducto.equals(TipoProducto.DROGUERIA)) {
            return new Drogueria(nombre, marca, altura, anchura, peso, numElementos, descripcion);
        } else 
        throw new MercaDAWException();
    }
}
