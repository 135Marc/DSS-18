package Items;

import java.util.Set;

public class Jante extends Item{
    private final int id = 1;
    private String tipo;
    private int espessura;

    public Jante() {
        super();
        this.tipo=null;
        this.espessura=0;
    }

    public Jante(Jante js) {
        super(js);
        this.tipo = js.getTipo();
        this.espessura= js.getEspessura();
    }

    public Jante(String tipo, int espessura,float preco,Set<Integer> lista){
        super(preco,lista);
        this.tipo = tipo;
        this.espessura = espessura;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEspessura() {
        return espessura;
    }

    public void setEspessura(int espessura) {
        this.espessura = espessura;
    }


    public Jante clone() {
        return new Jante(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Jantes Tipo: ")
                .append(getTipo())
                .append(" Espessura : ")
                .append(getEspessura())
                .append(" polegadas ");
                return sb.toString();
    }

    public boolean equals(Jante j) {
        return (this.tipo.equalsIgnoreCase(j.getTipo()) && this.espessura==j.getEspessura());
    }

    public int getId(){
        return this.id;
    }


}
