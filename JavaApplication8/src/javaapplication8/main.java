/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication8;

import java.util.Scanner;

/**
 *
 * @author buidu
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int op;
        Ma ma = new Ma();
        do {
            System.out.println("1.Nhap danh sach");
            System.out.println("2.xuat");
            System.out.println("3.ID co ma chan");
            System.out.println("4.Tim theo chu cai dau");
            System.out.println("5.ke thua");
            System.out.println("0. thoat");
            System.out.println("Moi chon chuc nang");
            op = s.nextInt();
            switch (op) {
                case 1:
                    ma.nhap();
                    break;
                case 2:
                    ma.xuat();
                    break;
                    case 3:
                    ma.timTheoMaChan();
                    break;
                case 4:{
                    s.nextLine();
                    String fistChar = s.nextLine();
                    ma.timTheoTU(fistChar);
                    break;}
                case 5:
                    ma.keThua();
                    break;
                default:
                    
            }
            
        } while (op!=0);
    }
    
}
