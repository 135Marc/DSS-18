package DetalhesExteriores;

import java.util.HashSet;
import java.util.Set;

public abstract class DetalheExterior {
    private float preco;
    private Set<Integer> listaRestricao;

    public DetalheExterior(){
        this.preco = 0;
        this.listaRestricao = new HashSet<>();
    }

    public DetalheExterior(float preco,Set<Integer> lista){
        this.preco = preco;
        this.listaRestricao = lista;
    }

    public DetalheExterior(DetalheExterior det){
        this.preco = det.getPreco();
        this.listaRestricao = det.getListaRestricao();
    }

    public float getPreco() {
        return preco;
    }

    public Set<Integer> getListaRestricao() {
        Set<Integer> novaLista = new HashSet<>();
        novaLista.addAll(this.listaRestricao);
        return novaLista;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setListaRestricao(Set<Integer> listaRestricao) {
        this.listaRestricao = listaRestricao;
    }

    public void addRestricao(Integer tipo){
        listaRestricao.add(tipo);
    }

    public abstract Integer getID();

    public void removeRestricao(Integer tipo){
        listaRestricao.remove(tipo);
    }

    public boolean hasID(Integer tipo){
        return listaRestricao.contains(tipo);
    }

    public abstract DetalheExterior clone();


}
