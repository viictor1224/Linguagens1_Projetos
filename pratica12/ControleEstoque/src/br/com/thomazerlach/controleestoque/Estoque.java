/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thomazerlach.controleestoque;

/**
 *
 * @author thomazerlach
 */
public class Estoque {
    private int id;
    private String nome;
    private String marca;
    private int quant;

    public Estoque() {
    }

    public Estoque(int id, String nome, String marca, int quant) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }
}
