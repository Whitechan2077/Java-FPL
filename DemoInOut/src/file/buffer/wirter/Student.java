/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file.buffer.wirter;

/**
 *
 * @author buidu
 */
public class Student {
   private String hoTen;
    private double diem;

    public Student(String hoTen, double diem) {
        this.hoTen = hoTen;
        this.diem = diem;
    }

    @Override
    public String toString() {
        return hoTen + " " + diem +"\n";
}
}