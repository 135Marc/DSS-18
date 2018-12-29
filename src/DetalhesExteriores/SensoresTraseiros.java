package DetalhesExteriores;

import java.util.Set;

public class SensoresTraseiros extends DetalheExterior {

    private final int id = 32;
    private String tipo ;

    public SensoresTraseiros(){
        super();
        this.tipo = null;
    }

    public SensoresTraseiros(String tipo,float preco, Set<Integer> lista){
        super(preco,lista);
        this.tipo = tipo;
    }

    public SensoresTraseiros(SensoresTraseiros sensor){
        super(sensor);
    }

    @Override
    public Integer getID() {
        return this.id;
    }

    public DetalheExterior clone(){return new SensoresTraseiros(this);}

    @Override
    public String getTipo() {
        return tipo;
    }

}
