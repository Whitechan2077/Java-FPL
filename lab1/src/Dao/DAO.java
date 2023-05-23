/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import java.util.List;
import Model.Product;
/**
 *
 * @author buidu
 * @param <T>
 */
public interface DAO <T>{
    
    public void Insert(T o);

    public void Delete();

    public List<T> Select();

    public void Update();
}
