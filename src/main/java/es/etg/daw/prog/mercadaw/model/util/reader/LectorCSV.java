package es.etg.daw.prog.mercadaw.model.util.reader;

import java.util.StringTokenizer;

import es.etg.daw.prog.mercadaw.model.entities.empleados.Empleado;
import es.etg.daw.prog.mercadaw.model.entities.empleados.TipoEmpleado;
import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;
import es.etg.daw.prog.mercadaw.model.entities.productos.TipoProducto;

public class LectorCSV {

    private Producto procesarProducto(String fila) {
        TipoProducto tipo;
        String nombre;
        String marca;
        double precio;
        double altura;
        double anchura;
        double peso;
        int numElementos;
        String descripcion;

        StringTokenizer st = new StringTokenizer(fila, ",");


        nombre = st.nextToken();
        marca = st.nextToken();
        precio = Double.parseDouble(st.nextToken());
        altura = Double.parseDouble(st.nextToken());
        anchura = Double.parseDouble(st.nextToken());
        peso = Double.parseDouble(st.nextToken());
        numElementos = Integer.parseInt(st.nextToken());
        descripcion = st.nextToken();

        
       
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
