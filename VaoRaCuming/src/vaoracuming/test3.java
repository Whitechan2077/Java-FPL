/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vaoracuming;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author buidu
 */
public class test3{
    public void ghiFile() throws IOException{
        FileWriter file = new FileWriter("z:\\lmao.txt");
        file.write("quan trong la ngu");
        file.close();
    };
}
