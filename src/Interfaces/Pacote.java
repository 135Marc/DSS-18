package Interfaces;

import DetalhesExteriores.DetalheExterior;
import DetalhesInteriores.DetalheInterior;
import Items.Item;

import java.util.HashSet;
import java.util.Set;

public class Pacote {

    private  float preco;
    private Set<DetalheInterior> detsInterior;
    private Set<Item> itens;
    private Set<DetalheExterior> detsExterior;
    private String tipo;

    public Pacote(){
        this.detsInterior = new HashSet<>();
        this.detsExterior = new HashSet<>();
        this.itens = new HashSet<>();
        this.tipo = null;
    }

    public Pacote (String tipo,Set<Item> itens,Set<DetalheInterior> detsInterior,Set<DetalheExterior> detsExterior){
        this.detsExterior=detsExterior;
        this.itens = itens;
        this.detsInterior = detsInterior;
        this.tipo = tipo;
    }

    public void setPreco(){
        float nPreco = 0;

        for(DetalheExterior a :detsExterior){
            nPreco = nPreco+a.getPreco();
        }

        for(DetalheInterior a :detsInterior){
            nPreco = nPreco+a.getPreco();
        }

        for(Item a :itens){
            nPreco = nPreco+a.getPreco();
        }

        this.preco= (float) (nPreco*0.8);
    }

    public float getPreco(){
        setPreco();
        return this.preco;
    }

    public Set<Item> getItens(){
        return this.itens;
    }

    public Set<DetalheInterior> getDetsInterior() {
        return this.detsInterior;
    }

    public Set<DetalheExterior> getDetsExterior() {
        return this.detsExterior;
    }

    public String getTipo() {
        return tipo;
    }

    public void addDetInterior(DetalheInterior di) {
            this.detsInterior.add(di);
    }
    public void addDetExterior(DetalheExterior di) {
        this.detsExterior.add(di);
    }
    public void addItem(Item di) {
        this.itens.add(di);
    }
}
