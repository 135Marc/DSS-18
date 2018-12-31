package Interfaces;
import Items.Jante;

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

public class JanteDisplay implements Initializable {

    @FXML
    private TableView<Jante> wheelt;
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
        TableColumn<Jante,String> tc3 = new TableColumn<>("Tipo");
        TableColumn<Jante,Integer> tc4 = new TableColumn<>("Espessura");
        tc3.setPrefWidth(97);
        tc4.setPrefWidth(102);
        tc3.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tc4.setCellValueFactory(new PropertyValueFactory<>("espessura"));
        wheelt.getColumns().addAll(tc3,tc4);
        wheelt.getItems().addAll(loadWheels());
    }

    public ObservableList<Jante> loadWheels() {
        Set<Integer> listaRestricap = new HashSet<Integer>();
        listaRestricap.add(1);
        ObservableList<Jante> listcnfg = FXCollections.observableArrayList(
                new Jante("Liga Leve",15,150,listaRestricap),
                new Jante("Larga",16,0,listaRestricap),
                new Jante("Neve",15,0,listaRestricap));
        return listcnfg;
    }

    public void turnBack() {
        this.mc.displayItemFrame();
    }

    public void adicionarItem() {
        Jante a = wheelt.getSelectionModel().getSelectedItem();
        mc.getConfig(mc.getId(),mc.getConfigNome()).addItem(a);

    }
}
