package DetalhesInteriores;

import java.util.HashSet;
import java.util.Set;

public abstract class DetalheInterior {

    private float preco;
    private Set<Integer> listaRestricao;

    public DetalheInterior(){
        this.preco = 0;
        this.listaRestricao = new HashSet<>();
    }

    public DetalheInterior(float preco,Set<Integer> lista){
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

    public Set<Integer> getListaRestricao() {
        Set<Integer> novaLista = new HashSet<>();
        novaLista.addAll(this.listaRestricao);
        return novaLista;    }

    public void setListaRestricao(Set<Integer> listaRestricao){
        this.listaRestricao = listaRestricao;
    }

    public abstract Integer getID();

    public  abstract DetalheInterior clone();

    public void addRestricao(Integer tipo){
        listaRestricao.add(tipo);
    }

    public void removeRestricao(Integer tipo){

        listaRestricao.remove(tipo);
    }

    public boolean hasID(Integer tipo){

        return listaRestricao.contains(tipo);
    }
}
