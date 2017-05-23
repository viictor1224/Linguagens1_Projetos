//Victor Xavier   15.01027-9
//Pedro Cattel    15.01288-3

package atividade1;

public class Dinheiro {

    private double valor;
    private double cotacao; // Contação? O que é essa variavel?
    private double saldo; // apenas o atributo valor era necessario, se é saldo ou limite isso devera ser definido na classe Conta()
    private double limite;// apenas o atributo valor era necessario, se é saldo ou limite isso devera ser definido na classe Conta()
    String moeda;
    // para que serve essas variaveis chamadas: ral, dolar e euro?
    String real;
    String dolar;
    String euro;
    //Existia a necessidade de apenas duas taxas de conversão
    //e elas deveriam ser static***
    private double taxaEuroDolar = 1.0812;
    private double taxaRealDolar = 0.325;
    private double taxaEuroReal = 3.33;
    private double taxaDolarReal = 3.08;
    private double taxaRealEuro = 0.3;
    private double taxaDolarEuro = 0.9249;

    
    /* Onde estão as funções valorEmReal, valorEmDolar, valorEmEuro ???*/
    /* Onde está o construtor?*/
    
    public void realParaDolar(double valor) {
        this.valor = this.valor * taxaRealDolar;
    }

    public void dolarParaReal(double valor) {
        this.valor = this.valor * taxaDolarReal;
    }

    public void realParaEuro(double valor) {
        this.valor = this.valor * taxaRealEuro;
    }

    public void euroParaReal(double valor) {
        this.valor = this.valor * taxaEuroReal;
    }

    public void euroParaDolar(double valor) {
        this.valor = this.valor * taxaEuroDolar;
    }

    public void dolarParaEuro(double valor) {
        this.valor = this.valor * taxaDolarEuro;
    }

    public double getTaxaRealDolar() {
        return this.taxaRealDolar;
    }

    public double getTaxaRealEuro() {
        return this.taxaRealEuro;
    }

    public double getTaxaDolarReal() {
        return this.taxaDolarReal;
    }

    public double getTaxaDolarEuro() {
        return this.taxaDolarEuro;
    }

    public double getTaxaEuroReal() {
        return this.taxaEuroReal;
    }

    public double getTaxaEuroDolar() {
        return this.taxaEuroDolar;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public String getMoeda() {
        return this.moeda;
    }

    public void alterarTaxaRealDolar(double cotacao) {
        this.taxaRealDolar = cotacao;
    }

    public void alterarTaxaRealEuro(double cotacao) {
        this.taxaRealEuro = cotacao;
    }

    public void alterarTaxaEuroDolar(double cotacao) {
        this.taxaEuroDolar = cotacao;
    }

    public void alterarTaxaEuroReal(double cotacao) {
        this.taxaEuroReal = cotacao;
    }

    public void alterarTaxaDolarEuro(double cotacao) {
        this.taxaDolarEuro = cotacao;
    }

    public void alterarTaxaDolarReal(double cotacao) {
        this.taxaDolarReal = cotacao;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public double getLimite() {
        return this.limite;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
