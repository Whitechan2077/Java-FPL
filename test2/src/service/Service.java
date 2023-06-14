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
import model.Product;
public class Service {
    private List<Product> pd = new ArrayList<>();

    public List<Product> getPd() {
        return pd;
    }
    public void  addList(String ten,String donVi,double donGia){
        pd.add(new Product(ten, donVi, donGia));
    }
    public void delete(int index){
        pd.remove(index);
    }
    public void write(String path) throws IOException{
        FileOutputStream fos = new FileOutputStream(path);
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(pd);
            fos.flush();
        }
    }
    public void read(String path) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream  ois;
        try (FileInputStream fis = new FileInputStream(path)) {
            ois = new ObjectInputStream(fis);
            pd  = (List<Product>) ois.readObject();
        }
        ois.close();
    }
}
