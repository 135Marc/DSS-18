package Interfaces;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private Utilizadores usersmap;
    @FXML
    private Registo regist;
    @FXML
    private LogIn logz;
    @FXML
    private MainView mview;

    public MainController(MainView mv) {
        this.usersmap = new Utilizadores();
        mview = mv;
    }

    public void initialize(URL location, ResourceBundle resources)  {

    }

    public void setRegist(Registo r) {
        this.regist=r;
    }

    public void setLogIn (LogIn li) {
        this.logz = li;
    }

    public boolean hasUser(String id) {
        Map<String,Utilizador> umap = usersmap.getUserMap();
        return (umap.containsKey(id));
    }

    public boolean passwordMatches(String id,String password) {
        Utilizador u = usersmap.getUserMap().get(id);
        return (u.getPassword().equals(password));
    }

    public void addUser(String id, String password) {
        Utilizador u = new Utilizador(id,password);
        this.usersmap.addToMap(id,u);
    }

    public void displayRegistry() {
        mview.showRegistForm();
    }

    public void displayLogin() {
        mview.showLogin();
    }

}