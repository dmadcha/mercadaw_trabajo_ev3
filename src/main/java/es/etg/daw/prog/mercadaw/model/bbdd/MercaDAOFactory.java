package es.etg.daw.prog.mercadaw.model.bbdd;

import java.sql.SQLException;

public class MercaDAOFactory {
    public static MercaDAO obtener(Database tipo)throws SQLException{
        
        if (tipo == Database.ORACLE) {
            return new MercaDAOImpOracleXE();
        }
        
        return new MercaDAOImpMock();
    }
}
