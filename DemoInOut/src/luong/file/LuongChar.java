/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luong.file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author buidu
 */
public class LuongChar {
    public static void main(String[] args) {
        File fileName = new File("file.txt");
        try {
            FileWriter fileOut = new FileWriter(fileName);
            fileOut.write("Them bu");
            fileOut.write("\n");
            fileOut.write("lol qua");
            fileOut.close();
            FileReader fileReader = new FileReader(fileName);
            int c = fileReader.read();
            while(c!=-1){
                System.out.println((char) c);
                c = fileReader.read();
            }
        } catch (Exception e) {
            
        }
    }
}
