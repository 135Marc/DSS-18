package DetalhesExteriores;

import java.util.Set;

public class ParachoquesMesmaCor extends DetalheExterior {

    private final String tipo = "Parachoques";

    public ParachoquesMesmaCor(){
        super();
    }
    public ParachoquesMesmaCor(float preco, Set<String> lista){
        super(preco, lista);
    }
    public ParachoquesMesmaCor(ParachoquesMesmaCor paraC){
        super(paraC);
    }
    @Override
    public String getTipo() {
        return this.tipo;
    }
    public DetalheExterior clone(){ return  new ParachoquesMesmaCor(this);}
}
