/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.custom.exceptions;

/**
 *
 * @author buidu
 */
public class ObjectNotFoundException extends Exception{
    private String message;

    public ObjectNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ObjectNotFoundException"+message;
    }
    
}
