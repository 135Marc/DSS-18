package Items;

import java.util.Set;

public class Pneu extends Item{
    private final int id = 4;
    private String tipo;
    private int largura;
    private String serie;
    private String construcao;
    private int diametrointerior;
    private int indexcarga;
    private int indexvel;
    private boolean ePacote = false;

    public Pneu() {
        super();
        this.largura=0;
        this.serie=null;
        this.construcao=null;
        this.diametrointerior=this.indexcarga=this.indexvel=0;
    }

    public Pneu(int largura,  int diametrointerior, int indexcarga, int indexvel , String serie, String construcao,String tipo, float preco, Set<Integer> lista) {
        super(preco,lista);
        this.largura = largura;
        this.serie = serie;
        this.construcao = construcao;
        this.tipo = tipo;
        this.indexcarga = indexcarga;
        this.indexvel = indexvel;
        this.diametrointerior=diametrointerior;
    }

    public Pneu(Pneu p) {
        super(p);
        this.largura=p.getLargura();
        this.serie=p.getSerie();
        this.construcao=p.getConstrucao();
        this.tipo = p.getTipo();
        this.diametrointerior = p.getDiametrointerior();
        this.indexcarga=p.getIndexcarga();
        this.indexvel=p.getIndexvel();
    }

    public int getDiametrointerior() {
        return diametrointerior;
    }

    public void setDiametrointerior(int diametrointerior) {
        this.diametrointerior = diametrointerior;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public void setTipo (String tipo) {
        this.tipo = tipo;
    }

    public String getConstrucao() {
        return construcao;
    }

    public void setConstrucao(String construcao) {
        this.construcao = construcao;
    }

    public int getIndexcarga() {
        return indexcarga;
    }

    public void setIndexcarga(int indexcarga) {
        this.indexcarga = indexcarga;
    }

    public int getIndexvel() {
        return indexvel;
    }

    public void setIndexvel(int indexvel) {
        this.indexvel = indexvel;
    }

    public Pneu clone() {
        return new Pneu(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getLargura())
                .append("/")
                .append(this.getSerie())
                .append(" " + this.getConstrucao() + " ")
                .append(this.getDiametrointerior() + " ")
                .append(this.getIndexcarga())
                .append(" " + this.getIndexcarga() + " ")
                .append(this.getIndexvel());
        return sb.toString();
    }

    public String getTipo(){
        return this.tipo;
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
