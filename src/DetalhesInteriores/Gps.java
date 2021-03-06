package DetalhesInteriores;

import java.util.Set;

public class Gps extends DetalheInterior{
    private final int id = 21;
    private final String tipo="GPS";
    private boolean ePacote = false;

    public  Gps(){
        super();
    }

    public Gps(String tipo,float preco,Set<Integer>lista){
        super(tipo,preco,lista);
    }

    public Gps(Estofos gps){
        super(gps);
    }

    public Gps clone(){
        return new Gps();
    }

    public Integer getID(){
        return  this.id;
    }

    public String getTipo() { return this.tipo;}

    @Override
    public boolean getEPacote() {
        return this.ePacote;
    }

    @Override
    public void setPacote() {
        this.ePacote = !this.ePacote;
    }
}
