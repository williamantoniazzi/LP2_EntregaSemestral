package model;

public class Veiculo {

    private int id;
    private String nome;
    private String descricao;
    private double valorInicial;
    private String categoria; // Tipo do veículo: carro, caminhão, moto, etc.
    private int ano; // Ano de fabricação do veículo
    private int leilaoId; // ID do leilão associado

    // Construtores
    public Veiculo(String nome, String descricao, double valorInicial, String categoria, int ano, int leilaoId) {
        this.nome = nome;
        this.descricao = descricao;
        this.valorInicial = valorInicial;
        this.categoria = categoria;
        this.ano = ano;
        this.leilaoId = leilaoId;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getLeilaoId() {
        return leilaoId;
    }

    public void setLeilaoid(int leilaoId) {
        this.leilaoId = leilaoId;
    }
}
