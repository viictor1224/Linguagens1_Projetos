/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroaluno;

/**
 *
 * @author thomazerlach
 */
public class Person {
    
    private String Nome;
    private String Idade;
    private String Endereco;
    private String Rg;
    private String Cpf;
    
    public Person(){
        this.setNome("");
        this.setIdade("");
        this.setEndereco("");
        this.setRg("");
        this.setCpf("");
    }
    
    public Person(String nome, String idade, String endereco, String rg, String cpf){
        this.setNome(nome);
        this.setIdade(idade);
        this.setEndereco(endereco);
        this.setRg(rg);
        this.setCpf(cpf);
    }

    public String getNome() {
        return Nome;
    }
    
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getIdade() {
        return Idade;
    }
    
    public void setIdade(String Idade) {
        this.Idade = Idade;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getRg() {
        return Rg;
    }

    public void setRg(String Rg) {
        this.Rg = Rg;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }
    
    @Override
    public String toString() {
        return "Student [nome=" + Nome + ", idade=" + Idade
                + ", endereco=" + Endereco + ", rg=" + Rg + ", cpf="
                + Cpf + "]";
    }
    
}
