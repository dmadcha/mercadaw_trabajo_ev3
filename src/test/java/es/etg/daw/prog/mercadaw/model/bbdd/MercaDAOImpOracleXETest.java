package es.etg.daw.prog.mercadaw.model.bbdd;


import org.junit.jupiter.api.Test;

public class MercaDAOImpOracleXETest {
    @Test
    public void iniciarBBDDTest() throws Exception{
        MercaDAOImpOracleXE bbdd = new MercaDAOImpOracleXE();
        bbdd.iniciarBBDD();
    }
}
