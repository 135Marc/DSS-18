package Interfaces;


import DetalhesExteriores.DetalheExterior;
import DetalhesInteriores.DetalheInterior;
import Items.*;
import java.util.Set;

public class Configuracao {

    private String nome;
    private float preco;
    private Set<Item> itemlist;
    private Set<DetalheExterior> outerdetails;
    private Set<DetalheInterior> innerdetails;


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
