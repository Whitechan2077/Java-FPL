/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab1_review_oop;

/**
 *
 * @author buidu
 */
public class Boss implements DirtyOldMan{
    private String name;
    private int age;
    
    public Boss(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void Rape() {
        System.out.println("Ahhh High School Girls Pussy is goodd ahhh");
    }

    @Override
    public void HaveSexWithHighSchoolGirl() {
        System.out.println("Rape High School girls is really really fun !!!");
    }

    @Override
    public void MindBreak() {
        System.out.println("Find all method to mind break all school girls");
    }

    @Override
    public void Stalker() {
        System.out.println("Stalker a high school girl");
    }
    
}
