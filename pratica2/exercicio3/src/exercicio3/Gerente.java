package exercicio3;

public class Gerente extends Funcionario {

    private static double taxaComissao = 0.05;
    protected static double taxaExtraSalario = 0.25;
    private double vendas = 0;
    private String senha;
    private int vendedores;

    public Gerente(String n, String c, int reg, double salario) {
        super(n, c, reg, salario);
    }

    @Override
    public final double calcularBonus(double bIndividual) {
        return this.vendas * Gerente.taxaComissao + bIndividual + this.salarioBase * Gerente.taxaExtraSalario;
    }

    public double remuneracaoFinal( double bIndividual) {
        return this.calcularBonus(bIndividual) + this.salarioBase;        
    }

    public double salarioMes() {
        return this.salarioBase + this.vendas * Gerente.taxaComissao;
    }

    public double getVendas() {
        return this.vendas;
    }

//    public boolean darAumento(Vendedor vend, double aumento, String senha) {
//        if (vend.getGerente().equalsIgnoreCase(this.getNomeCompleto())) {
//            if (senha.equalsIgnoreCase(this.senha)) {
//                vend.setSalarioBase(vend.getSalarioBase() * (1 + aumento));
//                return true;
//            } else {
//                return false;
//            }
//        } else {
//            return false;
//        }
//    }

}
