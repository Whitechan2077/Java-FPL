/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication8;

import java.util.Scanner;

/**
 *
 * @author buidu
 */
public class DongVat {

    private int id;
    private String ten;
    private String theLoai;

    public DongVat(int id, String ten, String theLoai) {
        this.id = id;
        this.ten = ten;
        this.theLoai = theLoai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

 

    public DongVat() {
    }

    public void input() {
        Scanner s = new Scanner(System.in);
        System.out.println("Nhap ID :");
        this.id = Integer.parseInt(s.nextLine());
        System.out.println("Nhap ten :");
        this.ten = s.nextLine();
        System.out.println("Nhap the loai :");
        this.theLoai = s.nextLine();
    }
    public void output(){
        System.out.println("ID : "+id+" Ten "+ten+" the loai "+theLoai);
    }
    
    public String getChar(){
        return this.ten.substring(0, 1);
    }
}
