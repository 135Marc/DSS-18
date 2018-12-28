package Interfaces;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private AppDesktop app;
    private Carros carros;
    private String id;
    @FXML
    private Registo regist;
    @FXML
    private LogIn logz;
    @FXML
    private ConfigManager configmanager;
    @FXML
    private ConfigDisplay config;
    @FXML
    private ItemDisplay itemdisp;
    @FXML
    private EngineDisplay engdisp;
    @FXML
    private TireDisplay tiredisp;


    @FXML
    private MainView mview;


    public MainController(MainView mv) {
        this.app = new AppDesktop();
        this.carros = new Carros();
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

    public void setConfigDisplay(ConfigDisplay cfg) {this.config = cfg;}

    public void setItemDisplay(ItemDisplay itd) {this.itemdisp = itd;}

    public void setEngineDisplay(EngineDisplay egd) {this.engdisp = egd;}

    public void setTireDisplay(TireDisplay tid) {this.tiredisp = tid;}


    public boolean hasUser(String id) {
        return app.userExiste(id);
    }

    public Utilizador getUser(String id) {
        return app.getUser(id);
    }

    public boolean passwordMatches(String id,String password) {
        return app.passwoordMatch(id,password);
    }

    public void addUser(String id, String password) {
        Utilizador u = new Utilizador(id,password);
        this.app.registaUser(u);
    }

    public void removeConfig(Configuracao a){
        this.carros.removeConfig(this.id,a);
    }

    public boolean noConfigs(String id) {
        return carros.noConfig(id);
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

    public String getId() {
        return this.id;
    }

    public void setId(String email) {
        this.id = email;
    }

    public List<Configuracao> getConfigs(String id){
        return this.carros.getConfigs(id);
    }

    public void addConfig(Configuracao a,String id){
        this.carros.adicionaConfig(id,a);
    }


}
