package Interfaces;

import DetalhesExteriores.*;
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

public class DetalheExteriorDisplay implements Initializable {

    @FXML
    private TableView<DetalheExterior> detsExt;
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
        TableColumn<DetalheExterior,String> tc1 = new TableColumn<>("Tipo");
        TableColumn<DetalheExterior,String> tc2 = new TableColumn<>("Preco(€)");
        tc1.setPrefWidth(150);
        tc2.setPrefWidth(115);
        tc1.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tc2.setCellValueFactory(new PropertyValueFactory<>("preco"));
        detsExt.getColumns().addAll(tc1, tc2);
        detsExt.getItems().addAll(loadDetsExte());

    }

    public ObservableList<DetalheExterior> loadDetsExte() {
        Set<Integer> cameraTraseira = new HashSet<Integer>();
        Set<Integer> paraChoques = new HashSet<Integer>();
        Set<Integer> sensorTraseiro = new HashSet<Integer>();
        Set<Integer> sensorFrontal = new HashSet<Integer>();
        Set<Integer> tetoAbrir = new HashSet<Integer>();
        Set<Integer> vidrosFumados = new HashSet<Integer>();
        cameraTraseira.add(30);
        cameraTraseira.add(32);
        paraChoques.add(31);
        sensorTraseiro.add(32);
        sensorTraseiro.add(30);
        sensorFrontal.add(33);
        tetoAbrir.add(34);
        vidrosFumados.add(35);

        ObservableList<DetalheExterior> listcnfg = FXCollections.observableArrayList(
                new CameraTraseira("Camera Traseira",1,cameraTraseira),
                new Parachoques("ParaChoques",150,paraChoques),
                new SensoresTraseiros("Sensores Traseiros",90,sensorTraseiro),
                new SensorFrontal("Sensor Frontal",60,sensorFrontal),
                new TetoAbrir("Teto Abrir",50,tetoAbrir),
                new  VidrosFumados("Vidros Fumados",55,vidrosFumados));
        return listcnfg;
    }

    public void turnBack() {
        this.mc.displayConfigEditor();
    }

    public void addDet(){
        DetalheExterior a = detsExt.getSelectionModel().getSelectedItem();
        if(!DetExtValidoParaAdicionar(a)){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmaçao de restrição");
            alert.setHeaderText("Para adicionar este Item serão removidos itens incompativeis ");
            alert.setContentText("Confirma a remoção de todos os itens incompativeis para adicionar este?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){

                for(DetalheExterior i : mc.getConfig(mc.getId(),mc.getConfigNome()).getOuterdetails()){
                    if(a.getListaRestricao().contains(i.getID())){
                        mc.getConfig(mc.getId(),mc.getConfigNome()).removeDetExt(i);
                    }
                }
            }
            else {
                return;
            }
        }
        mc.getConfig(mc.getId(),mc.getConfigNome()).addOuterDetail(a);
        detsExt.getSelectionModel().clearSelection();
    }

    public Boolean DetExtValidoParaAdicionar(DetalheExterior a){

        for(DetalheExterior i : mc.getConfig(mc.getId(),mc.getConfigNome()).getOuterdetails()){
            if(a.getListaRestricao().contains(i.getID())){
                return false;
            }
        }
        return true;
    }
}
