package Items;

import java.util.Set;

public class Motor extends Item {
    private final int id = 2;
    private int potencia;
    private int consumomedio;
    private String tipo;
    private boolean ePacote = false;

    public Motor() {
        super();
        this.potencia=this.consumomedio=0;
        this.tipo=null;
    }

    public Motor(String tipo, int potencia,  int consumomedio,  float preco, Set<Integer> lista) {
        super(preco,lista);
        this.potencia = potencia;
        this.consumomedio = consumomedio;
        this.tipo = tipo;
    }

    public Motor (Motor m){
        super(m);
        this.potencia = m.getPotencia();
        this.consumomedio = m.getConsumomedio();

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
                sb.append(" Potência: ")
                .append(getPotencia()+ " cv")
                .append(" Consumo médio: ")
                .append(getConsumomedio() + "l/100km");
        return sb.toString();
    }

    public String getTipo(){
        return this.tipo;
    }

    public int getId(){ return this.id; }

    @Override
    public boolean getEPacote() {
        return this.ePacote;
    }

    @Override
    public void setPacote() {
        this.ePacote = !this.ePacote;
    }

}
