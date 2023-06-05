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
public class SynchrozationThread2 implements Runnable{

    @Override
    public synchronized void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Lmao");
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(SynchrozationThread2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
}
