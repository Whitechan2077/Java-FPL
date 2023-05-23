package PH35753_test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author buidu
 */
public class QuanLy {

    ArrayList<GiaoVien> listGV = new ArrayList<>();
    Scanner s = new Scanner(System.in);
    public void nhap() {
        int op;
        
        
        while (true) {
            System.out.println("1.Giao vien");
            System.out.println("2.Giao vien co huu");
            op = s.nextInt();
            s.nextLine();
            switch (op) {
                case 1:
                    GiaoVien gv = new GiaoVien();
                    gv.input();
                    listGV.add(gv);
                    break;
                case 2:
                    GiaoVienCoHuu gvch = new GiaoVienCoHuu();
                    gvch.input();
                    listGV.add(gvch);
                    break;
                default:
                    System.out.println("Chon lai");
            }
            System.out.println("N de ngat");
            if (s.nextLine().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void xuat() {
        if (listGV.isEmpty()) {
            System.out.println("List trong");
        } else {
            for (GiaoVien x : listGV) {
                x.output();
            }
        }
    }

    public void xuatTheoKhoangTuoi(int tuoi1, int tuoi2) {
        boolean check = false;
        for (GiaoVien x : listGV) {
            if (x.getTuoi() > tuoi1 && x.getTuoi() < tuoi2) {
                x.output();
                check = true;
            }
        }
        if (check == false) {
            System.out.println("Ko tim thay");
        }
    }

    public void timGiaoVienHoNguyen() {
        String sName = "nguyen";
        boolean check = false;
        for (GiaoVien x : listGV) {
            if (x.getHo().equalsIgnoreCase(sName)) {
                x.output();
                check = true;
                break;
            }
        }
        if (check == false) {
            System.out.println("Ko tim thay");
        }
    }

    public void sortNameDESC() {
        Collections.sort(listGV, (o1, o2) -> o2.getHoVaTen().compareToIgnoreCase(o1.getHoVaTen()));
        this.xuat();
    }

    public void delGV(String name) {
        for (int i = 0; i < listGV.size(); i++) {
            if (listGV.get(i).getHoVaTen().equalsIgnoreCase(name)) {
                listGV.remove(listGV.get(i));
            }
        }
        this.xuat();
    }

    public void keThua() {
        System.out.println("nhap ten");
        String name = s.nextLine();
        System.out.println("Nhap ma");
        String ID = s.nextLine();
        System.out.println("Nhap nam hop dong");
        int year = s.nextInt();
        System.out.println("Nhap luong");
        double luong = s.nextDouble();
        System.out.println("Nhap tuoi");
        int age = s.nextInt();
        GiaoVienCoHuu gvch7 = new GiaoVienCoHuu(year, ID, name, age, luong);
        System.out.println(gvch7.toString());
    }
}
