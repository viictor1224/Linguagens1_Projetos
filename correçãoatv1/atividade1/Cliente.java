//Victor Xavier   15.01027-9
//Pedro Cattel    15.01288-3
package atividade1;

public class Cliente {

    private String nome;
    private String sobrenome;
    private String cpf;

    void visualizarCliente() {
        System.out.println(this.nome);
        System.out.println(this.sobrenome);
        System.out.println(this.cpf);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
    public String getSobrenome() {
        return this.sobrenome;
    }
    public String getCpf() {
        return this.cpf;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void mudarCPF(String cpf) {
        if (validarCPF(cpf)) {
            this.cpf = cpf;
        } else {
            System.out.println("Nao foi possivel alterar o CPF.");
        }
    }

    private boolean validarCPF(String cpf) {
        return true;
    }

}
