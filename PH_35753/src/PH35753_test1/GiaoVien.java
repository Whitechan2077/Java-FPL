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
public class GiaoVien {

    private String maGV;
    private String hoVaTen;
    private int tuoi;
    private double luong;

    public GiaoVien(String maGV, String hoVaTen, int tuoi, double luong) {
        this.maGV = maGV;
        this.hoVaTen = hoVaTen;
        this.tuoi = tuoi;
        this.luong = luong;
    }

    public GiaoVien() {
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public void input() {
        Scanner s = new Scanner(System.in);
        System.out.println("NHap ma");
        this.maGV = s.nextLine();
        System.out.println("Nhap ten");
        this.hoVaTen = s.nextLine();
        do {
            System.out.println("Nhap tuoi");
            this.tuoi = s.nextInt();
        } while (tuoi < 0);

        do {
            System.out.println("Nhap luong");
            this.luong = s.nextDouble();
        } while (luong < 0);
    }

    public void output() {
        System.out.println("Ma gv:" + this.maGV + " ten gv: " + this.hoVaTen + " tuoi: " + this.tuoi + " luong: " + this.luong);
    }

    public double tinhThue() {
        if (luong<15) {
            return 0;
        }
        else if (luong<=20) {
           return (luong-15)*0.1;
        }
        else if (luong<=35) {
            return (5*0.1)+(luong-20)*0.15;
        }
        else return (5*0.1)+(luong-20)*0.15+(luong-35)*0.2;
    }

    public String getHo() {
        String[] arr = this.hoVaTen.split(" ");
        return arr[0];
        //co the dung substring(index1,index2);
    }
}
