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
public class AoV extends Game {

    private int cheDoDau;
    private String rank;

    public AoV(int cheDoDau, String rank, String tenGame, int namPhatHanh, String xuatXu) {
        super(tenGame, namPhatHanh, xuatXu);
        this.cheDoDau = cheDoDau;
        this.rank = rank;
    }



    public int getCheDoDau() {
        return cheDoDau;
    }

    public void setCheDoDau(int cheDoDau) {
        this.cheDoDau = cheDoDau;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public void xuat() {
        super.xuat(); 
        System.out.println("Rank : "+this.rank+" Che do dau"+this.cheDoDau);
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("nhap che do dau");
            this.cheDoDau = s.nextInt();
        } while (this.cheDoDau < 1 && this.cheDoDau > 8);//che do dau >1 <8
        System.out.println("nhap rank");
        this.rank = s.nextLine();
    }
}
