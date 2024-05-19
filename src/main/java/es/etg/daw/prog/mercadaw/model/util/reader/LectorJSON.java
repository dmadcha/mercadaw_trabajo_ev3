package es.etg.daw.prog.mercadaw.model.util.reader;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import es.etg.daw.prog.mercadaw.model.entities.compras.Cliente;
import es.etg.daw.prog.mercadaw.model.entities.compras.Compra;
import es.etg.daw.prog.mercadaw.model.entities.empleados.Empleado;
import es.etg.daw.prog.mercadaw.model.entities.empleados.EmpleadoFactory;
import es.etg.daw.prog.mercadaw.model.entities.productos.Producto;
import es.etg.daw.prog.mercadaw.model.entities.productos.ProductoFactory;
import es.etg.daw.prog.mercadaw.model.exception.LectorException;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;

public class LectorJSON extends LectorImp {

    @Override
    public List<Producto> leerProducto(String codigo) throws MercaDAWException {

        List<Producto> productos = new ArrayList<>();

        comprobar(codigo);

        StringTokenizer st = new StringTokenizer(codigo, "{}", true);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            if (token.equals("{")) {

                token = st.nextToken();
                productos.add(procesarProducto(token));
            }
        }

        return productos;
    }

    @Override
    public List<Empleado> leerEmpleado(String codigo) throws MercaDAWException {

        List<Empleado> empleados = new ArrayList<>();

        comprobar(codigo);

        StringTokenizer st = new StringTokenizer(codigo, "{}", true);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            if (token.equals("{")) {

                token = st.nextToken();
                empleados.add(procesarEmpleado(token));
            }
        }

        return empleados;
    }

    @Override
    public List<Cliente> leerCliente(String codigo) throws MercaDAWException {

        List<Cliente> clientes = new ArrayList<>();

        comprobar(codigo);

        StringTokenizer st = new StringTokenizer(codigo, "{}", true);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            if (token.equals("{")) {

                token = st.nextToken();
                clientes.add(procesarCliente(token));
            }
        }

        return clientes;
    }

    @Override
    public List<Compra> leerCompra(String codigo) throws MercaDAWException {

        List<Compra> compras = new ArrayList<>();

        comprobar(codigo);

        StringTokenizer st = new StringTokenizer(codigo, "{}", true);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            if (token.equals("{")) {

                token = st.nextToken();
            //    compras.add(procesarCompra(token));
            }
        }

        return compras;
    }

    private void comprobar(String cadena) throws MercaDAWException {

        if (cadena == null || cadena.trim().length() == 0)
            throw new LectorException();

    }

    private Producto procesarProducto(String fila) throws MercaDAWException {

        String tipo;
        int id;
        String nombre;
        String marca;
        double altura;
        double anchura;
        double peso;
        int numElementos;
        String descripcion;
        int stock;
        double precio;

        StringTokenizer st = new StringTokenizer(fila, ",");

        tipo = procesarString(st.nextToken());
        id = procesarInt(st.nextToken());
        nombre = procesarString(st.nextToken());
        marca = procesarString(st.nextToken());
        altura = procesarDouble(st.nextToken());
        anchura = procesarDouble(st.nextToken());
        peso = procesarDouble(st.nextToken());
        numElementos = procesarInt(st.nextToken());
        descripcion = procesarString(st.nextToken());
        stock = procesarInt(st.nextToken());
        precio = procesarDouble(st.nextToken());

        return ProductoFactory.obtener(tipo, id, nombre, marca, altura, anchura, peso, numElementos, stock, precio,
                descripcion);

    }

    private Empleado procesarEmpleado(String fila) throws MercaDAWException {
        String tipo;
        int id;
        String nombre;
        String apellidos;
        Date fechaInicio;

        StringTokenizer st = new StringTokenizer(fila, ",");

        tipo = procesarString(st.nextToken());
        id = procesarInt(st.nextToken());
        nombre = procesarString(st.nextToken());
        apellidos = procesarString(st.nextToken());
        fechaInicio = Date.valueOf(procesarString(st.nextToken()));
        return EmpleadoFactory.obtener(tipo, id, nombre, apellidos, fechaInicio);

    }

    private Cliente procesarCliente(String fila) throws MercaDAWException {

        int id;
        String nombre;
        String correo;
        int codPostal;

        StringTokenizer st = new StringTokenizer(fila, ",");

        id = procesarInt(st.nextToken());
        nombre = procesarString(st.nextToken());
        correo = procesarString(st.nextToken());
        codPostal = procesarInt(st.nextToken());

        return new Cliente(id, nombre, correo, codPostal);

    }


    private String procesarString(String pareja) {
        String valor = null;

        pareja = pareja.trim();

        StringTokenizer st = new StringTokenizer(pareja, ":");

        st.nextToken();

        valor = st.nextToken().trim();
        valor = valor.substring(1, valor.length() - 1);

        return valor;
    }

    private int procesarInt(String pareja) {
        int valorNumerico = 0;

        pareja = pareja.trim();

        StringTokenizer st = new StringTokenizer(pareja, ":");

        st.nextToken();

        String valor = st.nextToken().trim();
        valor = valor.substring(1, valor.length() - 1);

        valorNumerico = Integer.parseInt(valor);

        return valorNumerico;
    }

    private double procesarDouble(String pareja) {
        double valorNumerico = 0.0;

        pareja = pareja.trim();
        StringTokenizer st = new StringTokenizer(pareja, ":");

        st.nextToken();

        String valor = st.nextToken().trim();
        valor = valor.substring(1, valor.length() - 1);

        valorNumerico = Double.parseDouble(valor);

        return valorNumerico;
    }

}
