/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thomazerlach.compraecommerce;

/**
 *
 * @author thomazerlach
 */
public class Carrinho {
    private int id;
    private String nome;
    private int quant;
    private double preco;
    private double total;

    public Carrinho() {
    }

    public Carrinho(int id, String nome, int quant, double preco, double total) {
        this.id = id;
        this.nome = nome;
        this.quant = quant;
        this.preco = preco;
        this.total = total;
    }

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

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
