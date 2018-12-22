package DetalhesExteriores;

import java.util.Set;

public class CameraTraseira extends DetalheExterior {

    private final String tipo = "camera";

    public CameraTraseira(){
        super();
    }

    public CameraTraseira(float preco, Set<String> lista){
        super(preco,lista);
    }

    public CameraTraseira(CameraTraseira camera){
        super(camera);
    }

    @Override
    public String getTipo() {
        return this.tipo;
    }

    public DetalheExterior clone(){return  new CameraTraseira(this);}


}
