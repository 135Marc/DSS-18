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

    private  Map<String,Utilizador> utilizadores;


    public void populate() {
        this.utilizadores = new HashMap<>();
        Utilizador u = new Utilizador("Grande","gigante");
        Utilizador u1 = new Utilizador("Teste", "teste");
        utilizadores.put(u.getUsername(),u);
        utilizadores.put(u1.getUsername(),u1);
    }

    public void addUser() throws Exception {
        this.utilizadores = new HashMap<>();
        Utilizador u = new Utilizador(username.getText(),password.getText());
        if (this.utilizadores.containsKey(username.getText())) {
            throw new Exception("Utilizador existente");
        }
        else this.utilizadores.put(u.getUsername(),u);
        username.clear();
        password.clear();
        label1.setText("Utilizador adicionado");
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
