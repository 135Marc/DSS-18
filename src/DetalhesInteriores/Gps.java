package DetalhesInteriores;

import java.util.Set;

public class Gps extends DetalheInterior{
    private final int id = 21;

    public  Gps(){
        super();
    }

    public Gps(float preco,Set<Integer>lista){
        super(preco,lista);
    }

    public Gps(Estofos gps){
        super(gps);
    }

    public Gps clone(){
        return new Gps();
    }

    public Integer getID(){
        return  this.id;
    }
}
