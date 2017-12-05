/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thomazerlach.cadastroprodutos;

/**
 *
 * @author thomazerlach
 */
public class Produto {
    private int id;
    private String nome;
    private String desc;
    private String marca;
    private double preco;
    private int idEstoque;

    public Produto() {
    }

    public Produto(int id, String nome, String desc, String marca, double preco, int idEstoque) {
        this.id = id;
        this.nome = nome;
        this.desc = desc;
        this.marca = marca;
        this.preco = preco;
        this.idEstoque = idEstoque;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    public int getIdEstoque() {
        return idEstoque;
    } 
}
