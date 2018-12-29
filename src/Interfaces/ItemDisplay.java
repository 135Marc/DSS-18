package Interfaces;

import Items.Jante;
import Items.Pintura;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

public class ItemDisplay implements Initializable {

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

    public void turnBack() {
        this.mc.displayConfigEditor();
    }

    public void engineView() { this.mc.displayEngineFrame();}

    public void tireView() { this.mc.displayTireFrame();}

    public void wheelView() {this.mc.displayWheelFrame();}

    public void paintView() {this.mc.displayPaintFrame();}

    /*
    public void adicionarItem() {
        Jante a = wheelt.getSelectionModel().getSelectedItem();
        mc.getConfig(mc.getId(),mc.getConfigNome()).addItem(a);
        mc.adicionaCarrinho(a);
    }*/


}
