package DetalhesExteriores;

import java.util.Set;

public class TetoAbrir extends DetalheExterior {

    private final String tipo = "tetoAbrir";

    public TetoAbrir(){
        super();
    }

    public TetoAbrir(double preco, Set<String> lista){
        super(preco, lista);
    }

    public  TetoAbrir(TetoAbrir teto){
        super(teto);
    }

    @Override
    public String getTipo() {
        return this.tipo;
    }

    public  DetalheExterior clone(){return new TetoAbrir(this);}
}
