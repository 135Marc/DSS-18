package Interfaces;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainView extends Application {

    @FXML
    private Stage window;
    @FXML
    private MainController mc;

    public MainView() {
        window = new Stage();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.window=primaryStage;
        mc = new MainController(this);
        window.setTitle("Gestor de Sócios");
        showLogin();
    }

    public void showLogin() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Interfaces/login.fxml"));
            Pane view = loader.load();
            Scene nova = new Scene(view,500,200);
            window.setScene(nova);
            LogIn li = loader.getController();
            li.init(this);
            li.setMainController(mc);
            mc.setLogIn(li);
            window.show();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void showRegistForm() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Interfaces/registo.fxml"));
            Pane view = loader.load();
            Scene nova = new Scene(view,550,550);
            window.setScene(nova);
            Registo reg = loader.getController();
            reg.init(this);
            reg.setMainController(mc);
            mc.setRegist(reg);
            window.show();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

