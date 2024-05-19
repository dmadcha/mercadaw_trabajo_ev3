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

public class LectorCSV extends LectorImp {

    @Override
    public List<Producto> leerProducto(String codigo) throws MercaDAWException {
        boolean primeraFila = true;
        List<Producto> productos = new ArrayList<>();

        // Comprobamos que la cadena tiene contenido, si no devuelve una excepción.
        comprobar(codigo);

        StringTokenizer st = new StringTokenizer(codigo, "\n");
        while (st.hasMoreTokens()) {
            String fila = st.nextToken();

            if (!primeraFila && !"".equals(fila))
                productos.add(procesarProducto(fila));

            primeraFila = false;
        }

        return productos;
    }

    @Override
    public List<Empleado> leerEmpleado(String codigo) throws MercaDAWException {
        boolean primeraFila = true;
        List<Empleado> empleados = new ArrayList<>();

        // Comprobamos que la cadena tiene contenido, si no devuelve una excepción.
        comprobar(codigo);

        StringTokenizer st = new StringTokenizer(codigo, "\n");
        while (st.hasMoreTokens()) {
            String fila = st.nextToken();

            if (!primeraFila && !"".equals(fila))
                empleados.add(procesarEmpleado(fila));

            primeraFila = false;
        }

        return empleados;
    }

    @Override
    public List<Cliente> leerCliente(String codigo) throws MercaDAWException {
        boolean primeraFila = true;
        List<Cliente> clientes = new ArrayList<>();

        // Comprobamos que la cadena tiene contenido, si no devuelve una excepción.
        comprobar(codigo);

        StringTokenizer st = new StringTokenizer(codigo, "\n");
        while (st.hasMoreTokens()) {
            String fila = st.nextToken();

            if (!primeraFila && !"".equals(fila))
                clientes.add(procesarCliente(fila));

            primeraFila = false;
        }

        return clientes;
    }

    @Override
    public List<Compra> leerCompra(String codigo) throws MercaDAWException {
        boolean primeraFila = true;
        List<Compra> compras = new ArrayList<>();

        // Comprobamos que la cadena tiene contenido, si no devuelve una excepción.
        comprobar(codigo);

        StringTokenizer st = new StringTokenizer(codigo, "\n");
        while (st.hasMoreTokens()) {
            String fila = st.nextToken();

            if (!primeraFila && !"".equals(fila))
                //compras.add(procesarCompra(fila));

            primeraFila = false;
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

        tipo = st.nextToken();
        id = Integer.parseInt(st.nextToken());
        nombre = st.nextToken();
        marca = st.nextToken();
        altura = Double.parseDouble(st.nextToken());
        anchura = Double.parseDouble(st.nextToken());
        peso = Double.parseDouble(st.nextToken());
        numElementos = Integer.parseInt(st.nextToken());
        descripcion = st.nextToken();
        stock = Integer.parseInt(st.nextToken());
        precio = Double.parseDouble(st.nextToken());

        return ProductoFactory.obtener(tipo, id, nombre, marca, altura, anchura, peso, numElementos, stock, precio,
                descripcion);

    }

    private Empleado procesarEmpleado(String fila) throws MercaDAWException {
        String tipo;
        Integer id;
        String nombre;
        String apellidos;
        Date fechaInicio;

        StringTokenizer st = new StringTokenizer(fila, ",");

        tipo = st.nextToken();
        id = Integer.parseInt(st.nextToken());
        nombre = st.nextToken();
        apellidos = st.nextToken();
        fechaInicio = Date.valueOf(st.nextToken());

        return EmpleadoFactory.obtener(tipo, id, nombre, apellidos, fechaInicio);

    }

    private Cliente procesarCliente(String fila) throws MercaDAWException {

        int id;
        String nombre;
        String correo;
        int codPostal;

        StringTokenizer st = new StringTokenizer(fila, ",");

        id = Integer.parseInt(st.nextToken());
        nombre = st.nextToken();
        correo = st.nextToken();
        codPostal = Integer.parseInt(st.nextToken());

        return new Cliente(id, nombre, correo, codPostal);

    }

   /*  private Compra procesarCompra(String fila) throws MercaDAWException {
        int id;
        Date fecha;
        Cliente cliente;
        List<Producto> productos;

        StringTokenizer st = new StringTokenizer(fila, ",");

        id = Integer.parseInt(st.nextToken());
        fecha = Date.valueOf(st.nextToken());
      



        return new Compra(id, fecha, cliente, productos);
    }
*/
}
