/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.stream.FileImageInputStream;
import model.Custom;
/**
 *
 * @author buidu
 */
public class Service {
    private List<Custom> listCustom = new ArrayList<>();

    public List<Custom> getListCustom() {
        return listCustom;
    }
    public void add(Custom c){
        this.listCustom.add(c);
    }
    public void write(String path) throws FileNotFoundException, IOException{
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.listCustom);
        fos.flush();
        oos.close();
    }
    public void read(String path) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        this.listCustom = (List<Custom>) ois.readObject();
        fis.close();
        ois.close();
    }
}
