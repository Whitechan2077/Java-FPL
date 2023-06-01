/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.thread;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author buidu
 */
public class LotteryThread implements Runnable{
    private JTextField txtNumber;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
             int randomNumber = (int) Math.round( Math.random()*9);
             txtNumber.setText(String.valueOf(randomNumber));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(LotteryThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
