package Interfaces;

import DetalhesExteriores.DetalheExterior;
import Items.Item;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

public class ConfigDisplay  implements Initializable {
    @FXML
    private TableView<Object> cart;
    private MainController mc;
    private MainView main;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void loadTable() {
        TableColumn<Object,String> tc3 = new TableColumn<>("Tipo");
        TableColumn<Object,Float> tc4 = new TableColumn<>("Preço");
        tc3.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tc4.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tc3.setPrefWidth(97);
        tc4.setPrefWidth(102);
        String cenas = mc.getConfigNome();
        String id = mc.getId();
        Configuracao cfg = mc.getConfig(id,cenas);
        cart.getColumns().addAll(tc3,tc4);
        cart.getItems().addAll(atualizaItens(cfg));
        cart.getItems().addAll(atualizaDetExte(cfg));
    }

    public Set<Item> atualizaItens(Configuracao cfg) {
        return cfg.getItemlist();
    }

    public Set<DetalheExterior> atualizaDetExte(Configuracao cfg){
        return cfg.getOuterdetails();
    }

    public void itemFrame() { //NULL POINTER
        this.mc.displayItemFrame();
    }

    public void innerFrame() {this.mc.displayInnerFrame();}

    public void outterFrame() {this.mc.displayOutterFrame();}

    public void turnBack( ) { //NULL POINTER
        this.mc.displayConfigManager();
    }

    public void setMainController(MainController mc) {
        this.mc = mc;
    }

    public void init(MainView mv) {
        this.main = mv;
    }



}
