package DetalhesInteriores;

import java.util.HashSet;
import java.util.Set;

public abstract class DetalheInterior {

    private double preco;
    private Set<String> listaRestricao;

    public DetalheInterior(){
        this.preco = 0;
        this.listaRestricao = new HashSet<>();
    }

    public DetalheInterior(double preco,Set<String> lista){
        this.preco = preco;
        this.listaRestricao = lista;
    }

    public DetalheInterior(DetalheInterior det){
        this.preco = det.getPreco();
        this.listaRestricao = det.getListaRestricao();
    }


    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPreco(){
        return this.preco;
    }

    public Set<String> getListaRestricao() {
        Set<String> novaLista = new HashSet<>();

        for(String a : this.listaRestricao){
            novaLista.add(a);
        }

        return novaLista;    }

    public void setListaRestricao(Set<String> listaRestricao){
        this.listaRestricao = listaRestricao;
    }

    public abstract String getTipo();

    public  abstract DetalheInterior clone();

    public void addRestricao(String tipo){
        listaRestricao.add(tipo);
    }

    public void removeRestricao(String tipo){

        listaRestricao.remove(tipo);
    }

    public boolean contemid(String tipo){

        return listaRestricao.contains(tipo);
    }
}
