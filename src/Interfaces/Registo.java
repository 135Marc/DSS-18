package Interfaces;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import static javafx.application.Application.launch;

public class Registo implements Initializable {
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

    private  MainController mc;

    private MainView main;

    public void setMainController(MainController mc) {
        this.mc = mc;
    }

    public void init(MainView mv) {
        this.main = mv;
    }

    private boolean validaRegisto() {
        String username = user.getText();
        String password = pw.getText();
        String passconf = pwconf.getText();
        return (password.equals(passconf) && !this.mc.hasUser(username));
    }

    private void showSignUpError(String errormsg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Erro");
        alert.setHeaderText("Registo Inválido:");
        alert.setContentText(errormsg);
        alert.showAndWait();
    }

    public void registarCliente() throws Exception {
        String username = user.getText();
        String password = pw.getText();
        boolean valid = validaRegisto();
        if (!valid) showSignUpError("As passwords não coincidem! Tente novamente");
        else {
            mc.addUser(username, password);
            status.setText("Utilizador adicionado");
            user.clear();
            pw.clear();
            pwconf.clear();
            this.mc.displayLogin();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
