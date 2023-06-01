/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.bai1;
import poly.thread.MyThread;
/**
 *
 * @author buidu
 */
public class Bai1 {
    public static void main(String[] args) throws InterruptedException {
        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();
        Thread th1 = new Thread(mt1);
        Thread th2 = new Thread(mt2);
        th1.start();
        th1.join();
        th2.start();
    }
}
