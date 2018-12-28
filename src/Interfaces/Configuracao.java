package Interfaces;


import DetalhesExteriores.DetalheExterior;
import DetalhesInteriores.DetalheInterior;
import Items.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

public class Configuracao implements Initializable {


    @FXML
    private TableView<Pintura> cart;

    private String nome;
    private float preco;
    private Set<Item> itemlist;
    private Set<DetalheExterior> outerdetails;
    private Set<DetalheInterior> innerdetails;
    private  MainController mc;
    private MainView main;


    public Configuracao () {
        this.nome=null;
        this.preco = 0;
        this.itemlist=null;
        this.innerdetails=null;
        this.outerdetails=null;
    }

    public Configuracao(String nome, float preco, Set<Item> itemlist, Set<DetalheExterior> outerdetails, Set<DetalheInterior> innerdetails) {
        this.nome = nome;
        this.preco = preco;
        this.itemlist = itemlist;
        this.outerdetails = outerdetails;
        this.innerdetails = innerdetails;
    }

    public Configuracao(Configuracao cfg) {
        this.nome = cfg.getNome();
        this.preco = cfg.getPreco();
        this.itemlist= cfg.getItemlist();
        this.outerdetails = cfg.getOuterdetails();
        this.innerdetails = cfg.getInnerdetails();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TableColumn<Pintura,String> tc3 = new TableColumn<>("Cor");
        TableColumn<Pintura,String> tc4 = new TableColumn<>("Tipo");
        tc3.setCellValueFactory(new PropertyValueFactory<>("cor"));
        tc4.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tc3.setPrefWidth(97);
        tc4.setPrefWidth(102);
        cart.getColumns().addAll(tc3,tc4);
    }


    public void setMainController(MainController mc) {
        this.mc = mc;
    }

    public void init(MainView mv) {
        this.main = mv;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public Set<Item> getItemlist() {
        return itemlist;
    }

    public void addItem(Item i) {
        if(itemValido(i))
         this.itemlist.add(i);
    }


    public Set<DetalheExterior> getOuterdetails() {
        return outerdetails;
    }

    public void addOuterDetail(DetalheExterior de) {
        if(detExteriorValido(de))
            this.outerdetails.add(de);
    }

    public Set<DetalheInterior> getInnerdetails() {
        return innerdetails;
    }

    public void addInnerDetail(DetalheInterior di) {
        if(detInteriorValido(di))
            this.innerdetails.add(di);
    }

    public void itemFrame() { //NULL POINTER
        this.mc.displayItemFrame();
    }

    public void turnBack() { //NULL POINTER
        this.mc.displayConfigManager();
    }

    public boolean itemValido(Item i){

        for(Item a : itemlist){
            if(i.idRestrito(a.getId()) || a.idRestrito(i.getId())){
                return false;
            }
        }
        return true;
    }

    public boolean detExteriorValido(DetalheExterior i){

        for(DetalheExterior a : outerdetails){
            if(a.hasID(i.getID()) || i.hasID(a.getID())){
                return false;
            }
        }
        return true;
    }

    public boolean detInteriorValido(DetalheInterior i){

        for(DetalheInterior a : innerdetails){
            if(a.hasID(i.getID()) || i.hasID(a.getID())){
                return false;
            }
        }
        return true;
    }


}
