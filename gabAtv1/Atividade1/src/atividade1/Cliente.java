/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade1;

/**
 *
 * @author Note-Tiago
 */
public class Cliente {
    // atributos
    private String cpf;
    private String nome;
    private String sobrenome;
    private int idade;
    
    
    //Constructor
    public Cliente(String nome,String s, int idade, String cpf){
        this.nome = nome;
        this.sobrenome = s;
        this.idade = idade;
        this.cpf = cpf;
    }
    
    
    // Setters
    private void setNome(String n){
        this.nome = n;
    }
    
    private void alterarCpf(String cpf){
        this.cpf = cpf;
    }
    
    private void setSobrenome(String n){
        this.sobrenome = n;
    }
    
    private void setIdade(int n){
        this.idade = n;
    }
    
    //Getters
    public String getNome(){
        return this.nome;
    }
    
    public String getCpf(){
        return this.cpf;
    }
    
    public String getSobrenome(){
        return this.sobrenome;
    }
    
    public int getIdade(){
        return this.idade;
    }
}
