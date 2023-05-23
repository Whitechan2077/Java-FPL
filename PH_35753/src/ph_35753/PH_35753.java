/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ph_35753;

import java.util.Scanner;

/**
 *
 * @author buidu
 */
public class PH_35753 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        QuanLy ql = new QuanLy();
        int op;
        while (true) {
            System.out.println("1.nhap vaccin");
            System.out.println("0.xuat vaccin");
            System.out.println("3.xuat");
            System.out.println("4.cap nhat");
            System.out.println("5.xsort ten cong dung");
            System.out.println("6.xoa");
            System.out.println("7.tim theo cong dung");
            op = s.nextInt();
            s.nextLine();
            switch (op) {
                case 1:
                    ql.nhapVacxin();
                    break;
                case 2:
                    ql.xuatDanhSachVacxin();
                    break;
                case 3: {
                    String ten = s.nextLine();
                    ql.update(ten);
                    break;
                }
                case 4: {
                    String ten = s.nextLine();
                    ql.update(ten);
                    break;
                }
                case 5: {
                    ql.sortName();
                    break;
                }
                case 6: {
                    String ten = s.nextLine();
                    ql.xoaTen(ten);
                    break;
                }
                case 7: {
                    String ten = s.nextLine();
                    ql.timTheoCongDung(ten);
                    break;
                }
                default:
                    System.out.println("Vui long nhap dung");
            }
            System.out.println("N de thoat bam nut bat ki de nhap tiep");
            if (s.nextLine().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

}
