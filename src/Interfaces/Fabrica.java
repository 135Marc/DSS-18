package Interfaces;

import DetalhesExteriores.DetalheExterior;
import DetalhesInteriores.DetalheInterior;
import Items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Fabrica {

    private HashMap<Integer,Integer> stock;
    private List<Configuracao> configsSubmetidas;

    public Fabrica (){
        this.stock = new HashMap<>();
        this.configsSubmetidas = new ArrayList<>();
    }

    public void addConfig(Configuracao a){
        this.configsSubmetidas.add(a);
    }

    public void addStock(int idComp, int numero){
        stock.put(idComp,stock.get(idComp)+numero);
    }

    public void consomeStock(Configuracao a){

        for(Item i : a.getItemlist()){
            stock.put(i.getId(),stock.get(i.getId())-1);
        }
        for(DetalheInterior d : a.getInnerdetails()){
            stock.put(d.getID(),stock.get(d.getID())-1);
        }
        for(DetalheExterior det : a.getOuterdetails()){
            stock.put(det.getID(),stock.get(det.getID())-1);
        }
    }

    public boolean stockDisponivelParaCOnfig(Configuracao a){

        for(Item i : a.getItemlist()){
            if(stock.get(i.getId()) == 0)
                return false;
        }
        for(DetalheInterior d : a.getInnerdetails()){
            if(stock.get(d.getID()) == 0)
                return false;
        }
        for(DetalheExterior det : a.getOuterdetails()){
            if(stock.get(det.getID()) == 0)
                return false;
        }
        return true;
    }

    public List<Configuracao> allconfigs(){
        return this.configsSubmetidas;
    }

    public void removeConfig(Configuracao a){
        this.configsSubmetidas.remove(a);
    }
}
