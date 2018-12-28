package DetalhesExteriores;

import java.util.Set;

public class Parachoques extends DetalheExterior {

    private final int id = 31;

    public Parachoques(){
        super();
    }
    public Parachoques(float preco, Set<Integer> lista){
        super(preco, lista);
    }
    public Parachoques(Parachoques paraC){
        super(paraC);
    }
    @Override
    public Integer getID() {
        return this.id;
    }
    public DetalheExterior clone(){ return  new Parachoques(this);}
}
