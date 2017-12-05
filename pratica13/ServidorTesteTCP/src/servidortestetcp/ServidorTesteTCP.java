/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidortestetcp;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author thomazerlach
 */
public class ServidorTesteTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //Instancia o ServerSocket
            ServerSocket servidor = new ServerSocket(4699);
            System.out.println("Servidor ouvindo a porta 4699");
            while (true) {
                //O metodo accept() bloqueia a execução
                // até o servidor receber um pedido de conexão
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
                
                PrintWriter out = new PrintWriter(cliente.getOutputStream(), true);
                out.println("Bem vindo seu ip é: " + cliente.getInetAddress().getHostAddress());
                
                Scanner in = new Scanner(cliente.getInputStream());
                //Scanner scan = new Scanner(System.in);
                //scan.nextLine();
                
                String s = in.nextLine();
                System.out.println(s);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
}
