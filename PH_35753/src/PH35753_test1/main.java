/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PH35753_test1;

import java.util.Scanner;

/**
 *
 * @author buidu
 */
public class main {

    public static void main(String[] args) {
        int op;
        Scanner s = new Scanner(System.in);
        QuanLy ql = new QuanLy();
        do {
            System.out.println("1.Input list");
            System.out.println("2.Xuat list");
            System.out.println("3 Xuat theo khoang tuoi");
            System.out.println("4.Giao vien ho nguyen");
            System.out.println("5.Xap xep ho ten giam dan");
            System.out.println("6.Xoa giao vien theo ho ten da nhap");
            System.out.println("7.ke thua");
            System.out.println("8.out");
            System.out.println("chon chuc nang");
            op = Integer.parseInt(s.nextLine());
            switch (op) {
                case 1:
                    ql.nhap();
                    break;
                case 2:
                    ql.xuat();
                    break;
                case 3: {
                    int tuoi1;
                    int tuoi2;
                    do {
                        tuoi1 = s.nextInt();
                        tuoi2 = s.nextInt();
                    } while (tuoi1 > tuoi2);
                    ql.xuatTheoKhoangTuoi(tuoi1, tuoi2);
                }

                break;
                case 4:
                    ql.timGiaoVienHoNguyen();
                break;
                case 5:
                    ql.sortNameDESC();
                    break;
                case 6:
                    String name = s.nextLine();
                    ql.delGV(name);
                    break;
                case 7:
                    ql.keThua();
                    break;
                case 8:
                    System.out.println("Thoat ct");
                    break;
                default:
                    System.out.println("Vui long chon lai");
            }            
            
        } while (op!=8);
    }
}
