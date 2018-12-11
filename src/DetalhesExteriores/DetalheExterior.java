package DetalhesExteriores;

import java.util.HashSet;
import java.util.Set;

public abstract class DetalheExterior {
    private double preco;
    private Set<String> listaRestricao;

    public DetalheExterior(){

        this.preco = 0;
        this.listaRestricao = new HashSet<>();
    }

    public DetalheExterior(double preco,Set<String> lista){

        this.preco = preco;
        this.listaRestricao = lista;
    }

    public DetalheExterior(DetalheExterior det){
        this.preco = det.getPreco();
        this.listaRestricao = det.getListaRestricao();
    }

    public double getPreco() {
        return preco;
    }

    public Set<String> getListaRestricao() {
        Set<String> novaLista = new HashSet<>();

        for(String a : this.listaRestricao){
            novaLista.add(a);
        }

        return novaLista;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setListaRestricao(Set<String> listaRestricao) {
        this.listaRestricao = listaRestricao;
    }

    public void addRestricao(String tipo){
        listaRestricao.add(tipo);
    }

    public abstract String getTipo();

    public void removeRestricao(String tipo){

        listaRestricao.remove(tipo);
    }

    public boolean contemid(String tipo){

        return listaRestricao.contains(tipo);
    }

    public abstract DetalheExterior clone();


}
