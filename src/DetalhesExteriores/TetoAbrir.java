package DetalhesExteriores;

import java.util.Set;

public class TetoAbrir extends DetalheExterior {

    private final int tipo = 34;

    public TetoAbrir(){
        super();
    }

    public TetoAbrir(float preco, Set<Integer> lista){
        super(preco, lista);
    }

    public  TetoAbrir(TetoAbrir teto){
        super(teto);
    }

    @Override
    public Integer getTipo() {
        return this.tipo;
    }

    public  DetalheExterior clone(){return new TetoAbrir(this);}
}
