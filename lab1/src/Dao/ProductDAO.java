/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import Model.Product;
import java.util.ArrayList;
/**
 *
 * @author buidu
 */
import java.util.List;/**
 *
 * @author buidu
 */
public class ProductDAO implements DAO<Product>{
    private static List<Product> listPD = new ArrayList<>();
    @Override
    public void Insert(Product o) {
        listPD.add(o);
    }

    @Override
    public void Delete() {
    }



    @Override
    public void Update() {
    }

    @Override
    public List<Product> Select() {
        return listPD;
    }
    
}
