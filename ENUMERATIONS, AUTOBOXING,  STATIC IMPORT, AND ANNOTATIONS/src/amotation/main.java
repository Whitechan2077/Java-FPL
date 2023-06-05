/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package amotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 *
 * @author buidu
 */
public class main {

    public static void main(String[] args) throws NoSuchMethodException {
        Class<?> c = Class_student.class;
        Class[] aarg = new Class[2];
        aarg[0] = String.class;
        aarg[1] = String.class;
        Method m = c.getMethod("doSomethingElse", aarg);
        Annotation[][] parameterAnnotations = m.getParameterAnnotations();
        Class[] parameterTypes = m.getParameterTypes();
        int i = 0;
        for (Annotation[] parameterAnnotation : parameterAnnotations) {
            Class parameterType = parameterTypes[i++];
            for (Annotation annotation : parameterAnnotation) {
                System.out.println(annotation.annotationType());
                System.out.println(annotation.toString());

            }
        }
    }
}
