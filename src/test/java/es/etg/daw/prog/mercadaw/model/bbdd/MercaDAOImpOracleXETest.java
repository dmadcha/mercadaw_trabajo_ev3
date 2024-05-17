package es.etg.daw.prog.mercadaw.model.bbdd;


import org.junit.jupiter.api.Test;

import es.etg.daw.prog.mercadaw.model.entities.empleados.Empleado;

public class MercaDAOImpOracleXETest {
    @Test
    public void iniciarBBDDTest() throws Exception{
        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();
        bbdd.iniciarBBDD();
    }

    @Test
    public void insertarEmpleadoTest() throws Exception{
        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();

        Empleado emp = new Empleado(0, "Paco", "Fiestas");
        bbdd.insertar(emp);
    }
}
