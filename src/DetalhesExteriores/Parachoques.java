package DetalhesExteriores;

import java.util.Set;

public class Parachoques extends DetalheExterior {

    private final int tipo = 31;

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
    public Integer getTipo() {
        return this.tipo;
    }
    public DetalheExterior clone(){ return  new Parachoques(this);}
}
