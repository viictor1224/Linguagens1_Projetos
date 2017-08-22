/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exwrapper;

import java.util.ArrayList;

public class ExWrapper {

    public static void main(String[] args) {

        ArrayList<String> lista = new ArrayList<>();
        ArrayList<String> lista2 = new ArrayList<>();

        lista.add("número 1");
        lista.add("número 2");
        lista.add("número 3");
        printList(lista);
        
        lista.add(1, "número 2.5");
        lista.set(2, "número super2");
        printList(lista);
        
        lista.remove(1);
        printList(lista);
        
        lista2.add("original lista 2 - 1");
        lista2.add("original lista 2 - 2");
        lista2.add("original lista 2 - 3");
        lista2.addAll(lista);
        printList(lista2);
    }

    public static void printList(ArrayList<String> arrayLista) {

        System.out.println("========= Inicio Lista =========");

        for (int i = 0; i < arrayLista.size(); i++) {
            System.out.println(arrayLista.get(i));
        }
        System.out.println("================================");
    }

}
