package Interfaces;

public class Carro {
    private String nome;
    private String tipo;
    private int numeroportas;
    private float preco;
    private Configuracao config;

    public Carro() {
        this.nome=this.tipo=null;
        this.numeroportas=0;
        this.preco=0;
        this.config=null;
    }

    public Carro(String nome, String tipo, int numeroportas, float preco, Configuracao config) {
        this.nome = nome;
        this.tipo = tipo;
        this.numeroportas = numeroportas;
        this.preco = preco;
        this.config = config;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumeroportas() {
        return numeroportas;
    }

    public void setNumeroportas(int numeroportas) {
        this.numeroportas = numeroportas;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Configuracao getConfig() {
        return config;
    }

    public void setConfig(Configuracao config) {
        this.config = config;
    }
}
