/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excecao;

/**
 *
 * @author Aluno 18
 */
public class Excecao {

    /**
     * @param args the command line arguments
     */
    // TODO code application logic here
    public static void main(String[] args) {
        System.out.println("inicio do main");
        metodo1();
        System.out.println("fim do main");
    }

    static void metodo1() {
        System.out.println("inicio do metodo1");
        metodo2();
        System.out.println("fim do metodo1");
    }

    static void metodo2() throws ArrayIndexOutOfBoundsException{
        System.out.println("inicio do metodo2");
        int[] array = new int[10];

        for (int i = 0; i <= 15; i++) {
            try {
                array[i] = i;
                System.out.println(i);

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Meu erro + " + e);
            }
            System.out.println("fim do metodo2");
        }
    }
    
}
