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
public class SychrozationThread1 implements Runnable{

    @Override
    public synchronized void run() {
       int i = 0;
        while (i<=5) {            
             System.out.println("Tao cũng yêu cả Ganyu nữa");
             i++;
             notify();
           try {
               Thread.sleep(1000);
           } catch (InterruptedException ex) {
               Logger.getLogger(SychrozationThread1.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    }
    
}
