/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multitheard;
import theard.Thread1;
import theard.Thread2;
/**
 *
 * Đây sẽ là cmt đầu tiên của tôi về lý thuyết
 * 1.Có hai cách tạo thread  1 là implement Runable 2 là extends Thread
 * 2 thread nặc danh là thực hiện một thread mà không cần phải tạo class mới
 * 3.
 */
public class Main {
    public static void main(String[] args) {
        //các thread thông thường
        Thread th1 = new Thread(new Thread1());
        Thread th2 = new Thread(new Thread2());
        th1.start();
        th2.start();
        //thread nặc danh
        new Thread(new Runnable() {
            @Override
            public void run() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        }).start();
    }
}
