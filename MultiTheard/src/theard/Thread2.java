/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theard;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  Đây sẽ là cmt đầu tiên của tôi về lý thuyết
 * 1.Có hai cách tạo thread  1 là implement Runable 2 là extends Thread
 * 
 */
public class Thread2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0;true; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
    
}
