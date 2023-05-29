/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multitheard;
import theard.Thread1;
import theard.Thread2;
/**
 *
 * @author buidu
 */
public class Main {
    public static void main(String[] args) {
        Thread th1 = new Thread(new Thread1());
        Thread th2 = new Thread(new Thread2());
        th1.start();
        th2.start();
    }
}
