package Interfaces;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Registo extends Application {
    @FXML
    private TextField name;
    @FXML
    private TextField address;
    @FXML
    private TextField nif;
    @FXML
    private TextField postalcode;
    @FXML
    private TextField user;
    @FXML
    private PasswordField pw;
    @FXML
    private PasswordField pwconf;
    @FXML
    private TextField email;
    @FXML
    private Label status;

    private Map<String,Utilizador> utilizadores;

    public static void main(String[] args) {
        launch(args);
    }

    public boolean validaRegisto() {
        String username = user.getText();
        String password = pw.getText();
        String passconf = pwconf.getText();
        //String mailaddress = email.getText();
        //String postal = postalcode.getText();
        return (password.equals(passconf) || this.utilizadores.containsKey(username));
    }

    public void registarCliente() throws Exception {
        this.utilizadores = new HashMap<>();
        String username = user.getText();
        String password = pw.getText();
        boolean valid = validaRegisto();
        if (!valid) throw new Exception("Registo inválido!");
        else {
            Utilizador u = new Utilizador(username, password);
            this.utilizadores.put(username, u);
            status.setText("Utilizador adicionado");
            user.clear();
            pw.clear();
            pwconf.clear();
        }

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
