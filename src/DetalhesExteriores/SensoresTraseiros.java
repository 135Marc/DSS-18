package DetalhesExteriores;

import java.util.Set;

public class SensoresTraseiros extends DetalheExterior {

    private final String tipo = "SensoreTraseiro";

    public SensoresTraseiros(){

        super();
    }

    public SensoresTraseiros(double preco, Set<String> lista){

        super(preco,lista);
    }

    public SensoresTraseiros(SensoresTraseiros sensor){

        super(sensor);
    }

    @Override
    public String getTipo() {
        return this.tipo;
    }

}
