package model;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private double valorInicial;
    private int idLeilao; // Referência ao leilão

    // Construtores
    public Produto(String nome, String descricao, double valorInicial, int idLeilao) {
        this.nome = nome;
        this.descricao = descricao;
        this.valorInicial = valorInicial;
        this.idLeilao = idLeilao;
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

    public int getIdLeilao() {
        return idLeilao;
    }

    public void setIdLeilao(int idLeilao) {
        this.idLeilao = idLeilao;
    }
}
