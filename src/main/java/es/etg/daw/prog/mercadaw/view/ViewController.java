package es.etg.daw.prog.mercadaw.view;

import es.etg.daw.prog.mercadaw.controller.MercaDAWController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

/**
 * Esta clase es la que nos permite la comunicación entre las vistas y el controlador de
 * la aplicación.
 * \author Erik Herrera Llamas.
 * \version 1.0
 */
public abstract class ViewController {

    protected MercaDAWController controller = new MercaDAWController();


    public static final String MSG_ERROR = "ERROR";
    protected MercaDAWController mercaDAWController;
    
    public void setMercaDAWController(MercaDAWController mercaDAWController) {
        this.mercaDAWController = mercaDAWController;
    }

    public void mostrarAviso(String msg, AlertType tipo){
        
        Alert alerta = new Alert(tipo);
        alerta.setHeaderText(null);
        alerta.setTitle(MSG_ERROR);
        alerta.setContentText(msg);
        alerta.showAndWait();
    }

    @FXML
    void salir(MouseEvent event) {
        controller.cargarApp();
    }
}
