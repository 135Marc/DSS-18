package Interfaces;

import DetalhesInteriores.Ac;
import DetalhesInteriores.DetalheInterior;
import DetalhesInteriores.Estofos;
import DetalhesInteriores.Gps;
import Items.Motor;
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

public class DetalheInteriorDisplay implements Initializable {

   @FXML
   private TableView<DetalheInterior> innertable;


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
        TableColumn<DetalheInterior,String> tc1 = new TableColumn<>("Tipo");
        TableColumn<DetalheInterior,Float> tc2 = new TableColumn<>("Preço(€)");
        TableColumn<DetalheInterior,String> tc3 = new TableColumn<>("Cor");
        TableColumn<DetalheInterior,String> tc4 = new TableColumn<>("Tecido");
        tc1.setPrefWidth(150);
        tc2.setPrefWidth(102);
        tc3.setPrefWidth(97);
        tc4.setPrefWidth(102);
        tc1.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tc2.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tc3.setCellValueFactory(new PropertyValueFactory<>("cor"));
        tc4.setCellValueFactory(new PropertyValueFactory<>("tecido"));
        innertable.getColumns().addAll(tc1,tc2,tc3,tc4);
        innertable.getItems().addAll(loadInnerDetails());
    }

    public void turnBack() {
        this.mc.displayConfigEditor();
    }

    public ObservableList<DetalheInterior> loadInnerDetails() {
        Set<Integer> ac = new HashSet<Integer>();
        ac.add(22);
        Set<Integer> gps = new HashSet<>();
        gps.add(21);
        Set<Integer> estof = new HashSet<>();
        estof.add(20);
        ObservableList<DetalheInterior> listcnfg = FXCollections.observableArrayList(
                new Ac("Ar Condicionado",50,ac),
                new Gps("GPS",150,gps),
                new Estofos("Pele","beje","cabedal",100,estof));
        return listcnfg;
    }


    public void adicionarDetalheInterior(){
        DetalheInterior a = innertable.getSelectionModel().getSelectedItem();
        if(!DetIntValidoParaAdicionar(a)){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmaçao de restrição");
            alert.setHeaderText("Para adicionar este Item serão removidos itens incompativeis ");
            alert.setContentText("Confirma a remoção de todos os itens incompativeis para adicionar este?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){

                for(DetalheInterior i : mc.getConfig(mc.getId(),mc.getConfigNome()).getInnerdetails()){
                    if(a.getListaRestricao().contains(i.getID())){
                        mc.getConfig(mc.getId(),mc.getConfigNome()).removeDetInt(i);
                    }
                }
            }
            else {
                return;
            }
        }
        mc.getConfig(mc.getId(),mc.getConfigNome()).addInnerDetail(a);
        innertable.getSelectionModel().clearSelection();
    }

    public Boolean DetIntValidoParaAdicionar(DetalheInterior a){

        for(DetalheInterior i : mc.getConfig(mc.getId(),mc.getConfigNome()).getInnerdetails()){
            if(a.getListaRestricao().contains(i.getID())){
                return false;
            }
        }
        return true;
    }

}
