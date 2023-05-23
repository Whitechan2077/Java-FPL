/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vaoracuming;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author buidu
 */
public class test2 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        List<Class> list = new ArrayList<>();
        FileInputStream fis = new FileInputStream("ditnau.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        list = (List<Class>) ois.readObject();
        for (Class class1 : list) {
            System.out.println(class1.getName());
            System.out.println(class1.getClassName());
        }
    }
}
