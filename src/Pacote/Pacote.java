package Pacote;

import DetalhesExteriores.DetalheExterior;
import DetalhesInteriores.DetalheInterior;
import Items.Item;

import java.util.HashSet;
import java.util.Set;

public abstract class Pacote {

    private  float preco;
    private Set<DetalheInterior> detsInterior;
    private Set<Item> itens;
    private Set<DetalheExterior> detsExterior;

    public Pacote(){
        this.detsInterior = new HashSet<>();
        this.detsExterior = new HashSet<>();
        this.itens = new HashSet<>();
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
        return this.preco;
    }

}
