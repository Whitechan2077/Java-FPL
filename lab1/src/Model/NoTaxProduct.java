/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author buidu
 */
public class NoTaxProduct extends Product{

    public NoTaxProduct(String name, double price) {
        super(name, price);
    }

    public NoTaxProduct() {
    }

    @Override
    public double getImportax() {
       return 0;
    }
    
}
