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
import model.Sanpham;
import java.util.List;

/**
 *
 * @author buidu
 */
public class Service {
    private List<Sanpham> listPd = new ArrayList<>();

    public List<Sanpham> getListPd() {
        return listPd;
    }
    public void add(String ten,String donVi,double donGia){
        this.listPd.add(new Sanpham(ten, donVi, donGia));
    }
    public void delete(int index){
        this.listPd.remove(index);
    }
    public void write(String path) throws FileNotFoundException, IOException{
        FileOutputStream fos = new FileOutputStream(path);
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this.listPd);
            fos.flush();
            oos.close();
        }
    }
    public void read(String path) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis = new  FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        this.listPd = (List<Sanpham>) ois.readObject();
        fis.close();
        ois.close();
     }
}
