/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theard;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * 
 * 
 */
public class Thread2 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("lmao");
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    }
    
