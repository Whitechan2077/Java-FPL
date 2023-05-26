/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1fpt;

import java.util.Scanner;

/**
 *
 * @author buidu
 */
public class Product implements DAO{
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product() {
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getImportax(){
        return price*0.1;
    }

    @Override
    public String toString() {
        return "Name: "+name+" Price: "+price+" Tax "+getImportax();
    }

    @Override
    public void INSERT() {
        System.out.println("Done");
    }

    @Override
    public void UPDATE() {
        System.out.println("Done");
    }

    @Override
    public void DELETE() {
        System.out.println("Done");
    }

    @Override
    public void SELECT() {
        System.out.println("Done");
    }
    public void input(){
        Scanner s = new Scanner(System.in);
        name = s.nextLine();
        price = s.nextDouble();
    }
}
