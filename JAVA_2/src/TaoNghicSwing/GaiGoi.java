/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaoNghicSwing;

/**
 *
 * @author buidu
 */
public class GaiGoi {
    private String tenGaiGoi;
    private int tuoi;
    private double gia;

    public GaiGoi(String tenGaiGoi, int tuoi, double gia) {
        this.tenGaiGoi = tenGaiGoi;
        this.tuoi = tuoi;
        this.gia = gia;
    }

    public String getTenGaiGoi() {
        return tenGaiGoi;
    }

    public void setTenGaiGoi(String tenGaiGoi) {
        this.tenGaiGoi = tenGaiGoi;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public GaiGoi() {
    }   
}
