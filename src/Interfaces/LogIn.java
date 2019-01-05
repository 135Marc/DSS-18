package Interfaces;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class LogIn implements Initializable {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    private  MainController mc;

    private MainView main;

    public void setMainController(MainController mc) {
        this.mc = mc;
    }

    public void init(MainView mv) {
        this.main = mv;
    }

    public void showLoginError(String errormsg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Login Inválido:");
        alert.setContentText(errormsg);
        alert.showAndWait();
    }

    public void longInUser()  {
        String user = username.getText();
        String pw = password.getText();
        if (!this.mc.hasUser(user)) showLoginError("Utilizador inexistente,tente novamente!");
        else {
                boolean passCorreta = this.mc.passwordMatches(user,pw);
                if (passCorreta && !mc.getUser(user).getIsOn()) {
                    username.clear();
                    password.clear();
                    Utilizador u = mc.getUser(user);
                    if (u instanceof Cliente) mc.displayConfigManager();
                    else mc.displayFuncFrame();
                    mc.getUser(user).setOn();
                }
                else if (passCorreta) showLoginError("Password inválida, tente novamente!");

                else  showLoginError("Cliente já autenticado");
        }

    }

    public void showRegisto() {
        this.mc.displayRegistry();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
