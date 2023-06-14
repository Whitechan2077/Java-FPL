/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.service;
import java.util.List;
import poly.model.Phone;
/**
 *
 * @author buidu
 */
public interface Service {
    public void insert(String id , String  brand ,String color,int rom,int price);
    public void deleted( int index);
    public void openFile(String path);
    public void saaveFile(String path);
    public List<Phone> getList();
}
