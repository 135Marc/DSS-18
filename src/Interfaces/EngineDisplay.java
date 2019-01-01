package Interfaces;

import Items.*;
import Items.Motor;
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

public class EngineDisplay implements Initializable {

    @FXML
    private TableView<Motor> motores;
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

        TableColumn<Motor,String> tc3 = new TableColumn<>("Tipo");
        TableColumn<Motor,Integer> tc4 = new TableColumn<>("Potencia(cv)");
        TableColumn<Motor,String> tc5 = new TableColumn<>("Consumo(l/100km)");
        TableColumn<Motor,Integer> tc6 = new TableColumn<>("Preco(€)");
        tc3.setPrefWidth(97);
        tc4.setPrefWidth(102);
        tc5.setPrefWidth(150);
        tc6.setPrefWidth(102);
        tc3.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tc4.setCellValueFactory(new PropertyValueFactory<>("potencia"));
        tc5.setCellValueFactory(new PropertyValueFactory<>("consumomedio"));
        tc6.setCellValueFactory(new PropertyValueFactory<>("preco"));
        motores.getColumns().addAll(tc3,tc4,tc5,tc6);
        motores.getItems().addAll(loadPneus());

    }

    public ObservableList<Motor> loadPneus(){
        Set<Integer> listaRestricao = new HashSet<Integer>();
        listaRestricao.add(2);
        ObservableList<Motor> listcnfg = FXCollections.observableArrayList(
                new Motor("Gasoleo",1600,4,500,listaRestricao),
                new Motor("Gasolina",2000,6,500,listaRestricao),
                new Motor("Eletrico",1600,0,500,listaRestricao));
        return listcnfg;
    }

    public void turnBack() {
        this.mc.displayItemFrame();
    }

    public void adicionarMotor(){
        Motor a = motores.getSelectionModel().getSelectedItem();
        mc.getConfig(mc.getId(),mc.getConfigNome()).addItem(a);
        motores.getSelectionModel().clearSelection();
    }
}
