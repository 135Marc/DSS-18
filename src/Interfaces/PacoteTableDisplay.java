package Interfaces;

import DetalhesExteriores.DetalheExterior;
import DetalhesInteriores.DetalheInterior;
import Items.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class PacoteTableDisplay implements Initializable {

    @FXML
    private TableView<Item> itens;
    private TableView<DetalheExterior> detsExt;
    private TableView<DetalheInterior> detInt;

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

        TableColumn<DetalheExterior, String> tc1 = new TableColumn<>("Tipo ");
        TableColumn<DetalheExterior, String> tc2 = new TableColumn<>("Preco");
        tc1.setPrefWidth(84);
        tc2.setPrefWidth(115);
        tc1.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tc2.setCellValueFactory(new PropertyValueFactory<>("preco"));
        detsExt.getColumns().addAll(tc1, tc2);
        detsExt.getItems().addAll(loadDetsExte());

    }

    public ObservableSet<DetalheExterior> loadDetsExte() {
        ObservableSet<DetalheExterior> listcnfg = FXCollections.observableSet(mc.getPac().getDetsExterior());
        return listcnfg;}

    public void turnBack(){
        this.mc.displayPacoteFrame();
    }

}
