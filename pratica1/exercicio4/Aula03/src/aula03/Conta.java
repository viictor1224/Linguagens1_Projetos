package aula03;

public class Conta {

    int numero;
    double saldo;
    Cliente titular;

    void visualizarSaldo() {
        System.out.println("Saldo = " + this.saldo);
    }

    void depositar(double valor) {
        if (valor > 0) {
            this.saldo = this.saldo + valor;
        }
    }

    boolean sacar(double valor) {

        if (valor <= this.saldo) {
            this.saldo = this.saldo - valor;
            return true;
        } else {
            return false;
        }
    }

    boolean transferirPara(Conta c1, double valor) {

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
