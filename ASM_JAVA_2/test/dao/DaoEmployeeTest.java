/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dao;

import java.util.List;
import model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author buidu
 */
public class DaoEmployeeTest {
    
    public DaoEmployeeTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of save method, of class DaoEmployee.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Employee o = null;
        DaoEmployee instance = new DaoEmployee();
        instance.save(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class DaoEmployee.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        DaoEmployee instance = new DaoEmployee();
        List<Employee> expResult = null;
        List<Employee> result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class DaoEmployee.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int index = 0;
        DaoEmployee instance = new DaoEmployee();
        instance.delete(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class DaoEmployee.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        String ID = "";
        DaoEmployee instance = new DaoEmployee();
        Employee expResult = null;
        Employee result = instance.find(ID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
