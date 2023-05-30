/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package generic;

/**
 *
 * @author buidu
 */
public class Generic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /*
        Generics chỉ cần hiểu đơn giản là tạo một class interface linh động kiểu dữ liệu
        quy ước đặt tên generics 
        T,V,E,K,N
        Generics không thể có static 
        không thể tạo mảng với generics
        
        */
        GenericClass generics1 = new GenericClass("Lmao",23);
        GenericClass<String,Integer> generics2 = new GenericClass<>("lmao",123);
    }
    
}
