package Items;

import java.util.Set;

public class Pintura extends Item {
    private final int id = 3;
    private String cor;
    private String tipo;
    private boolean ePacote =false;

    public Pintura() {
        super();
        this.cor=this.tipo=null;
    }

    public Pintura(String cor, String tipo, float preco, Set<Integer> lista) {
        super(preco,lista);
        this.cor = cor;
        this.tipo = tipo;
    }

    public Pintura (Pintura p) {
        super(p);
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

    @Override
    public boolean getEPacote() {
        return this.ePacote;
    }

    @Override
    public void setPacote() {
        this.ePacote = !this.ePacote;
    }
}
