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
public class Produtos {
    private int id;
    private String nome;
    private String desc;
    private String marca;
    private double preco;
    private int quant;

    public Produtos() {
    }

    public Produtos(int id, String nome, String desc, String marca, double preco, int quant) {
        this.id = id;
        this.nome = nome;
        this.desc = desc;
        this.marca = marca;
        this.preco = preco;
        this.quant = quant;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }
    
    
}
