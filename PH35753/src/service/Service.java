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
import model.Customers;
/**
 *
 * @author buidu
 */
public class Service {
    private List<Customers> listCustomer = new ArrayList<>();
    public List<Customers> getListCustomer() {
        return listCustomer;
    }
    public void add(Customers c){
        this.listCustomer.add(c);
    }
    public void write(String path) throws FileNotFoundException, IOException{
        FileOutputStream fos = new FileOutputStream(path);
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this.listCustomer);
            fos.flush();
        }
    }
    public void read(String path) throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        this.listCustomer = (List<Customers>) ois.readObject();
        ois.close();
        fis.close();
    }
    public void edit(int index,String name,String id,int BY, String sex,String type){
        this.listCustomer.get(index).setBirthYear(BY);
        this.listCustomer.get(index).setId(id);
        this.listCustomer.get(index).setType(type);
        this.listCustomer.get(index).setSex(sex);
        this.listCustomer.get(index).setName(name);
    }
}
