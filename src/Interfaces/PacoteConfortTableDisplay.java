package Interfaces;

import DetalhesExteriores.DetalheExterior;
import DetalhesInteriores.DetalheInterior;
import Items.Item;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class PacoteConfortTableDisplay implements Initializable {

    @FXML
    private TableView<Item> itens;
    @FXML
    private TableView<DetalheExterior> detsExt;
    @FXML
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
        itens.setSelectionModel(null);
        detsExt.setSelectionModel(null);
        detInt.setSelectionModel(null);
    }

    public void loadItems() {
        TableColumn<Item, String> tc5 = new TableColumn<>("Tipo ");
        TableColumn<Item, Float> tc6 = new TableColumn<>("Preco(€)");
        tc5.setPrefWidth(100);
        tc6.setPrefWidth(115);
        tc5.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tc6.setCellValueFactory(new PropertyValueFactory<>("preco"));
        itens.getColumns().addAll(tc5,tc6);
        itens.getItems().addAll(this.mc.getConforPac().getItens());
    }

    public void loadDetalhesInteriores() {
        TableColumn<DetalheInterior, String> tc3 = new TableColumn<>("Tipo ");
        TableColumn<DetalheInterior, Float> tc4 = new TableColumn<>("Preco(€)");
        tc3.setPrefWidth(115);
        tc4.setPrefWidth(115);
        tc3.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tc4.setCellValueFactory(new PropertyValueFactory<>("preco"));
        detInt.getColumns().addAll(tc3,tc4);
        detInt.getItems().addAll(this.mc.getConforPac().getDetsInterior());
    }

    public void loadDetalhesExteriores() {
        TableColumn<DetalheExterior, String> tc1 = new TableColumn<>("Tipo ");
        TableColumn<DetalheExterior, Float> tc2 = new TableColumn<>("Preco(€)");
        tc1.setPrefWidth(125);
        tc2.setPrefWidth(115);
        tc1.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tc2.setCellValueFactory(new PropertyValueFactory<>("preco"));
        detsExt.getColumns().addAll(tc1, tc2);
        detsExt.getItems().addAll(this.mc.getConforPac().getDetsExterior());
    }

    public void turnBack(){
        this.mc.displayPacoteFrame();
    }

    public void adiciona(){
        if(mc.getPacoteEscolhidoConfort() || mc.getPacoteEscolhidoSport()) return;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informação");
        alert.setHeaderText("Pacote adicionado com sucesso");
        alert.showAndWait();
        mc.getConfig(mc.getId(),mc.getConfigNome()).addPacote(mc.getConforPac());
        mc.setpacoteEscolhidoConfort();
    }

    public void remove(){
        if(!mc.getPacoteEscolhidoConfort()) return;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informação");
        alert.setHeaderText("Pacote removido com sucesso");
        alert.showAndWait();
        mc.getConfig(mc.getId(),mc.getConfigNome()).removePacote(mc.getConforPac());
        mc.setpacoteEscolhidoConfort();
    }

}
