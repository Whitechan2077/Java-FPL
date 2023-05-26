/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InOutObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

/**
 *
 * @author buidu
 */
public class ReadObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException, FileNotFoundException {
        Stock [] stock;
        FileInputStream fis = new FileInputStream("file.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        stock =  (Stock[])ois.readObject();
        System.out.println(Arrays.toString(stock));
        fis.close();
        ois.close();
    }
}
