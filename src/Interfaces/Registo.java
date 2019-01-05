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
    private ChoiceBox<String> cidade;
    @FXML
    private ChoiceBox<String> tipo;

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
        String mail = email.getText();
        String morada = address.getText();
        String nome = name.getText();
        String codpostal = postalcode.getText();
        String idfiscal = nif.getText();
        boolean empty = (username.isEmpty() || password.isEmpty() || passconf.isEmpty());
        return (password.equals(passconf) && !this.mc.hasUser(username) && !empty);
    }

    private void showSignUpError(String errormsg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Registo Inválido:");
        alert.setContentText(errormsg);
        alert.showAndWait();
    }

    public void voltar() {
        this.mc.displayLogin();
    }

    public void registarCliente() throws Exception {
        String username = user.getText();
        String password = pw.getText();
        boolean valid = validaRegisto();
        if (!valid) showSignUpError("Verifique se os campos (*) estão bem preenchidos!");
        else if (tipo.getSelectionModel().isEmpty()) showSignUpError("Tem de escolher um tipo!");
        else {
            String select = tipo.getSelectionModel().getSelectedItem();
            mc.addUser(select,username, password);
            user.clear();
            pw.clear();
            pwconf.clear();
            this.mc.displayLogin();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cidade.getItems().add("Braga");
        cidade.getItems().add("Lisboa");
        cidade.getItems().add("Porto");
        tipo.getItems().add("Cliente");
        tipo.getItems().add("Funcionário");

    }
}
