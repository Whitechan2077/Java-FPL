/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package generic;

/**
 *
 * @author buidu
 */
public class Generic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        var a ="a";
        GenericClass generics1 = new GenericClass("Lmao",23);
        GenericClass<String,Integer> generics2 = new GenericClass<>("lmao",123);
        GenericClass<Integer,String> gen3 = new GenericClass<>(3,"lmao");
    }
    
}
