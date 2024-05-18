package es.etg.daw.prog.mercadaw.model.entities.productos;

public class Drogueria extends Producto{

    

    public Drogueria(Integer id, String nombre, String marca, double altura, double anchura, double peso,
            int numElementos, int stock, String descripcion) {
        super(id, nombre, marca, altura, anchura, peso, numElementos, stock, descripcion);
        this.iva = IVA_DROG;
    }

    @Override
    public String toString() {
        return TipoProducto.DROGUERIA.toString();
    }
}
