package aula03;

public class Aula03 {

    public static void main(String[] args) {

        Conta c1 = new Conta("Victor", "Xavier", "testecpf");
        c1.visualizarDados();
        //c1.titular.nome = "Victor";        private
        //c1.titular.sobrenome = "Xavier";   private
        //c1.titular.cpf = "12345678999";    private
        //c1.titular.visualizarCliente ();   private
        //Conta c2 = new Conta();
        //c2.visualizarSaldo();
        //c1.saldo = 1000;                   private
        //c1.visualizarSaldo();
        c1.depositar(1200);
        c1.visualizarSaldo();
        c1.sacar(500);
        c1.visualizarSaldo();
        //c2.transferirPara(c1, 200);
        //c1.visualizarSaldo();

    }

}
