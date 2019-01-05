package Interfaces;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.*;

public class ConfigManager implements Initializable {

    @FXML
    private TableView<Configuracao> tv;
    @FXML
    private Button removebtn;
    @FXML
    private Button editbtn;
    @FXML
    private TextField configname;

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

    }


    public void populateTable() {
        TableColumn<Configuracao,String> tc1 = new TableColumn<>("Nome");
        TableColumn<Configuracao,Float> tc2 = new TableColumn<>("Preço(€)");
        tc1.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tc2.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tv.getColumns().addAll(tc1, tc2);
        if(this.mc.getAllConfigs(mc.getId()) != null) {
            tv.getItems().addAll(loadConfig(this.mc.getId()));
        }
        removebtn.setDisable(true);
        editbtn.setDisable(true);
    }

    public List<Configuracao> loadConfig(String id){
        List<Configuracao> lista = new ArrayList<>();


        for(Configuracao a : this.mc.getAllConfigs(mc.getId())){
            if(!a.getSubmetida()){
                lista.add(a);
            }
        }
        return lista;
    }

    public void activateButton() {
        removebtn.setDisable(false);
        editbtn.setDisable(false); 
    }

    public void removeConfig() {
        Configuracao a = tv.getSelectionModel().getSelectedItem();
        tv.getItems().remove(a);
        this.mc.removeConfig(a);
    }

    public void configErro(String errormsg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Nome de configuração existente");
        alert.setContentText(errormsg);
        alert.showAndWait();
    }

    public void addConfig() {
        String name = configname.getText();
        if(mc.configExiste(name)) configErro("Tente com um nome diferente");
        else {
            Configuracao cfg = new Configuracao(name, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
            this.mc.addConfig(cfg, mc.getId());
            tv.getItems().add(cfg);
        }
        configname.clear();
    }

    public void configFrame() {
        tv.getSelectionModel().getSelectedItem().toString();
        String a =tv.getSelectionModel().getSelectedItem().getNome();
        mc.setNomeConfig(a);
        mc.displayConfigEditor();
    }

    public void logout(){
        mc.getUser(mc.getId()).setOff();
        mc.displayLogin();
    }


}
