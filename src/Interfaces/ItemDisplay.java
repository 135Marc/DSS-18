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

    @FXML
    private TableView<Jante> wheelt;
    @FXML
    private TableView<Pintura> paintable;

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
        TableColumn<Pintura,String> tc1 = new TableColumn<>("Cor");
        TableColumn<Pintura,String> tc2 = new TableColumn<>("Tipo");
        TableColumn<Jante,String> tc3 = new TableColumn<>("Tipo");
        TableColumn<Jante,Integer> tc4 = new TableColumn<>("Espessura");
        tc1.setPrefWidth(84);
        tc2.setPrefWidth(115);
        tc3.setPrefWidth(97);
        tc4.setPrefWidth(102);
        tc1.setCellValueFactory(new PropertyValueFactory<>("cor"));
        tc2.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tc3.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tc4.setCellValueFactory(new PropertyValueFactory<>("espessura"));
        paintable.getItems().addAll(loadPaints());
        wheelt.getItems().addAll(loadWheels());
        paintable.getColumns().addAll(tc1, tc2);
        wheelt.getColumns().addAll(tc3,tc4);
    }


    public ObservableList<Pintura> loadPaints() {

        ObservableList<Pintura> listcnfg = FXCollections.observableArrayList(
                new Pintura("Branca","Metalizada"),
                new Pintura("Vermelha","Normal"),
                new Pintura("Castanha","Premium"));
        return listcnfg;
    }

    public ObservableList<Jante> loadWheels() {
        Set<Integer> teste = new HashSet<Integer>();
        teste.add(1);
        ObservableList<Jante> listcnfg = FXCollections.observableArrayList(
                new Jante("Liga Leve",15,0,teste),
                new Jante("Larga",16,0,teste),
                new Jante("Neve",15,0,teste));
        return listcnfg;
    }


    public void turnBack() {
        this.mc.displayConfigEditor();
    }

    public void engineView() { this.mc.displayEngineFrame();}

    public void tireView() { this.mc.displayTireFrame();}

    public void adicionarItem() {

        Jante a = wheelt.getSelectionModel().getSelectedItem();
        mc.getConfig(mc.getId(),mc.getConfigNome()).addItem(a);
        mc.adicionaCarrinho(a);
    }


}
