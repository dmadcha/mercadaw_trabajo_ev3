package es.etg.daw.prog.mercadaw.model.util.reader;

import java.util.StringTokenizer;

import es.etg.daw.prog.mercadaw.model.entities.empleados.Empleado;
import es.etg.daw.prog.mercadaw.model.entities.empleados.TipoEmpleado;
import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;
import es.etg.daw.prog.mercadaw.model.exception.LectorException;

public class LectorCSV {

   private Producto procesar(String fila) throws LectorException {
    StringTokenizer st = new StringTokenizer(fila, ",");
    String nombre = st.nextToken();
    double precio = Double.parseDouble(st.nextToken());
    int stock = Integer.parseInt(st.nextToken());

    switch (tipoProducto) {
        case DROGUERIA:
            return new ProductoDrogueria(nombre, precio, stock);
        case PERFUMERIA:
            return new ProductoPerfumeria(nombre, precio, stock);
        case COSMETICA:
            return new ProductoCosmetica(nombre, precio, stock);
        default:
            throw new LectorException("Tipo de producto no válido");
    }
}

    private Empleado procesarEmpleado(String fila) {
        TipoEmpleado tipo;
        int id;
        String nombre;
        String apellidos;

        StringTokenizer st = new StringTokenizer(fila, ",");

        id = Integer.parseInt(st.nextToken());
        nombre = st.nextToken();
        apellidos = st.nextToken();

        return new Empleado(id, nombre, apellidos);

    }
}
