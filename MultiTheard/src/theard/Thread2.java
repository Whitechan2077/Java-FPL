/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theard;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author buidu
 */
public class Thread2 implements Runnable{

    @Override
    public void run() {
        while (true) {            
            System.out.println("Them bu lon");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
