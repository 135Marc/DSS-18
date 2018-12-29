package DetalhesInteriores;

import java.util.Set;

public class Estofos extends DetalheInterior {

    private final int id = 20;
    private String cor;
    private String tecido;
    private final String tipo = "Estofos";

    public  Estofos(){
        super();
        this.cor = "Branco";
        this.tecido = "Pele";
    }

    public Estofos(String tipo,String cor, String tecido, float preco, Set<Integer> lista){
        super(tipo,preco, lista);
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

    public Integer getID(){
        return  this.id;
    }

    public String getTipo() { return this.tipo;
    }
}
