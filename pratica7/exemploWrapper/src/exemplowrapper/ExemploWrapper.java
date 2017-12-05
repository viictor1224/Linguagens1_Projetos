/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplowrapper;

import java.util.ArrayList;

/**
 *
 * @author thomazerlach
 */
public class ExemploWrapper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<String> lista = new ArrayList<String>();
        ArrayList<String> lista2 = new ArrayList<String>();
        
        lista.add("numero 1");
        lista.add("numero 2");
        lista.add("numero 3");
        lista.add("numero 4");
        printList(lista);
        
        lista.add(1, "numero 2.5");
        lista.set(2, "numero super 2");
        printList(lista);
        
        lista.remove(1);
        printList(lista);
      
        lista2.add("original lista 2 - 1");
        lista2.add("original lista 2 - 2");
        lista2.add("original lista 2 - 2");
        lista2.addAll(1,lista);
        printList(lista2);
        
        
    }
    
    public static void printList(ArrayList<String> arrayLista) {
        System.out.println("==========Inicio Lista=========");
        for (int i = 0; i < arrayLista.size(); i++) {
            System.out.println(arrayLista.get(i));
        }
        System.out.println("===============================");
    }
    
}
