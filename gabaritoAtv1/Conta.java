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
public class Conta 
{
    //variaveis
    private int agencia;
    private int cc;
    private Cliente titular;
    private double saldo;
    private double limite;
    
    
    //Contructor
    public Conta(String n, String s, int i, String c){
        this.saldo = 0;
        this.titular = new Cliente(n,s,i,c);
        
        
        
    }
    
    
    //setters
    private void setTitular(Cliente C){
        this.titular = C;
    }
    
    private void setAgencia(int n){
       
    }
    
    private int getAgencia(){
        
    }
    
    private void setCc(int n){
        
    }
    
    private int getCc(){
       
    }   
    
    //getters
    public void visualizarSaldo ()
    {
        System.out.println("Saldo: "+ this.saldo + " BRL");
    }
    
    
    //metodos
    
    public void visualizarConta(){
        System.out.println("Titular: " + this.titular.getNome() + " " + this.titular.getSobrenome());
        System.out.println("CPF: " + this.titular.getCpf());
        System.out.println("Agecia: "+ this.agencia + " cc:" + this.cc);
        this.visualizarSaldo();
    }
    
    //valor sempre em real
    public boolean depositar (double valor)
    {
        if(valor >= 0)
        {
            this.saldo = this.saldo + valor;
            return true;
        }
        else
        {
            System.out.println("Operacao Invalida.");
            return false;
        }
    }
    
    //valor sempre em real
    public boolean sacar (double valor)
    {
        if(valor > 0 && valor <= this.saldo)
        {
           
            return true;
                }
        else
        {
            System.out.println("Operacao Invalida, nao ha saldo suficiente.");
            return false;
        }
    }
    
    //valor sempre em real
    public boolean transferirDinheiro (Conta conta, double valor)
    {
            if (this.sacar(valor))
            {
                
                System.out.println("Transferencia OK");
                return conta.depositar(valor);
            }
            else
                return false;
    }
}