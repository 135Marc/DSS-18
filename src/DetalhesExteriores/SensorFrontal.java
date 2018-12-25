package DetalhesExteriores;

import java.util.Set;

public class SensorFrontal extends DetalheExterior {

    private final int tipo = 33;

    public SensorFrontal(){
        super();
    }
    public  SensorFrontal(float preco, Set<Integer> lista){
        super(preco,lista);
    }
    public SensorFrontal(SensorFrontal sensor){
        super(sensor);
    }

    @Override
    public Integer getTipo() {
        return this.tipo;
    }

    public DetalheExterior clone(){return new SensorFrontal(this);}
}
