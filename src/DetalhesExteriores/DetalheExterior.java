package DetalhesExteriores;

import java.util.HashSet;
import java.util.Set;

public abstract class DetalheExterior {
    private float preco;
    private Set<String> listaRestricao;

    public DetalheExterior(){
        this.preco = 0;
        this.listaRestricao = new HashSet<>();
    }

    public DetalheExterior(float preco,Set<String> lista){
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

    public Set<String> getListaRestricao() {
        Set<String> novaLista = new HashSet<>();
        novaLista.addAll(this.listaRestricao);
        return novaLista;
    }

    public void setPreco(float preco) {
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

    public boolean hasID(String tipo){
        return listaRestricao.contains(tipo);
    }

    public abstract DetalheExterior clone();


}
