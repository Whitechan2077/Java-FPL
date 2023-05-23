/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1fpt;

/**
 *
 * @author buidu
 */
public class NotaxProduct extends Product{

    public NotaxProduct(String name, double price) {
        super(name, price);
    }

    public NotaxProduct() {
    }

    @Override
    public double getImportax() {
        return 0;
    }

    @Override
    public void input() {
        super.input(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

   
}
