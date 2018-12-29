package Interfaces;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private String nome = "ola";

    public void setMainController(MainController mc) {
        this.mc = mc;
    }

    public void init(MainView mv) {
        this.main = mv;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public ObservableList<Configuracao> defaultConfigs() {
        Map<String,Configuracao> merdas = new HashMap<>();
        Configuracao teste = new Configuracao("mmmm",2000,new HashSet<>(),new HashSet<>(),new HashSet<>());
        merdas.put(teste.getNome(),teste);
        /*ObservableList<Configuracao> listcnfg = FXCollections.observableArrayList(new Configuracao("Land Cruiser", 1000, new HashSet<>(), new HashSet<>(), new HashSet<>()),
                new Configuracao("Low-Rider", 10000, new HashSet<>(), new HashSet<>(), new HashSet<>()),
                new Configuracao("Smooth-Rider", 50000, new HashSet<>(), new HashSet<>(), new HashSet<>()));*/
        return FXCollections.observableArrayList(merdas.values());
    }

    public void populateTable() {
        TableColumn<Configuracao,String> tc1 = new TableColumn<>("Nome");
        TableColumn<Configuracao,Float> tc2 = new TableColumn<>("Preço");
        tc1.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tc2.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tv.getColumns().addAll(tc1, tc2);
        tv.getItems().addAll(this.mc.getAllConfigs(mc.getId()));
        removebtn.setDisable(true);
        editbtn.setDisable(true);
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

    public void addConfig() {
        String name = configname.getText();
        Configuracao cfg = new Configuracao(name,0,new HashSet<>(),new HashSet<>(),new HashSet<>());
        this.mc.addConfig(cfg,mc.getId());
        tv.getItems().add(cfg);
        configname.clear();
    }

    public void configFrame() {
        tv.getSelectionModel().getSelectedItem().toString();
        String a =tv.getSelectionModel().getSelectedItem().getNome();
        setNome(a);
        mc.displayConfigEditor();
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String a){
        this.nome = a;
    }


}
