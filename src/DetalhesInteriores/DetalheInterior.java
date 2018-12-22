package DetalhesInteriores;

import java.util.HashSet;
import java.util.Set;

public abstract class DetalheInterior {

    private float preco;
    private Set<String> listaRestricao;

    public DetalheInterior(){
        this.preco = 0;
        this.listaRestricao = new HashSet<>();
    }

    public DetalheInterior(float preco,Set<String> lista){
        this.preco = preco;
        this.listaRestricao = lista;
    }

    public DetalheInterior(DetalheInterior det){
        this.preco = det.getPreco();
        this.listaRestricao = det.getListaRestricao();
    }


    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getPreco(){
        return this.preco;
    }

    public Set<String> getListaRestricao() {
        Set<String> novaLista = new HashSet<>();
        novaLista.addAll(this.listaRestricao);
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

    public boolean hasID(String tipo){

        return listaRestricao.contains(tipo);
    }
}
