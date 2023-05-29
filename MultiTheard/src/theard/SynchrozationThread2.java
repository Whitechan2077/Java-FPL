/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theard;

/**
 *
 * @author buidu
 */
public class SynchrozationThread2 implements Runnable{

    @Override
    public synchronized void run() {
        System.out.println("Tao thích Mahiro");
    }
    
}
