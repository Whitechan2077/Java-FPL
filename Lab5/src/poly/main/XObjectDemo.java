package poly.main;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import poly.model.Student;
import poly.io.XfileObject;
/**
 *
 * @author buidu
 */
public class XObjectDemo {
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        List<Student> listStudent = new ArrayList<>();
        List<Student> listStudent2 = new ArrayList<>();
        listStudent.add(new Student("Trần Thị Đặc Cầu", 8,"BJ"));
        listStudent.add(new Student("Trần Thị Cầu Đặc", 8,"HJ"));
        listStudent.add(new Student("Trần Thị Đuồi Bầu", 8,"FT"));
        XfileObject.write("D:/data.dat",listStudent);
        listStudent2 = (List<Student>)XfileObject.read("D:/data.dat");
        for (Student student : listStudent2) {
            System.out.println( student.toString());
        }
    }
}
