/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PH35753Game;

import java.util.Scanner;

/**
 *
 * @author buidu
 */
public class main {
    public static void main(String[] args) {
        QuanLy ql = new QuanLy();
        Scanner s = new Scanner(System.in);
        int op;
        do {            
            System.out.println("1.Nhap danh sach game");
            System.out.println("2.Xuat");
            System.out.println("3.xuat theo khoang nam");
            System.out.println("4.tim theo xuat xu");
            System.out.println("5.sap xep theo ten");
            System.out.println("6.xoa theo ten");
            System.out.println("7.ke thua");
            System.out.println("8.nhap nam dua ra 2 game");
            System.out.println("9.thoat");
            op = s.nextInt();
            s.nextLine();
            switch (op) {
                case 1:
                    while (true) {                        
                        ql.nhap();
                        System.out.println("nhap tiep k n thoat");
                        if (s.nextLine().equalsIgnoreCase("n")) {
                        break;
                        }
                    }
                    break;
                case 2:
                    ql.xuat();
                    break;
                case 3:
                    int nam1;
                    int nam2;
                    do {
                    nam1 = s.nextInt();
                    nam2 = s.nextInt();                             
                    } while (nam1>nam2);
                    ql.xuatTheoKhoangNam(nam1, nam2);
                    break;
                case 4:
                    s.nextLine();
                    String xuatXu = s.nextLine();
                    ql.timTheoXuatXu(xuatXu);
                    break;
                case 5:
                    ql.xapXepTheoTen();
                    break;
                case 6:
                    s.nextLine();
                    String tenGame = s.nextLine();
                    ql.xoaTenGame(tenGame);
                    break;
                    case 7:
                    ql.keThua();
                    break;
                    case 8:
                    int nam = s.nextInt();
                    ql.nhapNamDuaRa2Game(nam);
                    break;
                case 9:
                    
                    break;
                default:
                    System.out.println("sai");
            }
        }while(op !=9);
    }
}
