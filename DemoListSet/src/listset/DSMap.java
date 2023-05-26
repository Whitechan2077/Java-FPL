/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listset;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author buidu
 */
public class DSMap{

    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();
        map.put("Lmao",6.9);
        map.put("b", Double.NaN);
        for (Map.Entry<String,Double> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        
    }
}
