/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taoExceptions;
/**
 *
 * @author buidu
 */
public class main {
    public static void main(String[] args) {
        try {
            tinhToan(50);
        } catch (myException e) {
            System.out.println("Caugh:"+e);
        }
        
    }

    private static void tinhToan(int i) throws myException {
        if (i>10) {
            throw new myException(i);
        }
    }
}
