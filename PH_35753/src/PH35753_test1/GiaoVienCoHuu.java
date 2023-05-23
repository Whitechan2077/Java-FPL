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
public class GiaoVienCoHuu extends GiaoVien {

    private int namKyHopDong;

    public GiaoVienCoHuu(int namKyHopDong, String maGV, String hoVaTen, int tuoi, double luong) {
        super(maGV, hoVaTen, tuoi, luong);
        this.namKyHopDong = namKyHopDong;
    }

    public GiaoVienCoHuu() {
    }

    @Override
    public void output() {

        super.output();
        System.out.println(" Nam ky hop dong: " + namKyHopDong);

    }

    @Override
    public void input() {
        super.input();
        Scanner s = new Scanner(System.in);
        namKyHopDong = s.nextInt();
    }

    @Override
    public String toString() {
        return "Ten: "+super.getHoVaTen()+" ID: "+super.getMaGV()+" Tuoi: "+super.getTuoi()+" Luong "+super.getLuong() +"Nam ky hop dong: "+namKyHopDong;
    }

}
