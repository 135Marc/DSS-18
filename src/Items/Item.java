package Items;

import java.util.HashSet;
import java.util.Set;

public abstract class Item {
    private double preco;
    private Set<String> listaRestricao;

    public Item(){
        this.preco = 0;
        this.listaRestricao = new HashSet<>();
    }
    public Item(double preco,Set<String> lista){
        this.preco = preco;
        this.listaRestricao = lista;
    }

    public Item(Item a){
        this.preco = a.getPreco();
        this.listaRestricao = a.getListaRestricao();
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public Set<String> getListaRestricao() {
        Set<String> lista = new HashSet<>();
        for(String a : this.listaRestricao){
            lista.add(a);
        }
        return  lista;
    }

    public void setListaRestricao(Set<String> lista){
        this.listaRestricao = lista;
    }

    abstract String getTipo();
}
