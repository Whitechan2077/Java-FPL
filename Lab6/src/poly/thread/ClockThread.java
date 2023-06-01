/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

/**
 *
 * @author buidu
 */
public class ClockThread implements Runnable{
    private JToggleButton btnClock ;

    public ClockThread(JToggleButton btnClock) {
        this.btnClock = btnClock;
    }
    
    @Override
    public void run() {
        while(true){
        SimpleDateFormat sdm = new SimpleDateFormat("hh:mm:ss:aa");
        Date now = new Date();
        btnClock.setText(sdm.format(now));
        }
    }
}
