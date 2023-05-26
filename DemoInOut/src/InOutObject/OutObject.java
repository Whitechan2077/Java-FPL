/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InOutObject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author buidu
 */
public class OutObject {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("file.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Stock[] stock={
            new Stock(123,"NO1", 69, 69),
            new Stock(124,"NO2", 69, 69),
            new Stock(125,"NO3", 69, 69),
            new Stock(126,"NO4", 69, 69),
        };
        oos.writeObject(stock);
        fos.close();
        oos.flush();
    }
}
