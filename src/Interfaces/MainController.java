package Interfaces;

import Items.Jante;
import Items.Pintura;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private AppDesktop app;
    private Carros carros;
    private String id;
    private String nomeConfig;
    @FXML
    private Registo regist;
    @FXML
    private LogIn logz;
    @FXML
    private ConfigManager configmanager;
    @FXML
    private ConfigDisplay configDisplay;
    @FXML
    private ItemDisplay itemdisp;
    @FXML
    private JanteDisplay jantedisp;
    @FXML
    private PinturaDisplay paintdisp;
    @FXML
    private EngineDisplay engdisp;
    @FXML
    private TireDisplay tiredisp;
    @FXML
    private DetalheExteriorDisplay outdisp;
    @FXML
    private DetalheInteriorDisplay indisp;


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

    public void setConfigDisplay(ConfigDisplay cfg) {this.configDisplay = cfg;}

    public void setItemDisplay(ItemDisplay itd) {this.itemdisp = itd;}

    public void setJanteDisplay(JanteDisplay jd) {this.jantedisp =jd;}

    public void setPinturaDisplay(PinturaDisplay pd) {this.paintdisp = pd;}

    public void setEngineDisplay(EngineDisplay egd) {this.engdisp = egd;}

    public void setTireDisplay(TireDisplay tid) {this.tiredisp = tid;}

    public void setInnerDisplay(DetalheInteriorDisplay didisp) {
        this.indisp=didisp;
    }

    public void setOutterDisplay(DetalheExteriorDisplay dedisp) {
        this.outdisp=dedisp;
    }


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

    public void displayWheelFrame() {mview.showWheelFrame();}

    public void displayPaintFrame() {mview.showPaintFrame();}

    public void displayEngineFrame() { mview.showEngineFrame();}

    public void displayTireFrame() {mview.showTireDisplay();}

    public void displayInnerFrame() {mview.showInnerDisplay();}

    public void displayOutterFrame() {mview.showOutterDisplay();}

    public String getId() {
        return this.id;
    }

    public void setId(String email) {
        this.id = email;
    }

    public List<Configuracao> getAllConfigs(String id){
        return this.carros.getAllConfigs(id);
    }

    public void addConfig(Configuracao a,String id){
        this.carros.adicionaConfig(id,a);
    }

    public Configuracao getConfig(String id,String nome){
        return this.carros.getConfig(id,nome);
    }

    public String getConfigNome(){
       return this.nomeConfig;
    }

    public void setNomeConfig(String a){
        this.nomeConfig = a;
    }

}
