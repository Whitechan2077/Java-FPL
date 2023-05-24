/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author buidu
 * @param <T>
 * @param <I>
 * @param <D>
 * @param <O>
 */
public interface Dao<T,I,D,O,S> {
    public void save(T o);
    public void delete(I index);
    public List<T> getData();
    public T find(D ID);
    public void update(I index,D ID, D name, I age, D email,S salary,D image);
    public void openFile() throws FileNotFoundException,IOException,ClassNotFoundException;
    public void saveFile() throws FileNotFoundException,IOException;
    public void sortByName();
    public void sortBySalary();
}
