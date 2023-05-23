/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Product;
import Dao.ProductDAO;
import Model.NoTaxProduct;
import java.util.Scanner;

/**
 *
 * @author buidu
 */
public class Product_Managerment {

    ProductDAO dao = new ProductDAO();

    public void inputListProduct() {
        for (int i = 0; i < 5; i++) {
            Scanner s = new Scanner(System.in);
            
            if (i < 3) {
            System.out.println("ten");
            String name = s.nextLine();
            System.out.println("gia");
            double price = Double.parseDouble(s.nextLine());
            dao.Insert(new Product(name, price));
            }
            else{
            System.out.println("ten");
            String name = s.nextLine();
            System.out.println("gia");
            double price = Double.parseDouble(s.nextLine());
            dao.Insert(new NoTaxProduct(name, price));
            }
        }
    }

    public void output() {
        for (Product x : dao.Select()) {
            System.out.println("Name : " + x.getName());
            System.out.println("Price : " + x.getPrice());
            System.out.println("Import Tax : " + x.getImportax());
        }
    }
}
