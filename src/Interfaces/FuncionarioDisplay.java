package Interfaces;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    @FXML
    private TextField id;
    @FXML
    private TextField numero;
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
        if(mc.getFabrica().stockDisponivelParaCOnfig(configs.getSelectionModel().getSelectedItem())){
            mc.getFabrica().consomeStock(configs.getSelectionModel().getSelectedItem());
            mc.getFabrica().removeConfig(configs.getSelectionModel().getSelectedItem());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Configuração processada");
            alert.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informação");
            alert.setHeaderText("Não há stock suficiente para processar esta configuração");
            alert.showAndWait();
        }

    }

    public void adicionaIventario(){
        mc.getFabrica().addStock(Integer.parseInt(id.getText()),Integer.parseInt(numero.getText()));
    }

}
