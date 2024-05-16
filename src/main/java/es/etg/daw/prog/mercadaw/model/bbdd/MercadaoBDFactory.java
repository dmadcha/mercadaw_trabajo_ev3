package es.etg.daw.prog.mercadaw.model.bbdd;

public class MercadaoBDFactory {
    public static MercaDAO obtener(Database tipo){
        
        if (tipo == Database.ORACLE_XE) {
            return new MercaDAOImpOracleXE();
        }
        
        return new MercaDAOImpMock();
    }
}
