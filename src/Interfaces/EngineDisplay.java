package Interfaces;

import Items.*;
import Items.Motor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.HashSet;
import java.util.Optional;
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
        if(fazPartePacote(a)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro");
            alert.setHeaderText("Não pode adicionar este item pois já tem um deste tipo adicionado na configurção");
            alert.showAndWait();
            return;
        }

       else if(!itemValidoParaAdicionar(a)){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmaçao de restrição");
            alert.setHeaderText("Para adicionar este Item serão removidos itens incompativeis ");
            alert.setContentText("Confirma a remoção de todos os itens incompativeis para adicionar este?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){

                for(Item i : mc.getConfig(mc.getId(),mc.getConfigNome()).getItemlist()){
                    if(a.getListaRestricao().contains(i.getId())){
                        mc.getConfig(mc.getId(),mc.getConfigNome()).removeItem(i);
                    }
                }
            }
            else {
                return;
            }
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informação");
        alert.setHeaderText("Motor adicionado com sucesso");
        alert.showAndWait();
        mc.getConfig(mc.getId(),mc.getConfigNome()).addItem(a);
        motores.getSelectionModel().clearSelection();
    }

    public Boolean itemValidoParaAdicionar(Item a){

        for(Item i : mc.getConfig(mc.getId(),mc.getConfigNome()).getItemlist()){
            if(a.getListaRestricao().contains(i.getId())){
                return false;
            }
        }
        return true;
    }

    public boolean fazPartePacote(Item a){

        for(Item i : mc.getConfig(mc.getId(),mc.getConfigNome()).getItemlist()){
            if(i.getId() == a.getId() && i.getEPacote()){
                return true;
            }
        }
        return false;
    }
}
