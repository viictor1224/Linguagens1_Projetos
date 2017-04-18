package exercicio3;

public class Gerente extends Funcionario {

    //private String nomeCompleto;
    //private String cpf;
    //private int registro;
    private static double taxaComissao = 0.05;
    //private double horasExtras;
    //private double salarioBase;
    //private double totalVendas;
    private String senha;
    private int vendedores;

    public Gerente(String n, String c, int reg, double salario) {
        super(n, c, reg, salario);
    }
    
    public double calcularBonus(double individual) {
        return this.totalVendas * Gerente.taxaComissao + individual;
    }

    public double salarioMes() {
        return this.salarioBase + this.totalVendas * Gerente.taxaComissao + this.horasExtras;
    }

    public boolean darAumento(Vendedor vend, double aumento, String senha) {
        if (vend.getGerente().equalsIgnoreCase(this.getNomeCompleto())) {
            if (senha.equalsIgnoreCase(this.senha)) {
                vend.setSalarioBase(vend.getSalarioBase() * (1 + aumento));
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
