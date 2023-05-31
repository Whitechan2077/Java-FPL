/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author buidu
 */
public class LinkedList_DS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList <String> ls = new LinkedList<>();
        ls.add("A");
        ls.add("B");
        ls.add("C");
        ls.add("D");
        System.out.println(ls.peek());
        Iterator inter = ls.iterator();
        while(inter.hasNext()){
            System.out.println(inter.next());
        }
    }
}
