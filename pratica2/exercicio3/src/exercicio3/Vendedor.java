package exercicio3;

public class Vendedor extends Funcionario {

    //private String nomeCompleto;
    //private String cpf;
    //private int registro;
    //private double salarioBase;
    //HERDADOS
    protected static double taxaComissao = 0.03;
    private double vendas = 0;
    protected double horasExtras;
    private Gerente gerente;

    public Vendedor(String n, String c, int reg, double salario) {
        super(n, c, reg, salario);
    }

    public double salarioMes() {
        return this.salarioBase + this.vendas * Vendedor.taxaComissao + this.horasExtras;
    }

    @Override
    public double calcularBonus(double bIndividual) {
        return this.vendas * Vendedor.taxaComissao + bIndividual;
    }

    public void realizarVenda(double valorVenda) {
        if (valorVenda > 0) {
            this.vendas += valorVenda;
        }
    }

    public double getVendas() {
        return this.vendas;
    }
    
    public double remuneracaoFinal( double bIndividual) {
        return this.calcularBonus(bIndividual) + this.salarioBase;        
    }

    @Override
    public void exibirResumo() {
        super.exibirResumo();
        System.out.println("Vendas: " + this.vendas);
    }
}
