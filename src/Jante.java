package Items;

public class Jante {
    private String tipo;
    private int espessura;

    public Jante() {
        this.tipo=null;
        this.espessura=0;
    }

    public Jante(Jante js) {
        this.tipo = js.getTipo();
        this.espessura= js.getEspessura();
    }

    public Jante(String tipo, int espessura) {
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
        sb.append("Tipo: ")
                .append(getTipo())
                .append(" Espessura: ")
                .append(getEspessura())
                .append("''");
                return sb.toString();
    }

    public boolean equals(Jante j) {
        return (this.tipo.equalsIgnoreCase(j.getTipo()) && this.espessura==j.getEspessura());
    }
}
