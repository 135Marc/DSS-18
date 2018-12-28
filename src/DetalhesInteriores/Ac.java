package DetalhesInteriores;

import java.util.Set;

public class Ac extends DetalheInterior {

    private final int id = 22;

    public  Ac(){
        super();
    }

    public Ac(float preco, Set<Integer> lista){
        super(preco,lista);
    }

    public Ac(Estofos gps){
        super(gps);
    }

    public Ac clone(){
        return new Ac();
    }

    public Integer getID(){
        return  this.id;
    }
}
