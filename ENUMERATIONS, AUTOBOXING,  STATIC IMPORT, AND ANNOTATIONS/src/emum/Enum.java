/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emum;

/**
 *
 * @author buidu
 */
public class Enum {
    
    public enum Tranport{
        CAR(65), TRUCK(55), AIRPLANE(600), TRAIN(70), BOAT(22);
        private final int speed;

        private Tranport(int speed) {
            this.speed = speed;
        }
    }
    
    public static void main(String[] args) {
        Tranport tp;
        tp = Tranport.AIRPLANE;
        System.out.println(tp.ordinal());
    }
}
