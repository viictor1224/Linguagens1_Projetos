package exercicio3;

import java.util.Scanner;

public class Exercicio3 {

    static Concessionaria conc;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //perguntar nVend e nGer
        System.out.println("Qual é o número máximo de vendedores?");
        int nVend = scan.nextInt();

        System.out.println("Qual é o número máximo de gerentes?");
        int nGer = scan.nextInt();

        conc = new Concessionaria(nVend, nGer);

        int cond = 0;
        do {
            System.out.println("Menu Concessionaria");
            System.out.println("1 - Inserir funcionarios");
            System.out.println("2 - Gerir funcionarios");
            System.out.println("3 - Realizar venda");
            System.out.println("4 - Exibir resumo");
            System.out.println("5 - Sair");

            int n = scan.nextInt();
            switch (n) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    cond = 1;
                    break;

            }
        } while (cond != 1);

    }

    private static void inserirF() {
        Scanner scan = new Scanner(System.in);
        int cond = 0;
        do {
            System.out.println("1 - Inserir Gerente");
            System.out.println("2 - Inserir Vendedor");
            System.out.println("3 - Voltar ao Menu");
            int n = scan.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Insira os dados do gerente (nome, cpf, registro e salario):");
                    String nome = scan.nextLine();
                    String cpf = scan.nextLine();
                    int reg = scan.nextInt();
                    double sal = scan.nextInt();
                    conc.novoGerente(nome, cpf, reg, sal);
                    break;

                case 2:
                    System.out.println("Insira os dados do vendedor (nome, cpf, registro e salario):");
                    String nm = scan.nextLine();
                    String cf = scan.nextLine();
                    int rg = scan.nextInt();
                    double sl = scan.nextInt();
                    conc.novoGerente(nm, cf, rg, sl);

                    break;
                case 3:
                    cond = 1;
                    break;

            }
        } while (cond != 1);

    }

}
