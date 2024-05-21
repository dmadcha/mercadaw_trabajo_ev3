package es.etg.daw.prog.mercadaw.model.bbdd;

import es.etg.daw.prog.mercadaw.model.exception.BBDDException;

/**
 * La clase MercaDAOFactory crea las posibles BD disponibles.
 * \author Jesús Pérez Enríquez.
 */
public class MercaDAOFactory {
    public static MercaDAO obtener(Database tipo) throws BBDDException{
        
        if (tipo == Database.ORACLE) {
            try {
                return new MercaDAOImpOracleXE();
            } catch (Exception e) {
                throw new BBDDException();
            }
            
        }
        
        return new MercaDAOImpMock();
    }
}
