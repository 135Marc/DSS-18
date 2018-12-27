package Items;

public class Pintura {
    private final int id = 3;
    private String cor;
    private String tipo;

    public Pintura() {
        this.cor=this.tipo=null;
    }

    public Pintura(String cor, String tipo) {
        this.cor = cor;
        this.tipo = tipo;
    }

    public Pintura (Pintura p) {
        this.cor = p.getCor();
        this.tipo = p.getTipo();
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
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
        return (this.cor.equals(p.getCor()) && this.tipo.equalsIgnoreCase(p.getTipo()));
    }

    public Pintura clone () {
        return new Pintura(this);
    }

    public int getId(){
        return this.id;
    }
}
