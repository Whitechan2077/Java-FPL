/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.service;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import poly.model.Phone;
/**
 *
 * @author buidu
 */
public class ServicePhone implements Service{
   private List<Phone> listPhone  = new ArrayList<>();
    @Override
    public void openFile(String path) {
        try {
            try (FileInputStream fis = new FileInputStream(path); ObjectInputStream ois = new ObjectInputStream(fis)) {
                listPhone = (List<Phone>)ois.readObject();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ServicePhone.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ServicePhone.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void saaveFile(String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(listPhone);
                fos.flush();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ServicePhone.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServicePhone.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @Override
    public void deleted(int index) {
        listPhone.remove(index);
    }

    @Override
    public void insert(String id, String brand, String color, int rom, int price) {
        listPhone.add(new Phone(id, brand, color, rom, price));
        listPhone.forEach((t) -> {
            System.out.println(t.toString());
        });
    }

    /**
     *
     * @return
     */
    @Override
    public List<Phone> getList() {
        return listPhone;
    }
    
}
