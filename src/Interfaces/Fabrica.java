package Interfaces;

import DetalhesExteriores.DetalheExterior;
import DetalhesInteriores.DetalheInterior;
import Items.Item;
import javafx.scene.control.Alert;

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
        if (stock.containsKey(idComp)) {
            stock.put(idComp, stock.get(idComp) + numero);
        }
        else
            stock.put(idComp,numero);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Iformação");
        alert.setHeaderText("Stock adicionado");
        alert.showAndWait();
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
            if(!stock.containsKey(i.getId())){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informação");
                alert.setHeaderText("Não existe stock, tem de adicionar antes de processar encomenda");
                alert.showAndWait();
                return false;
            }

            else if(stock.get(i.getId()) == 0)
                return false;
        }
        for(DetalheInterior d : a.getInnerdetails()){
            if(!stock.containsKey(d.getID())){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informação");
                alert.setHeaderText("Não existe stock, tem de adicionar antes de processar encomenda");
                alert.showAndWait();
                return false;
            }
            if(stock.get(d.getID()) == 0)
                return false;
        }
        for(DetalheExterior det : a.getOuterdetails()){

            if(!stock.containsKey(det.getID())){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informação");
                alert.setHeaderText("Não existe stock, tem de adicionar antes de processar encomenda");
                alert.showAndWait();
                return false;
            }
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
