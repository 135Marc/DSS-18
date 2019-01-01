package DetalhesExteriores;

import java.util.Set;

public class Parachoques extends DetalheExterior {

    private final int id = 31;
    private String tipo;
    private boolean ePacote=false;

    public Parachoques(){
        super();
        this.tipo=null;
    }
    public Parachoques(String tipo,float preco, Set<Integer> lista){
        super(preco, lista);
        this.tipo = tipo;
    }
    public Parachoques(Parachoques paraC){
        super(paraC);
    }
    @Override
    public Integer getID() {
        return this.id;
    }

    public DetalheExterior clone(){ return  new Parachoques(this);}

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
