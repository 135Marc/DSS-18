package Interfaces;

import Items.Item;
import Items.Jante;
import Items.Pintura;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

public class ConfigDisplay  implements Initializable {
    @FXML
    private TableView<Jante> cart;
    private MainController mc;
    private MainView main;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void loadTable() {
        TableColumn<Jante,String> tc3 = new TableColumn<>("Tipo");
        TableColumn<Jante,Float> tc4 = new TableColumn<>("Preço");
        tc3.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tc4.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tc3.setPrefWidth(97);
        tc4.setPrefWidth(102);
        String cenas = mc.getConfigNome();
        String id = mc.getId();
        Configuracao merdas = mc.getConfig(id,cenas);
        cart.getColumns().addAll(tc3,tc4);
        cart.getItems().add(getDaJante(merdas));
    }

    public Jante getDaJante(Configuracao cfg) {
        Set<Item> listinha  = cfg.getItemlist();
        Jante j = new Jante();
        for (Item i : listinha) {
            if (i.getId()==1) j = (Jante) i;
        }
        return j;
    }

    public void itemFrame() { //NULL POINTER
        this.mc.displayItemFrame();
    }

    public void turnBack(   ) { //NULL POINTER
        this.mc.displayConfigManager();
    }

    public void setMainController(MainController mc) {
        this.mc = mc;
    }

    public void init(MainView mv) {
        this.main = mv;
    }

    public void adicionaCarrinho(Jante a){
        cart.getItems().add(a);
    }



}
