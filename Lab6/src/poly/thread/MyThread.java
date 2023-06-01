/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author buidu
 */
public class MyThread implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
