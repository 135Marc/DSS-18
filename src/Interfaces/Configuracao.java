package Interfaces;


import DetalhesExteriores.DetalheExterior;
import DetalhesInteriores.DetalheInterior;
import Items.*;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

public class Configuracao implements Initializable {

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
        this.itemlist.add(i);
    }

    public Set<DetalheExterior> getOuterdetails() {
        return outerdetails;
    }

    public void addOuterDetail(DetalheExterior de) {
        this.outerdetails.add(de);
    }

    public Set<DetalheInterior> getInnerdetails() {
        return innerdetails;
    }

    public void addInnerDetail(DetalheInterior di) {
        this.innerdetails.add(di);
    }

    public void itemFrame() {
        this.mc.displayItemFrame();
    }



}
