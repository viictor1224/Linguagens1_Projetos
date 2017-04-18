package exercicio3;

public class Vendedor extends Funcionario {

    //private String nomeCompleto;
    //private String cpf;
    //private int registro;
    //private double salarioBase;
    //private double totalVendas;
    protected static double taxaComissao = 0.03;
    protected double horasExtras;
    private Gerente gerente;

    public Vendedor(String n, String c, int reg, double salario) {
        super(n, c, reg, salario);
    }

    public double salarioMes() {
        return this.salarioBase + this.totalVendas * Vendedor.taxaComissao + this.horasExtras;
    }

    public double calcularBonus(double individual) {
        return this.totalVendas * Vendedor.taxaComissao + individual;
    }

    public void exibirResumo() {
        System.out.println("Nome completo: " + this.nomeCompleto);
        System.out.println("Cpf: " + this.cpf);
        System.out.println("Registro: " + this.registro);
        System.out.println("Salário do mês: " + this.salarioMes());
    }

}
