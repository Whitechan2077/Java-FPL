/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generic;

/**
 *
 * @author buidu
 */
public class GenericClass<T,N> {
    private T name;
    private N age;

    public GenericClass(T name, N age) {
        this.name = name;
        this.age = age;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public N getAge() {
        return age;
    }

    public void setAge(N age) {
        this.age = age;
    }
    
}
