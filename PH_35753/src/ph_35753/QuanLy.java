/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ph_35753;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author buidu
 */
public class QuanLy {

    ArrayList<Vacxin> listVacXin = new ArrayList<>();

    public void nhapVacxin() {
        int op;
        Scanner s = new Scanner(System.in);
        System.out.println("1.nhap vacxin");
        System.out.println("2.Nhap vacxin nhap khau");
        op = s.nextInt();
        switch (op) {
            case 1:
                Vacxin vc = new Vacxin();
                vc.input();
                listVacXin.add(vc);
                break;
            case 2:
                VacXinNhapKhau vcnk = new VacXinNhapKhau();
                vcnk.input();
                listVacXin.add(vcnk);
                break;
            default:
                System.out.println("vui long chon dung");
        }
    }

    public void xuatDanhSachVacxin() {
        if (listVacXin.isEmpty()) {
            System.out.println("trong");
        } else {
            for (Vacxin x : listVacXin) {
                x.ouput();
            }
        }
    }

    public void update(String ten) {
        boolean check = false;
        for (Vacxin x : listVacXin) {
            if (x.getTen().equalsIgnoreCase(ten)) {
                x.input();
                check = true;
                break;

            }
        }
        if (check == true) {
            System.out.println("Khong tim thay");
        }
    }

    public void sortName() {
        Collections.sort(listVacXin, (o1, o2) -> o1.getTen().compareToIgnoreCase(o2.getTen()));
        this.xuatDanhSachVacxin();
    }

    public void xoaTen(String tenCongdung) {
        boolean check = false;
        for (int i = 0; i < listVacXin.size(); i++) {
            if (listVacXin.get(i).getCongDung().equalsIgnoreCase(tenCongdung)) {
                listVacXin.remove(listVacXin.get(i));
                check = true;
                break;
            }
        }
        if (check == false) {
            System.out.println("Khong tim thay");
        }
    }

    public void timTheoCongDung(String ten) {
        boolean check = false;
        for (Vacxin x : listVacXin) {
            if (x.getTen().equalsIgnoreCase(ten)) {
                x.ouput();
                check = true;
                break;

            }
        }
        if (check == true) {
            System.out.println("Khong tim thay");
        }
    }

}
