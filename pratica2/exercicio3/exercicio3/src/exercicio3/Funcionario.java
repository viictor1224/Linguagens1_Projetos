package exercicio3;

public class Funcionario {

    protected String nomeCompleto;
    protected String cpf;
    protected int registro;
    protected double horasExtras;
    protected double salarioBase;
    protected double totalVendas;
    protected static double taxaVendaTotais;
//    protected static int totalFuncionarios;

    public Funcionario(String n, String c, int reg, double salario) {
        this.setNomeCompleto(n);
        this.setCpf(c);
        this.setRegistro(reg);
        this.setSalarioBase(salario);

    }

    public double calcularBonus(double individual) {
        return individual;   

    public double getSalarioBase(){
        return this.salarioBase;
    }

    public void setSalarioBase(double newSalario) {
        this.salarioBase = newSalario;
    }

    public String getNomeCompleto() {
        return this.nomeCompleto;
    }

    public void setNomeCompleto(String newNomeCompleto) {
        this.nomeCompleto = newNomeCompleto;
    }

    public String getCpf() {
        return this.cpf;
    }
    
    public String getGerente() {
        return this.gerente.getNomeCompleto();
    }

    public final void setCpf(String newCpf) {
        this.cpf = newCpf;
    }

    public int getRegistro() {
        return this.registro;
    }

    public final void setRegistro(int newRegistro) {
        this.registro = newRegistro;
    }

    public double getTaxaComissao() {
        return Vendedor.taxaComissao;
    }

    public void setTaxaComissao(double newTaxaComissao) {
        Vendedor.taxaComissao = newTaxaComissao;
    }

    public double getHorasExtras() {
        return this.horasExtras;
    }

    public final void setHorasExtras(double newHorasExtras) {
        this.horasExtras = newHorasExtras;
    }

    public boolean contabilizarVenda(double venda) {
        if (venda > 0) {
            this.totalVendas = this.totalVendas + venda;
            return true;
        } else {
            return false;
        }
    }

    public double calcularComissao() {
        return totalVendas * Vendedor.taxaComissao;
    }

    public double calcularDecimoTerceiro() {
        return this.salarioBase;
    }

    public double calcularFerias() {
        return (4 / 3) * this.salarioBase;
    }

}
