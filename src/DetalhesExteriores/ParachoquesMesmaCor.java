package DetalhesExteriores;

import java.util.Set;

public class ParachoquesMesmaCor extends DetalheExterior {

    private final String tipo = "Parachoques";

    public ParachoquesMesmaCor(){
        super();
    }
    public ParachoquesMesmaCor(double preco, Set<String> lista){
        super(preco, lista);
    }
    public ParachoquesMesmaCor(ParachoquesMesmaCor paraC){
        super(paraC);
    }
    @Override
    public String getTipo() {
        return this.tipo;
    }

}
