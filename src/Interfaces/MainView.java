package Interfaces;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
            window.setTitle("Autenticar Cliente");
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
            window.setTitle("Registar Cliente");
            window.show();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void showConfigManager() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Interfaces/configmanager.fxml"));
            Pane view = loader.load();
            Scene nova = new Scene(view,550,450);
            window.setScene(nova);
            ConfigManager cm = loader.getController();
            cm.init(this);
            cm.setMainController(mc);
            mc.setConfigManager(cm);
            window.setTitle("Gestor de Configurações");
            window.show();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void showConfigEditor(Configuracao cfg) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Interfaces/config.fxml"));
            Pane view = loader.load();
            Scene nova = new Scene(view,891,455);
            window.setScene(nova);
            Configuracao cm = new Configuracao(cfg);
            cm.init(this);
            cm.setMainController(mc);
            mc.setConfigEditor(cm);
            window.setTitle("Editor de Configuração");
            window.show();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void showItemsFrame() { // NULL POINTER EXCEPTION -> É necessário passar-lhe uma configuração para abrir isto e os outros
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Interfaces/itemdisplay.fxml"));
            Pane view = loader.load();
            Scene nova = new Scene(view,807,452);
            window.setScene(nova);
            ItemDisplay id = loader.getController();
            id.init(this);
            id.setMainController(mc);
            mc.setItemDisplay(id);
            window.setTitle("Menu de Items");
            window.show();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void showEngineFrame() { // NULL POINTER
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Interfaces/enginedisplay.fxml"));
            Pane view = loader.load();
            Scene nova = new Scene(view,600,400);
            window.setScene(nova);
            EngineDisplay ed = loader.getController();
            ed.init(this);
            ed.setMainController(mc);
            mc.setEngineDisplay(ed);
            window.setTitle("Menu de Motores");
            window.show();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void showTireDisplay() { // NULL POINTER
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Interfaces/tiredisplay.fxml"));
            Pane view = loader.load();
            Scene nova = new Scene(view,600,400);
            window.setScene(nova);
            TireDisplay tid = loader.getController();
            tid.init(this);
            tid.setMainController(mc);
            mc.setTireDisplay(tid);
            window.setTitle("Menu de Pneus");
            window.show();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

