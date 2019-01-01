package Interfaces;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;


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
            Scene nova = new Scene(view,720,464);
            window.setScene(nova);
            ConfigManager cm = loader.getController();
            cm.init(this);
            cm.setMainController(mc);
            cm.populateTable();
            mc.setConfigManager(cm);
            window.setTitle("Gestor de Configurações");
            window.show();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void showConfigEditor() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Interfaces/configdisplay.fxml"));
            Pane view = loader.load();
            Scene nova = new Scene(view,891,455);
            window.setScene(nova);
            ConfigDisplay cm = loader.getController();
            cm.init(this);
            cm.setMainController(mc);
            cm.loadTable();
            mc.setConfigDisplay(cm);
            window.setTitle("Editor de Configuração");
            window.show();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void showItemsFrame() {
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

    public void showWheelFrame() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Interfaces/jantedisplay.fxml"));
            Pane view = loader.load();
            Scene nova = new Scene(view,807,452);
            window.setScene(nova);
            JanteDisplay jd = loader.getController();
            jd.init(this);
            jd.setMainController(mc);
            mc.setJanteDisplay(jd);
            window.setTitle("Menu de Jantes");
            window.show();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void showPaintFrame() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Interfaces/pinturadisplay.fxml"));
            Pane view = loader.load();
            Scene nova = new Scene(view,807,452);
            window.setScene(nova);
            PinturaDisplay pd = loader.getController();
            pd.init(this);
            pd.setMainController(mc);
            mc.setPinturaDisplay(pd);
            window.setTitle("Menu de Pinturas");
            window.show();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void showEngineFrame() {
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

    public void showTireDisplay() {
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

    public void showInnerDisplay() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Interfaces/detalheinteriordisplay.fxml"));
            Pane view = loader.load();
            Scene nova = new Scene(view,1001,486);
            window.setScene(nova);
            DetalheInteriorDisplay indisp = loader.getController();
            indisp.init(this);
            indisp.setMainController(mc);
            mc.setInnerDisplay(indisp);
            window.setTitle("Menu de Detalhes Interiores");
            window.show();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void showOutterDisplay() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Interfaces/detalheexteriordisplay.fxml"));
            Pane view = loader.load();
            Scene nova = new Scene(view,487,560);
            window.setScene(nova);
            DetalheExteriorDisplay outdisp = loader.getController();
            outdisp.init(this);
            outdisp.setMainController(mc);
            mc.setOutterDisplay(outdisp);
            window.setTitle("Menu de Detalhes Exteriores");
            window.show();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void showPacoteDisplay(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Interfaces/pacoteDisplay.fxml"));
            Pane view = loader.load();
            Scene nova = new Scene(view,485,221);
            window.setScene(nova);
            PacoteDisplay pacoteDisp = loader.getController();
            pacoteDisp.init(this);
            pacoteDisp.setMainController(mc);
            mc.setPacoteDisplay(pacoteDisp);
            window.setTitle("Menu de Pacotes");
            window.show();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void showPacoteSportTableDisplay(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Interfaces/pacoteSportTabledisplay.fxml"));
            Pane view = loader.load();
            Scene nova = new Scene(view,982,428);
            window.setScene(nova);
            PacoteSportTableDisplay pacotetDisp = loader.getController();
            pacotetDisp.init(this);
            pacotetDisp.setMainController(mc);
            pacotetDisp.loadItems();
            pacotetDisp.loadDetalhesExteriores();
            pacotetDisp.loadDetalhesInteriores();
            mc.setPacoteTableDisplay(pacotetDisp);
            window.setTitle("Menu de Pacotes Expandido");
            window.show();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void showPacoteConfortTableDisplay(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Interfaces/pacoteConfortTableDisplay.fxml"));
            Pane view = loader.load();
            Scene nova = new Scene(view,982,428);
            window.setScene(nova);
            PacoteConfortTableDisplay pacotetDisp = loader.getController();
            pacotetDisp.init(this);
            pacotetDisp.setMainController(mc);
            pacotetDisp.loadItems();
            pacotetDisp.loadDetalhesExteriores();
            pacotetDisp.loadDetalhesInteriores();
            mc.setPacoteConfortTableDisplay(pacotetDisp);
            window.setTitle("Menu de Pacotes Expandido");
            window.show();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }




    public static void main(String[] args) {
        launch(args);
    }
}

