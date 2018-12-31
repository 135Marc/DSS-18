package Interfaces;

import DetalhesExteriores.DetalheExterior;
import DetalhesInteriores.DetalheInterior;
import Items.Item;
import Items.Motor;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

public class PacoteDisplay implements Initializable {

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

    public void voltar(){
        this.mc.displayConfigEditor();
    }

    public void pacoteSport() {

        Pacote pac = new Pacote();
        this.mc.displayPacoteTableFrame();}

    public void pacoteConfort(){

    }
}
