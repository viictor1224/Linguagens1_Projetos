package exercicio3;

public abstract class Funcionario {

    protected String nomeCompleto;
    protected String cpf;
    protected int registro;
    protected double salarioBase;
//    protected double horasExtras;    
//    protected double totalVendas;
//    protected static double taxaVendaTotais;
//    protected static int totalFuncionarios;

    public Funcionario(String n, String c, int reg, double salario) {
        this.setNomeCompleto(n);
        this.setCpf(c);
        this.setRegistro(reg);
        this.setSalarioBase(salario);

    }

    public abstract double calcularBonus(double individual);

    public double getSalarioBase() {
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

    public double calcularDecimoTerceiro() {
        return this.salarioBase;
    }

    public double calcularFerias() {
        return (4 / 3) * this.salarioBase;
    }
    
        public void exibirResumo() {
        System.out.println("Nome completo: " + this.nomeCompleto);
        System.out.println("Cpf: " + this.cpf);
        System.out.println("Registro: " + this.registro);
        System.out.println("Salário do mês: " + this.salarioBase);
    }

//    public double getHorasExtras() {
//        return this.horasExtras;
//    }
//
//    public final void setHorasExtras(double newHorasExtras) {
//        this.horasExtras = newHorasExtras;
//    }
//
//    public double calcularComissao() {
//        return totalVendas * Vendedor.taxaComissao;
//    }
}
