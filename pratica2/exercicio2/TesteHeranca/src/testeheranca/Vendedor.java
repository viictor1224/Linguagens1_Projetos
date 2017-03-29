package testeheranca;

public class Vendedor {

    private String nomeCompleto;
    private String cpf;
    private int registro;
    private static double taxaComissao = 0.03;
    private double horasExtras;
    private double salarioBase;
    private double totalVendas;
    private Gerente gerente;
    
    public Vendedor (String n, String c, int reg, double salario, double hora, Gerente chefe){
        this.setNomeCompleto(n);
        this.setCpf(c);
        this.setRegistro(reg);
        this.setSalarioBase(salario);
        this.setHorasExtras(hora);
        this.gerente=chefe;
        
    }

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

    public void setCpf(String newCpf) {
        this.cpf = newCpf;
    }

    public int getRegistro() {
        return this.registro;
    }

    public void setRegistro(int newRegistro) {
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

    public void setHorasExtras(double newHorasExtras) {
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

    public double salarioMes() {
        return this.salarioBase + this.totalVendas * Vendedor.taxaComissao + this.horasExtras;
    }

    public void exibirResumo() {
        System.out.println("Nome completo: " + this.nomeCompleto);
        System.out.println("Cpf: " + this.cpf);
        System.out.println("Registro: " + this.registro);
        System.out.println("Salário do mês: " + this.salarioMes());
    }

}
