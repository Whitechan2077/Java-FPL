package poly.main;
import java.io.FileNotFoundException;
import java.io.IOException;
import poly.model.Student;
import poly.io.XfileObject;
/**
 *
 * @author buidu
 */
public class XObjectDemo {
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        Student std = new Student("Dit con mẹ nhgaf mày", 69,"Thèm bú lồn");
        XfileObject.write("D:/lon.lon", std);
        Student st2 = (Student)XfileObject.read("D:/lon.lon");
        System.out.println(st2.getName());
        
    }
}
