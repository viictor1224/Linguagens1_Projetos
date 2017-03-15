package aula03;

public class Aula03 {

    public static void main(String[] args) {

        Conta c1 = new Conta(1234,"Victor","Xavier","12345678999");
        //c1.titular = new Cliente();
        //c1.titular.nome = "Victor";
        //c1.titular.sobrenome = "Xavier";
        //c1.titular.cpf = "12345678999";
        //c1.titular.visualizarCliente ();

        //Conta c2 = new Conta();
        //c2.saldo = 6500;
        //c2.visualizarSaldo();
        //c1.saldo = 1000;
        c1.visualizarSaldo();
        c1.depositar(200);
        c1.visualizarSaldo();
        c1.sacar(600);
        c1.visualizarSaldo();
        //c2.transferirPara(c1, 200);
        //c1.visualizarSaldo();

    }

}
