package Interfaces;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LogIn extends Application {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label label1;

    private  Utilizadores userdb;



    public void addUser() throws Exception {
        this.userdb = new Utilizadores();
        String user = username.getText();
        String pw = password.getText();
        if (!this.userdb.hasUser(user)) throw new Exception("Utilizador não existente");
        else {
                if (this.userdb.passwordMatches(user,pw)) {
                    username.clear();
                    password.clear();
                    label1.setText("Autenticação bem sucedida!");
                }
                else throw new Exception("Password errada! Tenta novamente");
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Interfaces/login.fxml"));
        Pane view = loader.load();
        Scene nova = new Scene(view,550,200);
        primaryStage.setScene(nova);
        primaryStage.setTitle("Autenticar Cliente");
        primaryStage.show();
    }



}
