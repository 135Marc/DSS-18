package DetalhesExteriores;

import java.util.Set;

public class VidrosFumados extends DetalheExterior {

    private final int id = 35;
    String tipo;
    private boolean ePacote=false;

    public VidrosFumados(){
        super();
        this.tipo = null;
    }

    public  VidrosFumados(String tipo,float preco, Set<Integer> lista){
        super(preco,lista);
        this.tipo = tipo;
    }

    public VidrosFumados(VidrosFumados vidro){
        super(vidro);
    }

    @Override
    public Integer getID() {
        return this.id;
    }

    public DetalheExterior clone(){return new VidrosFumados(this);}

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
