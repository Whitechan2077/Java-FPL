/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slide_1.lab1;

/**
 *
 * @author buidu
 */
public class Product implements Dao{

    private String name;
    private double price;

    public Product() {
    }

    public Product(String name,double pirce){
        this.name = name;
        this.price = pirce;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public double getPrice()
    {
        return this.price;
    }
    
    public double getImportTax(){
        return this.price * 0.1;
    }

    @Override
    public String toString() {
        return "Name : "+this.name +" Price :"+this.price;
    }

    @Override
    public void insert() {
        System.out.println("Insert Compelete");
    }

    @Override
    public void update() {
        System.out.println("Upadte Compelete");
    }

    @Override
    public void delete() {
        System.out.println("Delete Complete");
    }

    @Override
    public void select() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
