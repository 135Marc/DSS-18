package Interfaces;

import Items.Jante;
import Items.Pintura;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ConfigDisplay  implements Initializable {
    @FXML
    private TableView<Jante> cart;
    private MainController mc;
    private MainView main;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TableColumn<Jante,String> tc3 = new TableColumn<>("Nome");
        TableColumn<Jante,Float> tc4 = new TableColumn<>("Preço");
        tc3.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tc4.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tc3.setPrefWidth(97);
        tc4.setPrefWidth(102);
        cart.getColumns().addAll(tc3,tc4);
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
