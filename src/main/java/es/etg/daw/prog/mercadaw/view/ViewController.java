package es.etg.daw.prog.mercadaw.view;

import es.etg.daw.prog.mercadaw.controller.MercaDAWController;

public abstract class ViewController {
    protected MercaDAWController mercaDAWController;
    
    public void setMercaDAWController(MercaDAWController mercaDAWController) {
        this.mercaDAWController = mercaDAWController;
    }
}
