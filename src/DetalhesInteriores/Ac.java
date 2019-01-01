package DetalhesInteriores;

import java.util.Set;

public class Ac extends DetalheInterior {

    private final int id = 22;
    private final String tipo = "Ar Condicionado";
    private boolean ePacote = false;

    public  Ac(){
        super();
    }

    public Ac(String tipo,float preco, Set<Integer> lista){
        super(tipo,preco,lista);
    }

    public Ac(Estofos gps){
        super(gps);
    }

    public Ac clone(){
        return new Ac();
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
