/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ph_35753;

import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author buidu
 */
public class VacXinNhapKhau extends Vacxin {
    private String tenHangNhapKhau;
    private double giaNhapKhau;

    public VacXinNhapKhau() {
    }

    public VacXinNhapKhau(String tenHangNhapKhau, double giaNhapKhau, String ten, String congDung, int nam) {
        super(ten, congDung, nam);
        this.tenHangNhapKhau = tenHangNhapKhau;
        this.giaNhapKhau = giaNhapKhau;
    }

    public String getTenHangNhapKhau() {
        return tenHangNhapKhau;
    }

    public void setTenHangNhapKhau(String tenHangNhapKhau) {
        this.tenHangNhapKhau = tenHangNhapKhau;
    }

    public double getGiaNhapKhau() {
        return giaNhapKhau;
    }

    public void setGiaNhapKhau(double giaNhapKhau) {
        this.giaNhapKhau = giaNhapKhau;
    }

    @Override
    public void ouput() {
        super.ouput(); 
        System.out.println("Ten vc nhap khau" + this.tenHangNhapKhau);
        System.out.println("Thue nhap khau : "+tinhThue());
    }

    @Override
    public void input() {
        super.input();
        Scanner s = new Scanner(System.in);
        System.out.println("nhap ten hang nhap khau");
        tenHangNhapKhau = s.nextLine();
        System.out.println("Nhap gia nhap khau");
        giaNhapKhau = s.nextDouble();
    }
    
    public double tinhThue(){
        double thue = 0;
        if (giaNhapKhau>200) {
            thue = giaNhapKhau * 0.2;
        }
        else thue = giaNhapKhau * 0.15;
        if (giaNhapKhau<100) {
             thue = giaNhapKhau*0.1;
        }
        return thue;
    }
}
