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



}
