package br.com.store.mystore.model;

import java.time.LocalDate;

public class Produto {

    private int codigo;
    private String nome;
    private double valor;
    private int quantidade;
    private LocalDate dataFabricacao;
    private Categoria categoria;


    public Produto() {}

    public Produto(int codigo, String nome, double valor, int quantidade, LocalDate dataFabricacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.dataFabricacao = dataFabricacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
