package Items;

import DetalhesExteriores.DetalheExterior;

import java.util.HashSet;
import java.util.Set;

public abstract class Item {
    private float preco;
    private Set<String> listaRestricao;

    public Item(){
        this.preco = 0;
        this.listaRestricao = new HashSet<>();
    }
    public Item(float preco,Set<String> lista){
        this.preco = preco;
        this.listaRestricao = lista;
    }

    public Item(Item a){
        this.preco = a.getPreco();
        this.listaRestricao = a.getListaRestricao();
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco){
        this.preco = preco;
    }

    public Set<String> getListaRestricao() {
        Set<String> lista = new HashSet<>();
        lista.addAll(this.listaRestricao);
        return  lista;
    }

    public void setListaRestricao(Set<String> lista){
        this.listaRestricao = lista;
    }

    public abstract Item clone();

    public abstract String getTipo();
}
