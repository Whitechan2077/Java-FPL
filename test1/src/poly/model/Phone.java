/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.model;

import java.io.Serializable;

/**
 *
 * @author buidu
 */
public class Phone implements Serializable{
   private String id;
   private String brand;
   private String color;
   private int rom;
   private int price;

    public Phone(String id, String brand, String color, int rom, int price) {
        this.id = id;
        this.brand = brand;
        this.color = color;
        this.rom = rom;
        this.price = price;
    }                          

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getRom() {
        return rom;
    }

    public void setRom(int rom) {
        this.rom = rom;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }  

    @Override
    public String toString() {
        return "Phone{" + "id=" + id + ", brand=" + brand + ", color=" + color + ", rom=" + rom + ", price=" + price + '}';
    }
    
}
