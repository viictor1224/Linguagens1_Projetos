/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatthreadclient;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author thomazerlach
 */
public class ChatThreadClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String serverAddress = JOptionPane.showInputDialog(
                "Informe o IP do servidor que está\n" 
                + "executando o serviço de chat na porta 4699");
        
        try {
            Socket cliente = new Socket(serverAddress, 4699);
            
            try (
                    Scanner entradaRede = new Scanner(cliente.getInputStream());
                    Scanner teclado = new Scanner(System.in);
                    PrintStream saidaRede = new PrintStream(cliente.getOutputStream());
                ) 
            {
                System.out.println(entradaRede.nextLine());
                String msg = "";
                while(!msg.equalsIgnoreCase("tchau!")) {
                    msg = teclado.nextLine();
                    saidaRede.println(msg);
                    msg = entradaRede.nextLine();
                    System.out.println(msg);
                }
                System.out.println("Aplicação finalizada. Pressione ENTER para fechar o programa.");
                teclado.nextLine();
                cliente.close();
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.exit(0);
    }
    
}
