package DetalhesExteriores;

import java.util.Set;

public class SensorFrontal extends DetalheExterior {

    private final String tipo = "SensorFrontal";

    public SensorFrontal(){
        super();
    }
    public  SensorFrontal(float preco, Set<String> lista){
        super(preco,lista);
    }
    public SensorFrontal(SensorFrontal sensor){
        super(sensor);
    }

    @Override
    public String getTipo() {
        return this.tipo;
    }

    public DetalheExterior clone(){return new SensorFrontal(this);}
}
