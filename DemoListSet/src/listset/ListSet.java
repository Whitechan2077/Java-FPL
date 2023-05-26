/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listset;

import java.util.*;

/**
 *
 * @author buidu
 */
public class ListSet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);

        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(6);

        set.addAll(list);
        set.toString();
        System.out.println(set);
        list.addAll(set);
        System.out.println(list);
        
        Iterator<Integer> inter = list.iterator();
        
        while (inter.hasNext()) {            
            if (inter.next().equals(6)) {
                inter.remove();
            }
        }
        
        System.out.println(list);
    }

}
