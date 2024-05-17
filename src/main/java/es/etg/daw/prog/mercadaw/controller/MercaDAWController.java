package es.etg.daw.prog.mercadaw.controller;

import java.io.IOException;

import es.etg.daw.prog.mercadaw.App;
import es.etg.daw.prog.mercadaw.view.MainViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MercaDAWController extends Application {
    public final static String MAIN_VIEW = "view/MainView.fxml";
    public static Stage currentStage;

    @Override
    public void start(Stage stage) throws Exception {
        currentStage = stage;
        cargarVista(MAIN_VIEW);
    }

    private Scene cargarVista(String ficheroView) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(ficheroView));
        Parent root = (Parent)fxmlLoader.load();  

        //Obtengo el controlador de la vista para pasarle una referencia al controlador - MVC:
        MainViewController viewController = fxmlLoader.<MainViewController>getController();
        viewController.(this);
        Scene scene = new Scene(root); 
        
        return scene;
    }
}
