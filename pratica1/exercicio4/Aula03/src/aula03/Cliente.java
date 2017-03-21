package aula03;

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
