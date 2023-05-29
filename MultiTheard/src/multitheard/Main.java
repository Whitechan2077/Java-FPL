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
    public static void main(String[] args) throws InterruptedException {
        //1.Có hai cách tạo thread  1 là implement Runable 2 là extends Thread 
        Thread th1 = new Thread(new Thread1());
        Thread th2 = new Thread(new Thread2());
        //Nhiều thread có thể có nhiều runnalbe
        //2.thread nặc danh một thred mà không phải tạo một class  
        Thread th3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Bố mày là thread nặc danh");
            }
        });
        th3.start();
        th3.join();
        th1.start();
        th2.start();
        /*
        các trang thái của thread 
        1. new tạo thread nhưng chưa có runnable
        2. ready tạo thread có runnable chờ được start();
        3. running thread đan chạy
        4. wait trạng thái chờ
        5.blocked bị chặn
        6.dead thread chết đừng hoạt động
        */
        
        
        
        /*
        Dộ ưu tiên (Prioriry)
        NORN_PRIORIRY (default)
        MIN_PRIORITY (MIN)
        MAX_PRIORITY (MAX)
        Khi tranh chấp thì sẽ ưu tiên PRIORITY cao
        join() đợi thread hoạt động xong thì sẽ khởi chạy thread tiếp theo
        */
        
        
        
        /*
        Đồng Bộ Hóa Thread 
        Nhiều thread chạy // => xung đột
        Sychronization => giải quyết vấn đề
        Sychrozation => xắp xếp thread để không xung đột dữ liệu
        
        Monitor công cụ giám sát thread
        Trong một thời điểm thì chỉ cố một thread vào được monitor
        Đưa được thread vào trong monitor thì cần có Synchrozation
        Một monitor khi có một thread vào thì sau khi thread chạy xong thì sẽ tiếp tục nhét thread mới
        => Synchrozation là quá trinh làm cho các thread chạy lần lượt
        
        */
    }
}
