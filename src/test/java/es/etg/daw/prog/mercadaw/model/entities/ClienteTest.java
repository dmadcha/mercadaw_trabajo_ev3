package es.etg.daw.prog.mercadaw.model.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.etg.daw.prog.mercadaw.model.entities.compras.Cliente;
import es.etg.daw.prog.mercadaw.model.exception.MercaDAWException;

public class ClienteTest {
    Cliente cliente1;
    Cliente cliente2;

    @BeforeEach
    public void creacionClientes() throws MercaDAWException, SQLException {
        cliente1 = new Cliente(null, "Juan Pérez", "juan@example.com", 28001);
        cliente2 = new Cliente(null, "María García", "maria@example.com", 28982);
    }

    @Test 
    public void crearClienteTest() throws MercaDAWException {
        assertEquals(1, cliente1.getId());
        assertEquals(2, cliente2.getId());
    }
}
