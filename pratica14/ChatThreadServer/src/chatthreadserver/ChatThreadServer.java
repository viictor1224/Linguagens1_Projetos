/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatthreadserver;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
/**
 *
 * @author thomazerlach
 */
public class ChatThreadServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            //Instancia o ServerSocket
            ServerSocket servidor = new ServerSocket(4699);
            System.out.println("Servidor ouvindo a porta 4699");
            System.out.println("Esperando um cliente...");
            
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
               
            try ( 
                    Scanner entradaRede = new Scanner(cliente.getInputStream());
                    Scanner teclado = new Scanner(System.in);
                    PrintStream saidaRede = new PrintStream(cliente.getOutputStream());
                ) 
            {
                saidaRede.println("Bem vindo ao chat!");
                System.out.println(entradaRede.nextLine());
                String msg = "";
                while (!msg.equalsIgnoreCase("tchau!")) {
                    msg = teclado.nextLine();
                    saidaRede.println(msg);
                    msg = entradaRede.nextLine();
                    System.out.println(msg);
                }
                System.out.println("Aplicação finalizada. Pressione ENTER");
                teclado.nextLine();
                servidor.close();
                cliente.close();
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.exit(0);
    }
    
}
