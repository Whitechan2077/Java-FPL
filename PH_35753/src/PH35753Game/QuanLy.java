/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PH35753Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author buidu
 */
public class QuanLy {

    ArrayList<Game> listGame = new ArrayList<>();
    Scanner s = new Scanner(System.in);

    public void nhap() {
        Game g = new Game();
        g.nhap();
        listGame.add(g);
    }

    public void xuat() {
        if (listGame.isEmpty()) {
            System.out.println("list trong");
        } else {
            for (Game x : listGame) {
                x.xuat();
            }
        }
    }

    public void xuatTheoKhoangNam(int nam1, int nam2) {
        boolean check = false;
        for (Game x : listGame) {
            if (x.getNamPhatHanh() >= nam1 && x.namPhatHanh <= nam2) {
                x.xuat();
                check = true;
            }
        }
        if (check==false) {
            System.out.println("ko tim thay");
        }
    }

    public void timTheoXuatXu(String xuatXu) {
        boolean check = false;
        for (Game x : listGame) {
            if (x.getXuatXu().equalsIgnoreCase(xuatXu)) {
                x.xuat();
                check = true;
            }
        }
        if (check == false) {
            System.out.println("Khong tim thay");
        }
    }

    public void xapXepTheoTen() {
        Collections.sort(listGame, (o1, o2) -> o1.getTenGame().compareToIgnoreCase(o2.getTenGame()));
        this.xuat();
    }

    public void xoaTenGame(String tenGame) {
        boolean check = false;
        for (int i = 0; i < listGame.size(); i++) {
            if (listGame.get(i).getTenGame().equalsIgnoreCase(tenGame)) {
                listGame.remove(listGame.get(i));
                check = true;
            }
        }
        if (check == false) {
            System.out.println("Khong tim thay");
        }
    }

    public void keThua() {
        AoV aov = new AoV(1, "Go", "Aov", 2016, "TW");
        aov.xuat();
    }
    public void nhapNamDuaRa2Game(int nam){
        int d = 0;
        boolean check = false;
        for(int i = 0 ; i < listGame.size(); i++){
            if (listGame.get(i).namPhatHanh == nam) {
                listGame.get(i).xuat();
                check = true;
                d++;
                if (d == 2) {
                    break;
                }
            }
        }
        if (check==false) {
            System.out.println("Khong tim thay");
        }
    }
}
