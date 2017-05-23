//Victor Xavier   15.01027-9
//Pedro Cattel    15.01288-3
package atividade1;

public class Conta {

    private int numero;
    private double saldo; // saldo deveria ser do tipo Dinheiro, ou nao existir se esta usando outra variavel
    private Cliente titular;
    private Dinheiro capital;
    private String agencia;
    private String cc;
    private String novonome; // ???
    private String novosobrenome; // ???
    private String novocpf; // ???

    public Conta(String nome, String sobrenome, String cpf, String moeda, double saldo, double limite) {

        this.titular = new Cliente();
        this.titular.setNome(nome);
        this.titular.setSobrenome(sobrenome);
        this.titular.setCpf(cpf);
        this.capital = new Dinheiro();
        this.capital.setMoeda(moeda);
        this.capital.setSaldo(saldo); 
        this.capital.setLimite(limite);                
    }

    public void exibirTodasInformacoesDaConta() {
        System.out.println(this.titular.getNome() + " " + this.titular.getSobrenome() + ", " + this.titular.getCpf());
        System.out.println("Ele(a) está com o saldo de "+this.capital.getSaldo()+" "+this.capital.getMoeda()+" na conta");
        System.out.println("Possui um limite de "+this.capital.getLimite()+" "+this.capital.getMoeda());
    }

    public void exibirTitular() {
        this.titular.visualizarCliente();
    }

    public void exibirSaldo() {
        System.out.println("Saldo = " + this.capital.getSaldo());
    }

    // verificação de moeda e conversão?
    // Se esta usando o saldo e limite aqui, por que seu processamento na classe Dinheiro é em cima do atributo valor?
    public void depositar(double valor) {

        if (valor > 0) {
            this.capital.setSaldo(this.capital.getSaldo() + valor);
        }
    }

    // Se esta usando o saldo e limite aqui, por que seu processamento na classe Dinheiro é em cima do atributo valor?
    public boolean sacar(double valor) {

        if (valor <= this.capital.getSaldo()) {
            this.capital.setSaldo(this.saldo - valor);
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

    public void alterarNome(String novonome) {
        this.titular.setNome(novonome);
    }

    public void alterarSobrenome(String novosobrenome) {
        this.titular.setSobrenome(novosobrenome);
    }

    public void alterarCPF(String novocpf) {
        this.titular.setCpf(novocpf);
    }

}
