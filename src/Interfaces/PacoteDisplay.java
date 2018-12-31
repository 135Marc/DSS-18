package Interfaces;

import DetalhesExteriores.*;
import DetalhesInteriores.Ac;
import DetalhesInteriores.DetalheInterior;
import Items.Item;
import Items.Jante;
import Items.Motor;
import Items.Pneu;
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
        Set<Integer> listaRestricap = new HashSet<Integer>();
        listaRestricap.add(1);
        Jante j = new Jante("Desportiva",10,100,listaRestricap);
        Set<Integer> mRest = new HashSet<Integer>();
        mRest.add(2);
        Motor m = new Motor("Motos Desportivo",2500,10,1000,mRest);
        Set<Integer> pRest = new HashSet<Integer>();
        pRest.add(4);
        Pneu p = new Pneu(10,10,10,10,"x","borracha","Pneu Desportivo",500,pRest);
        Set<Integer> cameraTraseira = new HashSet<Integer>();
        Set<Integer> tetoAbrir = new HashSet<Integer>();
        Set<Integer> vidrosFumados = new HashSet<Integer>();
        cameraTraseira.add(30);
        cameraTraseira.add(32);
        tetoAbrir.add(34);
        vidrosFumados.add(35);
        CameraTraseira cam = new CameraTraseira("Camera Traseira",75,cameraTraseira);
        TetoAbrir teto = new TetoAbrir("Teto abrir",200,tetoAbrir);
        VidrosFumados vidro = new VidrosFumados("Vidro Fumados",250,tetoAbrir);
        Set<Integer> acs = new HashSet<Integer>();
        acs.add(22);
        Ac ar = new Ac("Ar condicionado",100,acs);
        pac.addItem(j);
        pac.addItem(m);
        pac.addItem(p);
        pac.addDetExterior(cam);
        pac.addDetExterior(teto);
        pac.addDetExterior(vidro);
        pac.addDetInterior(ar);
        if(mc.isSportPac() == false) {
            mc.setSportPac(pac);
        }
        this.mc.displayPacoteTableFrame();
    }

    public void pacoteConfort(){
        Pacote pac = new Pacote();
        Set<Integer> listaRestricap = new HashSet<Integer>();
        listaRestricap.add(1);
        Jante j = new Jante("Larga",15,125,listaRestricap);
        Set<Integer> mRest = new HashSet<Integer>();
        mRest.add(2);
        Motor m = new Motor("Motor Elétrico",2000,7,8500,mRest);
        Set<Integer> pRest = new HashSet<Integer>();
        pRest.add(4);
        Pneu p = new Pneu(13,12,11,14,"Z","R","Pneu Estrada",500,pRest);
        Set<Integer> cameraTraseira = new HashSet<Integer>();
        Set<Integer> sensorFrontal = new HashSet<Integer>();
        cameraTraseira.add(30);
        cameraTraseira.add(32);
        sensorFrontal.add(33);
        sensorFrontal.add(31);
        CameraTraseira cam = new CameraTraseira("Camera Traseira",75,cameraTraseira);
        SensorFrontal sensor = new SensorFrontal("Sensor Frontal",100,sensorFrontal);
        Set<Integer> acs = new HashSet<Integer>();
        acs.add(22);
        Ac ar = new Ac("Ar condicionado",100,acs);
        pac.addItem(j);
        pac.addItem(m);
        pac.addItem(p);
        pac.addDetExterior(cam);
        pac.addDetExterior(sensor);
        pac.addDetInterior(ar);
        if(mc.isConfortPac() == false){
            mc.setConforPac(pac);
        }
        this.mc.displayPacoteConfortTableFrame();
    }
}
