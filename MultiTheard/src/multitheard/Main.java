/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multitheard;
import theard.Thread1;
import theard.Thread2;
/**
 *
 * 
 */
public class Main {
    public static void main(String[] args) {
        //1.Có hai cách tạo thread  1 là implement Runable 2 là extends Thread
        Thread th1 = new Thread(new Thread1());
        Thread th2 = new Thread(new Thread2());
        th1.start();
        th2.start();
        
        //2.thread nặc danh một thred mà không phải tạo một class mới 
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Tao dang la thread nặc danh ");
            }
        }).start();
    }
}
