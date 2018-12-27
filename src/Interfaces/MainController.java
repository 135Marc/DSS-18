package Interfaces;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private Utilizadores usersmap;
    @FXML
    private Registo regist;
    @FXML
    private LogIn logz;
    @FXML
    private ConfigManager configmanager;
    @FXML
    private Configuracao config;
    @FXML
    private ItemDisplay itemdisp;
    @FXML
    private EngineDisplay engdisp;
    @FXML
    private TireDisplay tiredisp;


    @FXML
    private MainView mview;

    public MainController(MainView mv) {
        this.usersmap = new Utilizadores();
        mview = mv;
    }

    public void initialize(URL location, ResourceBundle resources)  {

    }

    public void setRegist(Registo r) {
        this.regist=r;
    }

    public void setLogIn (LogIn li) {
        this.logz = li;
    }

    public void setConfigManager(ConfigManager cm) {this.configmanager = cm;}

    public void setConfigEditor(Configuracao cfg) {this.config = cfg;}

    public void setItemDisplay(ItemDisplay itd) {this.itemdisp = itd;}

    public void setEngineDisplay(EngineDisplay egd) {this.engdisp = egd;}

    public void setTireDisplay(TireDisplay tid) {this.tiredisp = tid;}


    public boolean hasUser(String id) {
        Map<String,Utilizador> umap = usersmap.getUserMap();
        return (umap.containsKey(id));
    }

    public boolean passwordMatches(String id,String password) {
        Utilizador u = usersmap.getUserMap().get(id);
        return (u.getPassword().equals(password));
    }

    public void addUser(String id, String password) {
        Utilizador u = new Utilizador(id,password);
        this.usersmap.addToMap(id,u);
    }

    public void displayRegistry() {
        mview.showRegistForm();
    }

    public void displayLogin() {
        mview.showLogin();
    }

    public void displayConfigManager() {
        mview.showConfigManager();
    }

    public void displayConfigEditor() {mview.showConfigEditor();}

    public void displayItemFrame() {mview.showItemsFrame();}

    public void displayEngineFrame() { mview.showEngineFrame();}

    public void displayTireFrame() {mview.showTireDisplay();}

    public Configuracao getConfig() {
        return this.config;
    }

}
