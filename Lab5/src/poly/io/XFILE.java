/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * @author buidu
 */
public class XFILE {

    public static byte[] read(String path) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(path);
        int n = fis.available(); //trả về số  byte của file được input
        byte[] data = new byte[n];//tạo một mảng byte chứa
        fis.read(data);//đọc dữ liệu
        fis.close();//đòng luồng file
        return data;//trả về file kiểu byte
    }
    public static void write(String path,byte[] data) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);//Cho file ra
        fos.write(data);//vứt file
        fos.close();//đóng luồn
    }

    public static void write(String lmaodat, String a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

