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
public class Game {
    String tenGame;
    int namPhatHanh;
    String xuatXu;

    public Game() {
    }

    public Game(String tenGame, int namPhatHanh, String xuatXu) {
        this.tenGame = tenGame;
        this.namPhatHanh = namPhatHanh;
        this.xuatXu = xuatXu;
    }

    public String getTenGame() {
        return tenGame;
    }

    public void setTenGame(String tenGame) {
        this.tenGame = tenGame;
    }

    public int getNamPhatHanh() {
        return namPhatHanh;
    }

    public void setNamPhatHanh(int namPhatHanh) {
        this.namPhatHanh = namPhatHanh;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }
    
    public void nhap(){
        Scanner s = new Scanner(System.in);
        System.out.println("nhap ten:");
        this.tenGame = s.nextLine();
        System.out.println("nhap nam:");
        this.namPhatHanh = Integer.parseInt(s.nextLine());
        System.out.println("Xuat xu");
        this.xuatXu = s.nextLine();
    }
    public void xuat(){
        System.out.println("Ten : "+this.tenGame+" Nam sx: "+this.namPhatHanh+" Xuat xu : "+this.xuatXu);
    }
}
