package es.etg.daw.prog.mercadaw.model.bbdd;

import java.sql.SQLException;

public class MercadaoBDFactory {
    public static MercaDAO obtener(Database tipo)throws SQLException{
        
        if (tipo == Database.ORACLE_XE) {
            return new MercaDAOImpOracleXE();
        }
        
        return new MercaDAOImpMock();
    }
}
