package es.etg.daw.prog.mercadaw;

import es.etg.daw.prog.mercadaw.controller.MercaDAWController;
import javafx.application.Application;

public class App {
    public static void main(String[] args) {
        MercaDAWController controller = new MercaDAWController();

        Application.launch(MercaDAWController.class, args);
    }
}