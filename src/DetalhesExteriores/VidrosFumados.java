package DetalhesExteriores;

import java.util.Set;

public class VidrosFumados extends DetalheExterior {

    private final String tipo = "VidrosFumados";

    public VidrosFumados(){
        super();
    }

    public  VidrosFumados(float preco, Set<String> lista){
        super(preco,lista);
    }

    public VidrosFumados(VidrosFumados vidro){
        super(vidro);
    }

    @Override
    public String getTipo() {
        return this.tipo;
    }

    public DetalheExterior clone(){return new VidrosFumados(this);}
}
