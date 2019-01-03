package Interfaces;
import Items.Item;
import Items.Jante;

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

public class JanteDisplay implements Initializable {

    @FXML
    private TableView<Jante> wheelt;
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
        TableColumn<Jante,String> tc3 = new TableColumn<>("Tipo");
        TableColumn<Jante,Integer> tc4 = new TableColumn<>("Espessura('')");
        tc3.setPrefWidth(97);
        tc4.setPrefWidth(102);
        tc3.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tc4.setCellValueFactory(new PropertyValueFactory<>("espessura"));
        wheelt.getColumns().addAll(tc3,tc4);
        wheelt.getItems().addAll(loadWheels());
    }

    public ObservableList<Jante> loadWheels() {
        Set<Integer> listaRestricap = new HashSet<Integer>();
        listaRestricap.add(1);
        ObservableList<Jante> listcnfg = FXCollections.observableArrayList(
                new Jante("Liga Leve",15,150,listaRestricap),
                new Jante("Larga",16,0,listaRestricap),
                new Jante("Neve",15,0,listaRestricap));
        return listcnfg;
    }

    public void turnBack() {
        this.mc.displayItemFrame();
    }

    public void adicionarItem() {
        Jante a = wheelt.getSelectionModel().getSelectedItem();
        if(!itemValidoParaAdicionar(a)){
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
        mc.getConfig(mc.getId(),mc.getConfigNome()).addItem(a);
        wheelt.getSelectionModel().clearSelection();
    }

    public Boolean itemValidoParaAdicionar(Item a){

        for(Item i : mc.getConfig(mc.getId(),mc.getConfigNome()).getItemlist()){
            if(a.getListaRestricao().contains(i.getId())){
                return false;
            }
        }
        return true;
    }
}
