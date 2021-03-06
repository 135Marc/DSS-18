package DetalhesExteriores;

import java.util.Set;

public class TetoAbrir extends DetalheExterior {

    private final int id = 34;
    private String tipo;
    private boolean ePacote = false;

    public TetoAbrir(){
        super();
        this.tipo = null;
    }

    public TetoAbrir(String tipo,float preco, Set<Integer> lista){
        super(preco, lista);
        this.tipo = tipo;
    }

    public  TetoAbrir(TetoAbrir teto){
        super(teto);
    }

    @Override
    public Integer getID() {
        return this.id;
    }

    public  DetalheExterior clone(){return new TetoAbrir(this);}

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public boolean getEPacote() {
        return this.ePacote;
    }

    @Override
    public void setPacote() {
        this.ePacote = !this.ePacote;
    }
}
