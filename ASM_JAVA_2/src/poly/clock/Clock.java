/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.clock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author buidu
 */
public class Clock implements Runnable{
    JLabel labelClock;

    public Clock(JLabel labelClock) {
        this.labelClock = labelClock;
    }

    @Override
    public void run() {
        while (true) {            
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss aa");
            labelClock.setText(sdf.format(now));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
