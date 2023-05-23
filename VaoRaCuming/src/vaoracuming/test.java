/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vaoracuming;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author buidu
 */
public class test {
    public static void main(String[] args) throws FileNotFoundException ,IOException{
        List<Class> listClass = new ArrayList<>();
        listClass.add(new Class("Co huyen lon mup","1"));
        listClass.add(new Class("Co huyen lon mup","2"));
        listClass.add(new Class("Co huyen lon mup","3"));
        listClass.add(new Class("Co huyen lon mup","4"));
        listClass.add(new Class("Co huyen lon mup","5"));
        
        FileOutputStream fos = new FileOutputStream("ditnau.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        oos.writeObject(listClass);
        oos.close();
    }
}
