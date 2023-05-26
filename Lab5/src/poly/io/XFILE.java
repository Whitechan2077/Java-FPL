/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.io;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author buidu
 */
public class XFILE {
    public static byte[] read(String path) throws FileNotFoundException, IOException{
        FileInputStream fis = new FileInputStream(path);
        int n = fis.available();
        byte[] data = new byte[n];
        fis.read(data); // đọc data từ fis để nhập byte vào data
        fis.close();
        return data;
    }
    
    public static void write(String path,byte[]data) throws FileNotFoundException, IOException{
        FileOutputStream fos = new FileOutputStream(path);
        fos.write(data);
        fos.close();
        
    }
}

