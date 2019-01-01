package Interfaces;


import DetalhesExteriores.DetalheExterior;
import DetalhesInteriores.DetalheInterior;
import Items.*;

import java.util.ArrayList;
import java.util.List;
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
        if(itemValido(i)) {
            this.itemlist.add(i);
            this.preco += i.getPreco();
        }
    }

    public Set<DetalheExterior> getOuterdetails() {
        return outerdetails;
    }

    public void addOuterDetail(DetalheExterior de) {
        if(detExteriorValido(de)) {
            this.outerdetails.add(de);
            this.preco+=de.getPreco();
        }
    }

    public Set<DetalheInterior> getInnerdetails() {
        return innerdetails;
    }

    public void addInnerDetail(DetalheInterior di) {
        if(detInteriorValido(di)) {
            this.innerdetails.add(di);
            this.preco+=di.getPreco();
        }
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

    public void removeItem(Item a){
        this.itemlist.remove(a);
        this.preco-=a.getPreco();
    }

    public void removeDetExt(DetalheExterior a){
        this.getOuterdetails().remove(a);
        this.preco-=a.getPreco();
    }

    public void removeDetInt(DetalheInterior a){
        this.innerdetails.remove(a);
        this.preco-=a.getPreco();
    }

    public void addPacote(Pacote a){

        for(Item i :a.getItens()){
            List<Item> lista = getListaItensRestringe(i);
            for(Item b : lista) {
                removeItem(b);
            }
            i.setPreco((float) (i.getPreco()*0.8));
            i.setPacote();
            addItem(i);
        }

        for(DetalheInterior i : a.getDetsInterior()){
            List<DetalheInterior> listaInt = getListaDetsInteriorRestringe(i);
            for(DetalheInterior b : listaInt){
                removeDetInt(b);
            }
            i.setPreco((float) (i.getPreco()*0.8));
            i.setPacote();
            addInnerDetail(i);
        }

        for(DetalheExterior i : a.getDetsExterior()){
            List<DetalheExterior> listaExt = getListaDetsExteriRestringe(i);
            for(DetalheExterior b : listaExt){
                removeDetExt(b);
            }
            i.setPreco((float) (i.getPreco()*0.8));
            i.setPacote();
            addOuterDetail(i);
        }

        preco = preco+a.getPreco();
    }

    public void removePacote(Pacote a){
        for(Item i : a.getItens()){
            removeItem(i);
        }

        for(DetalheExterior i : a.getDetsExterior()){
            removeDetExt(i);
        }

        for(DetalheInterior i: a.getDetsInterior()){
            removeDetInt(i);
        }
    }

    public List<Item> getListaItensRestringe(Item i){
        List<Item> lista = new ArrayList<>();

        for(Item a : itemlist){
            if(i.idRestrito(a.getId())){
                lista.add(a);
            }
        }
        return lista;
    }

    public List<DetalheExterior> getListaDetsExteriRestringe(DetalheExterior i){
        List<DetalheExterior> lista = new ArrayList<>();

        for(DetalheExterior a : outerdetails){
            if(i.hasID(a.getID())){
                lista.add(a);
            }
        }
        return lista;
    }

    public List<DetalheInterior> getListaDetsInteriorRestringe(DetalheInterior i){
        List<DetalheInterior> lista = new ArrayList<>();

        for(DetalheInterior a : innerdetails){
            if(i.hasID(a.getID())){
                lista.add(a);
            }
        }
        return lista;
    }


}
