package DetalhesExteriores;

import java.util.Set;

public class SensorFrontal extends DetalheExterior {

    private final int id = 33;
    private String tipo;

    public SensorFrontal(){
        super();
        this.tipo = null;
    }
    public  SensorFrontal(String tipo,float preco, Set<Integer> lista){
        super(preco,lista);
        this.tipo = tipo;
    }

    public SensorFrontal(SensorFrontal sensor){
        super(sensor);
    }

    @Override
    public Integer getID() {
        return this.id;
    }

    public DetalheExterior clone(){return new SensorFrontal(this);}

    @Override
    public String getTipo() {
        return tipo;
    }


}

