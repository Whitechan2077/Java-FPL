/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file.buffer.wirter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author buidu
 */
public class BufferWriter {
    public static void main(String[] args) throws IOException {
        writeToText();
        readToText();
    }
    public static void writeToText () throws IOException{
       List<Student>  listStudents = new ArrayList<>();
       listStudents.add(new Student("A", 1));
       listStudents.add(new Student("B", 1));
       listStudents.add(new Student("C", 1));
       FileWriter fileWriter = new FileWriter("data.txt");
       BufferedWriter bw = new BufferedWriter(fileWriter);
        for (Student listStudent : listStudents) {
            String temp = listStudent.toString();
            bw.write(temp);
        }
        bw.close();
    }
    public static void readToText() throws FileNotFoundException, IOException{
        FileReader fileRead = new FileReader("data.txt");
        BufferedReader br = new BufferedReader(fileRead);
        int c = br.read();
        while(c!= -1){
            System.out.print((char)c);
            c = br.read();        
        }
    }
}
