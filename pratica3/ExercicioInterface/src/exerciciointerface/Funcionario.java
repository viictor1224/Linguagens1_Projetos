package exerciciointerface;

public abstract class Funcionario {

    private String nome;
    private int registro;
    private double salario;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nomeNovo) {
        this.nome = nomeNovo;
    }

    public int getRegistro() {
        return this.registro;
    }

    public void setRegistro(int registroNovo) {
        this.registro = registroNovo;
    }

    public double getSalarioBase() {
        return this.salario;
    }

    public void setSalarioBase(double salarioNovo) {
        this.salario = salarioNovo;
    }

}
