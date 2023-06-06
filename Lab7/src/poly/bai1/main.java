/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poly.bai1;

/**
 *
 * @author buidu
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student sv = new Student();
        sv.fullname = "Nguyễn Văn Tèo";
        //sv.career = Career.UDPM;
        sv.career = Career.valueOf("UDPM");
         sv.print();

    }

}
