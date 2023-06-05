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
        CAR("lenovo",65), TRUCK("Truck-kin",55),
        AIRPLANE("May bay ba gia",600), TRAIN("Choi tau hoa",70), 
        BOAT("Quan lot",22);
        private final int speed;
        private final String name;

        private Tranport(String name, int speed) {
            this.speed = speed;
            this.name = name;
        }

        public static Tranport getCAR() {
            return CAR;
        }

        public static Tranport getTRUCK() {
            return TRUCK;
        }

        public static Tranport getAIRPLANE() {
            return AIRPLANE;
        }

        public static Tranport getTRAIN() {
            return TRAIN;
        }

        public static Tranport getBOAT() {
            return BOAT;
        }

        public int getSpeed() {
            return speed;
        }

        public String getName() {
            return name;
        }
        
    }
    
    public static void main(String[] args) {
        Tranport tp;
        tp = Tranport.AIRPLANE;
        System.out.println(tp.getName());
    }
}
