package DetalhesExteriores;

import java.util.Set;

public class SensoresTraseiros extends DetalheExterior {

    private final int tipo = 32;

    public SensoresTraseiros(){
        super();
    }

    public SensoresTraseiros(float preco, Set<Integer> lista){
        super(preco,lista);
    }

    public SensoresTraseiros(SensoresTraseiros sensor){
        super(sensor);
    }

    @Override
    public Integer getTipo() {
        return this.tipo;
    }

    public DetalheExterior clone(){return new SensoresTraseiros(this);}

}
