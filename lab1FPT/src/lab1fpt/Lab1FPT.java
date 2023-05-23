/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1fpt;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author buidu
 */
public class Lab1FPT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //bai1
        List<Product> arrProduct = new ArrayList();
        for (int i = 0; i < 5; i++) {
            Product pd = new Product();
            pd.input();
            arrProduct.add(pd);
        }
        for(Product x : arrProduct){
            System.out.println(x.toString());
        }
        //bai2
        List<Product> listNotax =  new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if(i<1){
            Product pd = new Product();
            pd.input();
            listNotax.add(pd);
            }
            else{
            Product pdnt = new NotaxProduct();
            pdnt.input();
            listNotax.add(pdnt);
            }
        }
            for(Product x : listNotax){
            System.out.println(x.toString());
        }
     //bai 3
             List<Product> list3 =  new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if(i<1){
                        Product pd = new Product();
            pd.input();
            list3.add(pd);
            }
            else{
            Product pdnt = new NotaxProduct();
            pdnt.input();
            list3.add(pdnt);
            }
        }
            for(Product x : list3){
            System.out.println(x.toString());
            x.INSERT();
            x.UPDATE();
            x.SELECT();
            x.DELETE();
        }
    }
}
