package Items;

public class Pintura {
    private int cor;
    private String tipo;

    public Pintura() {
        this.cor=0;
        this.tipo=null;
    }

    public Pintura(int cor, String tipo) {
        this.cor = cor;
        this.tipo = tipo;
    }

    public Pintura (Pintura p) {
        this.cor = p.getCor();
        this.tipo = p.getTipo();
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" Cor : " + this.cor + " Tipo de pintura : " + this.tipo + "\n");
        return sb.toString();
    }

    public boolean equals(Pintura p) {
        return (this.cor == p.getCor() && this.tipo.equalsIgnoreCase(p.getTipo()));
    }

    public Pintura clone () {
        return new Pintura(this);
    }
}