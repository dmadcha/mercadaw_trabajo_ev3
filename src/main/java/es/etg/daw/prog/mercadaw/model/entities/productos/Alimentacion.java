package es.etg.daw.prog.mercadaw.model.entities.productos;

public class Alimentacion extends Producto{

    public Alimentacion(String nombre, String marca, double altura, double anchura, double peso,
            int numElementos, String descripcion) {
        super(nombre, marca, altura, anchura, peso, numElementos, descripcion);
        this.iva = IVA_ALIM;
    }

    @Override
    public String toString() {
        return TipoProducto.ALIMENTACION.toString();
    }
}
