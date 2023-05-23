/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lab3;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author buidu
 */
public class DemoMap {

    public static void main(String[] args) {
        Map<String, Student> mapStudent = new HashMap<>();
        Student sv1 = new Student("Ambatukam", 6.9, "Mastruble");
        Student sv2 = new Student("Lmao", 10.0, "Cuoi to vcl");
        Student sv3 = new Student("Lmao3", 10.0, "Cuoi to vcl2");
        mapStudent.put(sv1.getName(), sv1);
        mapStudent.put(sv2.getName(), sv2);
        mapStudent.put(sv3.getName(), sv3);
        for (Map.Entry<String,Student> entry : mapStudent.entrySet()){
            System.out.print(entry.getKey()+" ");
            System.out.println(entry.getValue().getGrade());
        }
    }
}
