package Interfaces;

import Items.Item;
import Items.Jante;
import Items.Pintura;
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

public class PinturaDisplay implements Initializable {

    @FXML
    private TableView<Pintura> paintable;
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
        TableColumn<Pintura,String> tc1 = new TableColumn<>("Cor");
        TableColumn<Pintura,String> tc2 = new TableColumn<>("Tipo");
        TableColumn<Pintura,Float> tc3 = new TableColumn<>("Preço(€)");
        tc1.setPrefWidth(84);
        tc2.setPrefWidth(115);
        tc3.setPrefWidth(97);
        tc1.setCellValueFactory(new PropertyValueFactory<>("cor"));
        tc2.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tc3.setCellValueFactory(new PropertyValueFactory<>("preco"));
        paintable.getColumns().addAll(tc1, tc2,tc3);
        paintable.getItems().addAll(loadPaints());
    }

    public ObservableList<Pintura> loadPaints() {
        Set<Integer> teste = new HashSet<Integer>();
        teste.add(3);
        ObservableList<Pintura> listcnfg = FXCollections.observableArrayList(
                new Pintura("Branca","Metalizada",400,teste),
                new Pintura("Vermelha","Normal",250,teste),
                new Pintura("Castanha","Premium",650,teste));
        return listcnfg;
    }

    public void turnBack() {
        this.mc.displayItemFrame();
    }


    public void adicionaPintura() {
        Pintura a = paintable.getSelectionModel().getSelectedItem();

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
        paintable.getSelectionModel().clearSelection();
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
