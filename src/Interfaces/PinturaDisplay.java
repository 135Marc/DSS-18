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

public class PinturaDisplay implements Initializable {

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
        tc1.setPrefWidth(84);
        tc2.setPrefWidth(115);
        tc1.setCellValueFactory(new PropertyValueFactory<>("cor"));
        tc2.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        paintable.getColumns().addAll(tc1, tc2);
        paintable.getItems().addAll(loadPaints());
    }

    public ObservableList<Pintura> loadPaints() {
        Set<Integer> teste = new HashSet<Integer>();
        teste.add(3);
        ObservableList<Pintura> listcnfg = FXCollections.observableArrayList(
                new Pintura("Branca","Metalizada",1,teste),
                new Pintura("Vermelha","Normal",1,teste),
                new Pintura("Castanha","Premium",1,teste));
        return listcnfg;
    }

    public void turnBack() {
        this.mc.displayItemFrame();
    }


    public void adicionaPintura() {
        Pintura a = paintable.getSelectionModel().getSelectedItem();
        mc.getConfig(mc.getId(),mc.getConfigNome()).addItem(a);

    }
}
