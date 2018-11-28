package Items;

public class Pneu {
    private int largura;
    private String serie;
    private String construcao;
    private int diametrointerior;
    private int indexcarga;
    private int indexvel;

    public Pneu() {
        this.largura=0;
        this.serie=null;
        this.construcao=null;
        this.diametrointerior=this.indexcarga=this.indexvel=0;
    }

    public Pneu(int largura, String serie, String construcao, int diametrointerior,int indexcarga, int indexvel) {
        this.largura = largura;
        this.serie = serie;
        this.construcao = construcao;
        this.indexcarga = indexcarga;
        this.indexvel = indexvel;
        this.diametrointerior=diametrointerior;
    }

    public Pneu(Pneu p) {
        this.largura=p.getLargura();
        this.serie=p.getSerie();
        this.construcao=p.getConstrucao();
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
}
