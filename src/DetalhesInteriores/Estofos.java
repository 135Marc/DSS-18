package DetalhesInteriores;

import java.util.Set;

public class Estofos extends DetalheInterior {

    private final int tipo = 20;
    private String cor;
    private String tecido;

    public  Estofos(){
        super();
        this.cor = "Branco";
        this.tecido = "Pele";
    }

    public Estofos(String cor, String tecido, float preco, Set<Integer> lista){
        super(preco, lista);
        this.cor = cor;
        this.tecido = tecido;
    }

    public Estofos(Estofos est){
        super(est);
        this.cor = est.getCor();
        this.tecido = est.tecido;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTecido() {
        return tecido;
    }

    public void setTecido(String tecido) {
        this.tecido = tecido;
    }

    public Estofos clone(){
        return new Estofos(this);
    }

    public Integer getTipo(){
        return  this.tipo;
    }
}
