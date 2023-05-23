/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ph_35753;

import java.util.Scanner;

/**
 *
 * @author buidu
 */
public class Vacxin {
    String ten;
    String congDung;
    int nam;

    public Vacxin(String ten, String congDung, int nam) {
        this.ten = ten;
        this.congDung = congDung;
        this.nam = nam;
    }

    public Vacxin() {
    }
    
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCongDung() {
        return congDung;
    }

    public void setCongDung(String congDung) {
        this.congDung = congDung;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }
    
    public void input(){
        Scanner s = new Scanner(System.in);
        System.out.println("NHap ten vacxin");
        this.ten = s.nextLine();
        System.out.println("Nhap nam sx");
        this.nam = Integer.parseInt(s.nextLine());
        System.out.println("Nhap cong dung");
        this.congDung = s.nextLine();
    }
    public void ouput(){
        System.out.println("Ten :"+ten);
        System.out.println("Cong dung :"+congDung);
        System.out.println("nam :"+nam);
    }
    
}
