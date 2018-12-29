package Items;

import java.util.Set;

public class Motor extends Item {
    private final int id = 2;
    private String combustivel;
    private int potencia;
    private int kilometragem;
    private int consumomedio;
    private int emissoesco2;
    private String tipo;

    public Motor() {
        super();
        this.combustivel=null;
        this.potencia=this.consumomedio=0;
        this.tipo=null;
    }

    public Motor(String tipo,String combustivel, int potencia,  int consumomedio,  float preco, Set<Integer> lista) {
        super(preco,lista);
        this.combustivel = combustivel;
        this.potencia = potencia;
        this.consumomedio = consumomedio;
        this.tipo = tipo;
    }

    public Motor (Motor m){
        super(m);
        this.combustivel = m.getCombustivel();
        this.potencia = m.getPotencia();
        this.consumomedio = m.getConsumomedio();

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


    public int getConsumomedio() {
        return consumomedio;
    }

    public void setConsumomedio(int consumomedio) {
        this.consumomedio = consumomedio;
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
                .append(" Consumo médio: ")
                .append(getConsumomedio() + "l/100km");
        return sb.toString();
    }

    public String getTipo(){
        return this.tipo;
    }

    public int getId(){
        return this.id;
    }

}
