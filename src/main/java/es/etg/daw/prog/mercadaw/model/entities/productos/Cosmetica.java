package es.etg.daw.prog.mercadaw.model.entities.productos;

public class Cosmetica extends Producto{
    public Cosmetica(String nombre, String marca, double altura, double anchura, double peso,
            int numElementos, String descripcion) {
        super(nombre, marca, altura, anchura, peso, numElementos, descripcion);
        this.iva = IVA_COSM;
    }

    @Override
    public String toString() {
        return TipoProducto.COSMETICA.toString();
    }
}
