/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InOut;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException; 

/**
 *
 * @author buidu
 */
public class InputClass {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream("file.chimto");
        DataInputStream dis = new DataInputStream(fis);
        fis.close();
        dis.close();
    }
}
