/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slide_1.lab1;

/**
 *
 * @author buidu
 */
public class NoTax extends Product{

    public NoTax() {
    }

    public NoTax(String name, double pirce) {
        super(name, pirce);
    }
    

    @Override
    public double getImportTax() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString(); 
    }
    
    
}
