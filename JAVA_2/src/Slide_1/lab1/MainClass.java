/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slide_1.lab1;

/**
 *
 * @author buidu
 */
public class MainClass {
    public static void main(String[]args){
        NoTax nt1 = new NoTax("Bao Cao Su", 69);
        NoTax nt2 = new NoTax("Sach", 69);
        NoTax nt3 = new NoTax("Sach 18", 69);
        System.out.println(nt1);
        System.out.println(nt2);
        System.out.println(nt3);
        nt1.insert();
        nt2.update();
        nt3.delete();
    }
}
