/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.main;
import java.io.IOException;
import poly.io.XFILE;
/**
 *
 * @author buidu
 */
public class XFileDemo {
    public static void main(String[] args) throws IOException {
        byte[] data = XFILE.read("D:/Firmware 15.0.0.zip");
        XFILE.write("F:/Firmware 16.0.0.zip", data);
    }
}
