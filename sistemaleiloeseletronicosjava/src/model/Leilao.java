package model;

import java.util.Date;

public class Leilao {
    private int id;
    private Date dataOcorrencia;
    private Date dataVisita;
    private String local;
    private String endereco;
    private String cidade;
    private String estado;
    private String descricao;
    private String status;

    // Construtor
    public Leilao(Date dataOcorrencia, Date dataVisita, String local, String endereco, String cidade, String estado, String descricao, String status) {
        this.dataOcorrencia = dataOcorrencia;
        this.dataVisita = dataVisita;
        this.local = local;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.descricao = descricao;
        this.status = status;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(Date dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public Date getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(Date dataVisita) {
        this.dataVisita = dataVisita;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


