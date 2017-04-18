package exercicio3;

public class Concessionaria {

    public static int totalFuncionarios;
    protected static double totalVendas;
    public static double individual;

    public void bonificacaoConcessionaria(int totalFuncionarios, double totalVendas) {
        this.individual = 0.05 * (this.totalVendas / this.totalFuncionarios);
    }

}
