/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contadorsimples;

/**
 *
 * @author thomazerlach
 */
public class Programa1 implements Runnable{
    
    private int id = 1;
    
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("Programa " + id + " valor: " + i);
        }
    }
}
