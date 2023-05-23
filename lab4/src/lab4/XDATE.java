/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author buidu
 */
public class XDATE {
    public static SimpleDateFormat format = new SimpleDateFormat();
    public static Date parse(String text,String partten) throws RuntimeException{
        try {
            format.applyPattern(partten);
            return format.parse(text);
        } 
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
