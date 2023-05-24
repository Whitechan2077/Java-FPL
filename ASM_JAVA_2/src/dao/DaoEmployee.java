/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import model.Employee;
import custom_exception.ObjectNotFoundException;
import java.util.Collections;
import java.util.Comparator;
/**
 *
 * @author buidu
 */
public class DaoEmployee implements Dao<Employee,Integer,String,Object,Double>{

 List<Employee> listEmployee = new ArrayList<>();

    @Override
    public void save(Employee o) {
        listEmployee.add(o);
    }

    @Override
    public void delete(Integer index) {
        listEmployee.remove(index.intValue());
    }    

    /**
     *
     * @param ID
     * @return
     * @throws custom_exception.ObjectNotFoundException
     */
    @Override
    public Employee find(String ID){
        Employee emp = null;
        for (Employee employee : listEmployee) {
            if (employee.getMaNhanVien().equals(ID)) {
                emp = new Employee(employee.getMaNhanVien(),employee.getTenNhanVien(), employee.getTuoi(),employee.getEmail(),employee.getLuong(),employee.getImage());
                break;
            }
            else{
              
                try {
                    throw new ObjectNotFoundException("Khong tim duoc");
                } catch (ObjectNotFoundException ex) {
                }
            }
        }
        return emp;
    }

    @Override
    public List<Employee> getData() {
        return listEmployee;
    }

    @Override
    public void update(Integer index, String ID, String name, Integer age, String email, Double salary,String image) {
        listEmployee.get(index).setMaNhanVien(ID);
        listEmployee.get(index).setTenNhanVien(name);
        listEmployee.get(index).setTuoi(age);
        listEmployee.get(index).setEmail(email);
        listEmployee.get(index).setLuong(salary);
        listEmployee.get(index).setImage(image);
    }

    @Override
    public void saveFile() throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("data.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(listEmployee);
        fos.close();
        oos.close();
    }

    @Override
    public void openFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fos = new FileInputStream("data.dat");
        ObjectInputStream ois = new ObjectInputStream(fos);
        listEmployee = (List<Employee>)ois.readObject();
        fos.close();
        ois.close();
    }

    @Override
    public void sortByName() {
        Collections.sort(listEmployee, (o1, o2) -> o1.getTenNhanVien().compareToIgnoreCase(o2.getTenNhanVien()));
    }

    @Override
    public void sortBySalary() {
        Comparator<Employee> comp = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getLuong()>o2.getLuong()) {
                    return 1;
                }
                if (o1.getLuong()<o2.getLuong()) {
                    return -1;
                }
                else return 0 ;
            }
        };
        Collections.sort(listEmployee,comp);
    }
}
