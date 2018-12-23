package Items;

import java.util.Set;

public class Motor extends Item {
    private String combustivel;
    private int potencia;
    private int kilometragem;
    private int consumomedio;
    private int emissoesco2;
    private String tipo;

    public Motor() {
        super();
        this.combustivel=null;
        this.potencia=this.kilometragem=this.consumomedio=this.emissoesco2=0;
    }

    public Motor(String combustivel, int potencia, int kilometragem, int consumomedio, int emissoesco2, float preco, Set<String> lista) {
        super(preco,lista);
        this.combustivel = combustivel;
        this.potencia = potencia;
        this.kilometragem = kilometragem;
        this.consumomedio = consumomedio;
        this.emissoesco2 = emissoesco2;
    }

    public Motor (Motor m){
        super(m);
        this.combustivel = m.getCombustivel();
        this.potencia = m.getPotencia();
        this.kilometragem = m.getKilometragem();
        this.consumomedio = m.getConsumomedio();
        this.emissoesco2 = m.getEmissoesco2();
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(int kilometragem) {
        this.kilometragem = kilometragem;
    }

    public int getConsumomedio() {
        return consumomedio;
    }

    public void setConsumomedio(int consumomedio) {
        this.consumomedio = consumomedio;
    }

    public int getEmissoesco2() {
        return emissoesco2;
    }

    public void setEmissoesco2(int emissoesco2) {
        this.emissoesco2 = emissoesco2;
    }

    public Motor clone() {
        return new Motor(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Combustível: ")
                .append(getCombustivel())
                .append(" Potência: ")
                .append(getPotencia()+ " cv")
                .append(" Kilometragem: ")
                .append(getKilometragem() + " km")
                .append(" Consumo médio: ")
                .append(getConsumomedio() + "l/100km")
                .append(" Emissões CO2: ")
                .append(getEmissoesco2() + "g/km");
        return sb.toString();
    }

    public String getTipo(){
        return this.tipo;
    }

}
