package Interfaces;

import DetalhesInteriores.Ac;
import DetalhesInteriores.DetalheInterior;
import DetalhesInteriores.Estofos;
import DetalhesInteriores.Gps;
import Items.Motor;
import Items.Pneu;
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

public class DetalheInteriorDisplay implements Initializable {

   @FXML
   private TableView<DetalheInterior> innertable;
   @FXML
   private TableView<DetalheInterior> estofotable;

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
        TableColumn<DetalheInterior,String> tc1 = new TableColumn<>("Tipo");
        TableColumn<DetalheInterior,Float> tc2 = new TableColumn<>("Preço");
        TableColumn<DetalheInterior,String> tc3 = new TableColumn<>("Cor");
        TableColumn<DetalheInterior,String> tc4 = new TableColumn<>("Tecido");
        TableColumn<DetalheInterior,Float> tc5 = new TableColumn<>("Preço");
        tc1.setPrefWidth(97);
        tc2.setPrefWidth(102);
        tc3.setPrefWidth(97);
        tc4.setPrefWidth(102);
        tc5.setPrefWidth(102);
        tc1.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tc2.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tc3.setCellValueFactory(new PropertyValueFactory<>("cor"));
        tc4.setCellValueFactory(new PropertyValueFactory<>("tecido"));
        tc5.setCellValueFactory(new PropertyValueFactory<>("preco"));
        innertable.getColumns().addAll(tc1,tc2);
        estofotable.getColumns().addAll(tc3,tc4,tc5);
        innertable.getItems().addAll(loadInnerDetails());
        estofotable.getItems().addAll(loadEstofos());
    }

    public void turnBack() {
        this.mc.displayConfigEditor();
    }

    public ObservableList<DetalheInterior> loadInnerDetails() {
        Set<Integer> ac = new HashSet<Integer>();
        ac.add(22);
        Set<Integer> gps = new HashSet<>();
        gps.add(21);
        ObservableList<DetalheInterior> listcnfg = FXCollections.observableArrayList(
                new Ac("Ar Condicionado",50,ac),
                new Gps("GPS",150,gps));
        return listcnfg;
    }

    public ObservableList<DetalheInterior> loadEstofos() {
        Set<Integer> estofo = new HashSet<>();
        estofo.add(20);
        ObservableList<DetalheInterior> listcnfg = FXCollections.observableArrayList(new Estofos("Estofos","Branco","Cabedal",300,estofo));
        return listcnfg;
    }

    public void adicionarDetalheInterior(){
        DetalheInterior a = estofotable.getSelectionModel().getSelectedItem();
        DetalheInterior b = innertable.getSelectionModel().getSelectedItem();
        if (a!=null) {
            mc.getConfig(mc.getId(),mc.getConfigNome()).addInnerDetail(a);
            estofotable.getSelectionModel().clearSelection();
        }
        else if (b!=null) {
            mc.getConfig(mc.getId(),mc.getConfigNome()).addInnerDetail(b);
            innertable.getSelectionModel().clearSelection();
        }
    }

}
