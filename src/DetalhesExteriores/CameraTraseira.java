package DetalhesExteriores;

import java.util.HashSet;
import java.util.Set;

public class CameraTraseira extends DetalheExterior {

    private final int tipo = 30;

    public CameraTraseira(){
        super();
    }

    public CameraTraseira(float preco, Set<Integer> lista){
        super(preco,lista);
    }

    public CameraTraseira(CameraTraseira camera){
        super(camera);
    }

    @Override
    public Integer getTipo() {
        return this.tipo;
    }

    public DetalheExterior clone(){return  new CameraTraseira(this);}


}
