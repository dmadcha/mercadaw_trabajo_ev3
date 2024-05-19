package es.etg.daw.prog.mercadaw.view;

import es.etg.daw.prog.mercadaw.controller.MercaDAWController;

/**
 * Esta clase es la que nos permite la comunicación entre las vistas y el controlador de
 * la aplicación.
 * @author: Erik Herrera Llamas.
 * @version: 1.0
 */
public abstract class ViewController {
    protected MercaDAWController mercaDAWController;
    
    public void setMercaDAWController(MercaDAWController mercaDAWController) {
        this.mercaDAWController = mercaDAWController;
    }
}
