package model;

public class Dispositivo {
    private int id;
    private String descricao;
    private String marca;
    private String modelo;
    private String categoria; // Notebook, Monitor, etc.
    private double valorInicial;
    private int ano;

    // Construtor
    public Dispositivo(String descricao, String marca, String modelo, String categoria, double valorInicial, int ano) {
        this.descricao = descricao;
        this.marca = marca;
        this.modelo = modelo;
        this.categoria = categoria;
        this.valorInicial = valorInicial;
        this.ano = ano;
    }

    // Getters e Setters
    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getCategoria() { return categoria; }
    public double getValorInicial() { return valorInicial; }
    public int getAno() { return ano; }

    public void setId(int id) { this.id = id; }
}

