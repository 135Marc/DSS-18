package Interfaces;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Items.*;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

public class ConfigManager implements Initializable {

    @FXML
    private TableView<Configuracao> tv;
    @FXML
    private Button removebtn;
    @FXML
    private Button editbtn;

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
        TableColumn<Configuracao,String> tc1 = new TableColumn<>("Nome");
        TableColumn<Configuracao,Float> tc2 = new TableColumn<>("Preço");
        tc1.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tc2.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tv.getItems().addAll(defaultConfigs());
        tv.getColumns().addAll(tc1, tc2);
        removebtn.setDisable(true);
        editbtn.setDisable(true);
    }

    public ObservableList<Configuracao> defaultConfigs() {
        ObservableList<Configuracao> listcnfg = FXCollections.observableArrayList(
                new Configuracao("Land Cruiser",1000,new HashSet<>(),null,null),
                new Configuracao("Low-Rider",10000,new HashSet<>(),null,null),
                new Configuracao("Smooth-Rider",50000,new HashSet<>(),null,null));
        return listcnfg;
    }

    public void activateButton() {
        removebtn.setDisable(false);
        editbtn.setDisable(false);
    }

    public void removeConfig() {
        Configuracao cfg = tv.getSelectionModel().getSelectedItem();
        tv.getItems().remove(cfg);
    }

    public void configFrame() {
        Configuracao cfg = tv.getSelectionModel().getSelectedItem();
        mc.displayConfigEditor();
    }



}
