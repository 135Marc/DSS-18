package Interfaces;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Registo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Interfaces/registo.fxml"));
        Pane view = loader.load();
        Scene nova = new Scene(view,600,550);
        primaryStage.setScene(nova);
        primaryStage.setTitle("Registar Cliente");
        primaryStage.show();
    }
}
