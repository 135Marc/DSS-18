package DetalhesExteriores;

import java.util.Set;

public class VidrosFumados extends DetalheExterior {

    private final int id = 35;

    public VidrosFumados(){
        super();
    }

    public  VidrosFumados(float preco, Set<Integer> lista){
        super(preco,lista);
    }

    public VidrosFumados(VidrosFumados vidro){
        super(vidro);
    }

    @Override
    public Integer getID() {
        return this.id;
    }

    public DetalheExterior clone(){return new VidrosFumados(this);}
}
