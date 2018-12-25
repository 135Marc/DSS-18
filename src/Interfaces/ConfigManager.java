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
import java.util.ResourceBundle;

public class ConfigManager implements Initializable {

    @FXML
    private TableView<Carro> tv;
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
        TableColumn<Carro,String> tc1 = new TableColumn<>("Nome");
        TableColumn<Carro,String> tc2 = new TableColumn<>("Tipo");
        TableColumn<Carro,Integer> tc3 = new TableColumn<>("Portas");
        TableColumn<Carro,Configuracao> tc4 = new TableColumn<>("Preço");
        tc1.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tc2.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tc3.setCellValueFactory(new PropertyValueFactory<>("numeroportas"));
        tc4.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tv.getItems().addAll(defaultConfigs());
        tv.getColumns().addAll(tc1, tc2,tc3,tc4);
        removebtn.setDisable(true);
        editbtn.setDisable(true);
    }

    public ObservableList<Carro> defaultConfigs() {
        ObservableList<Carro> listcnfg = FXCollections.observableArrayList(
                new Carro("Land Cruiser","Jipe",4,1000,null),
                new Carro("Fodalhao", "Carro" ,2,10000,null),
                new Carro("Smooth Rider","Carrinha",4,750,null));
        return listcnfg;
    }

    public void activateButton() {
        removebtn.setDisable(false);
        editbtn.setDisable(false);
    }

    public void removeConfig() {
        Carro cfg = tv.getSelectionModel().getSelectedItem();
        tv.getItems().remove(cfg);
    }



}
