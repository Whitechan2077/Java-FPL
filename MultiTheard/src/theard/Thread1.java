/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theard;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author buidu
 */
public class Thread1 implements Runnable{

    @Override
    public void run() {
        while (true) {
            SimpleDateFormat sfm = new SimpleDateFormat();
            sfm.applyPattern("hh:mm:ss");
            Date now = new Date();
            System.out.println(now);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
    }
    
}
