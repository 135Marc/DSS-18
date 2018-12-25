package DetalhesExteriores;

import java.util.Set;

public class ParachoquesMesmaCor extends DetalheExterior {

    private final int tipo = 31;

    public ParachoquesMesmaCor(){
        super();
    }
    public ParachoquesMesmaCor(float preco, Set<Integer> lista){
        super(preco, lista);
    }
    public ParachoquesMesmaCor(ParachoquesMesmaCor paraC){
        super(paraC);
    }
    @Override
    public Integer getTipo() {
        return this.tipo;
    }
    public DetalheExterior clone(){ return  new ParachoquesMesmaCor(this);}
}
