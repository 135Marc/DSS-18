package DetalhesExteriores;

import java.util.HashSet;
import java.util.Set;

public class CameraTraseira extends DetalheExterior {

    private final int id = 30;
    private String tipo;
    private boolean ePacote=false;

    public CameraTraseira(){
        super();
    }

    public CameraTraseira(String tipo,float preco, Set<Integer> lista){
        super(preco,lista);
        this.tipo = tipo;
    }

    public CameraTraseira(CameraTraseira camera){
        super(camera);
    }

    @Override
    public Integer getID() {
        return this.id;
    }

    public DetalheExterior clone(){return  new CameraTraseira(this);}

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
