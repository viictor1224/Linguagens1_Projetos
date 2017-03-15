package aula03;

public class Conta {

    private int numero;
    private double saldo;
    private Cliente titular;

    public Conta(int numero,String nome,String sobrenome,String cpf) {
        this.numero = numero;
        
        this.titular = new Cliente();
        this.titular.nome = nome;
        this.titular.sobrenome = sobrenome;
        this.titular.cpf = cpf;
        
    }

    public void visualizarSaldo() {
        System.out.println("Saldo = " + this.saldo);
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo = this.saldo + valor;
        }
    }

    public boolean sacar(double valor) {

        if (valor <= this.saldo) {
            this.saldo = this.saldo - valor;
            return true;
        } else {
            return false;
        }
    }

    public boolean transferirPara(Conta c1, double valor) {

        if (this.sacar(valor)) {
            c1.depositar(valor);
            System.out.println("Transferencia efetuada.");
            return true;
        } else {
            System.out.println("Transferencia nao efetuada");
            return false;
        }
    }

}
