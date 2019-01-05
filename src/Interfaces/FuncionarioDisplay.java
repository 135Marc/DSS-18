package Interfaces;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

public class FuncionarioDisplay implements Initializable {
    private  MainController mc;

    @FXML
    private TableView<Configuracao> configs;
    private MainView main;

    public void setMainController(MainController mc) {
        this.mc = mc;
    }

    public void init(MainView mv) {
        this.main = mv;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }


    public void populateTable() {
        TableColumn<Configuracao,String> tc1 = new TableColumn<>("Nome ");
        TableColumn<Configuracao,Float> tc2 = new TableColumn<>("Preço(€)");
        tc1.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tc2.setCellValueFactory(new PropertyValueFactory<>("preco"));
        configs.getColumns().addAll(tc1, tc2);
        configs.getItems().addAll(mc.getFabrica().allconfigs());
    }


    public void processa(){

    }

}
