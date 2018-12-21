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

    public boolean validaRegisto() {
        String username = user.getText();
        String password = pw.getText();
        String passconf = pwconf.getText();
        //String mailaddress = email.getText();
        //String postal = postalcode.getText();
        return (password.equals(passconf) && !this.mc.hasUser(username));
    }

    public void registarCliente() throws Exception {
        String username = user.getText();
        String password = pw.getText();
        boolean valid = validaRegisto();
        if (!valid) throw new Exception("Registo inválido!");
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
