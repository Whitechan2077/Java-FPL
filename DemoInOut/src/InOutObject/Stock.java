/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InOutObject;

import java.io.Serializable;

/**
 *
 * @author buidu
 */
public class Stock implements Serializable{
    private int ID;
    private String desc;
    private double price;
    private int quantity;

    public Stock(int ID, String desc, double price, int quantity) {
        this.ID = ID;
        this.desc = desc;
        this.price = price;
        this.quantity = quantity;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Stock{" + "ID=" + ID + ", desc=" + desc + ", price=" + price + ", quantity=" + quantity + '}';
    }
    
}
