/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InOut;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author buidu
 */
public class OuputClass {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("file.chimto");
        String ten = "Em them co Huyen"; //cách tối ưu để lưu các dạng đữ liệu nguyên thủy và wrapper
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeUTF(ten);
        dos.writeDouble(123.123);
        dos.writeUTF("Liem co huyen");
        dos.writeInt(1);
        dos.writeInt(2);
        fos.close();
        dos.close();
    }
}
