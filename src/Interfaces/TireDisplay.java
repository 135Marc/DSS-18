package Interfaces;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class TireDisplay implements Initializable {
    private  MainController mc;

    private MainView main;

    public void setMainController(MainController mc) {
        this.mc = mc;
    }

    public void init(MainView mv) {
        this.main = mv;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
