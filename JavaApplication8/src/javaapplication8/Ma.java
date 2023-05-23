/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication8;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author buidu
 */
public class Ma {

    ArrayList<DongVat> listDongVat = new ArrayList<>();
    Scanner s = new Scanner(System.in);

    public void nhap() {
        while (true) {
        DongVat dv = new DongVat();
        dv.input();
        listDongVat.add(dv);
            System.out.println("Nhap tiep?  n de thoat");
            if (s.nextLine().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void xuat() {
        if (listDongVat.isEmpty()) {
            System.out.println("List rong");
        } else {
            for (DongVat x : listDongVat) {
                x.output();
            }
        }
    }

    public void timTheoMaChan() {
        boolean check = false;
        for (DongVat x : listDongVat) {
            if (x.getId() % 2 == 0) {
                x.output();
                check = true;
            }
        }
        if (check == false) {
            System.out.println("Ko tim thay");
        }
    }

    public void timTheoTU(String fistChar) {
        for (DongVat x : listDongVat) {
            if (x.getChar().equalsIgnoreCase(fistChar)) {
                x.output();
            }
        }
    }
    
    public void keThua(){
        Chuot c = new Chuot(6969,"Chim","Ngu");
        c.output();
    }
}
