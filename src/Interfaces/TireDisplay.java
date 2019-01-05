package Interfaces;

import Items.Item;
import Items.Pneu;
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

public class TireDisplay implements Initializable {

    @FXML
    private TableView<Pneu> tabelapneu;

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
        TableColumn<Pneu,String> tc1 = new TableColumn<>("Tipo");
        TableColumn<Pneu,Float> tc2 = new TableColumn<>("Preço(€)");
        TableColumn<Pneu,Integer> tc3 = new TableColumn<>("Largura");
        TableColumn<Pneu,Integer> tc4 = new TableColumn<>("Diametro");
        TableColumn<Pneu,Integer> tc5 = new TableColumn<>("Carga");
        TableColumn<Pneu,Integer> tc6 = new TableColumn<>("Velocidade");
        TableColumn<Pneu,String> tc7 = new TableColumn<>("Serie");
        TableColumn<Pneu,String> tc8 = new TableColumn<>("Construcao");
        tc1.setPrefWidth(150);
        tc2.setPrefWidth(102);
        tc1.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tc2.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tc3.setCellValueFactory(new PropertyValueFactory<>("largura"));
        tc4.setCellValueFactory(new PropertyValueFactory<>("diametrointerior"));
        tc5.setCellValueFactory(new PropertyValueFactory<>("indexcarga"));
        tc6.setCellValueFactory(new PropertyValueFactory<>("indexvel"));
        tc7.setCellValueFactory(new PropertyValueFactory<>("serie"));
        tc8.setCellValueFactory(new PropertyValueFactory<>("construcao"));
        tabelapneu.getColumns().addAll(tc1,tc2,tc3,tc4,tc5,tc6,tc7,tc8);
        tabelapneu.getItems().addAll(loadTires());
    }

    public ObservableList<Pneu> loadTires() {
        Set<Integer> listaRest = new HashSet<Integer>();
        listaRest.add(4);
        ObservableList<Pneu> listcnfg = FXCollections.observableArrayList(
                new Pneu(20,17,65,4,"blele","R","Pneu de Estrada",100,listaRest),
                new Pneu(30,15,66,7,"blele","R","Pneu de Neve",150,listaRest),
                new Pneu(40,16,67,9,"blele","R","Pneu de Camião",300,listaRest));
        return listcnfg;
    }


    public void turnBack() {
        this.mc.displayItemFrame();
    }

    public void adicionarItem() {
        Pneu a = tabelapneu.getSelectionModel().getSelectedItem();

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
        mc.getConfig(mc.getId(),mc.getConfigNome()).addItem(a);
        tabelapneu.getSelectionModel().clearSelection();
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
