/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.lab1_standalone;

import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pavelgulaev
 */
public class EmployeeWebServiceTest {


    /**
     * Test of getEmployees method, of class EmployeeWebService.
     */
    @Test
    public void testGetEmployees() {
        System.out.println("getEmployees");
        EmployeeWebService instance = new EmployeeWebService();
        List<Employee> expResult = new LinkedList<Employee>();
        expResult.add(new Employee("Julia", "Farmer", "programmer", 45000, false));
        expResult.add(new Employee("Tommie", "Vaughn", "project manager", 50000, false));
        expResult.add(new Employee("Neal", "Tyler", "intern programmer", 20000, false));
        expResult.add(new Employee("Gerald", "Carroll", "programmer", 40000, false));
        expResult.add(new Employee("Andre", "Peters", "singer", 600000, true));
        expResult.add(new Employee("Pete", "Jones", "shoemaker", 30000, true));
        expResult.add(new Employee("Wm", "Bowen", "risk manager", 50000, false));
        expResult.add(new Employee("Scott", "Guerrero", "pilot", 80000, false));
        expResult.add(new Employee("Rickey", "Barton", "pilot", 80000, false));
        expResult.add(new Employee("Dale", "Brooks", "writer", 0, false));
        List<Employee> result = instance.getEmployees();
        assertTrue(expResult.size() == result.size() && expResult.containsAll(result));
    }

    /**
     * Test of getEmployeesByParameters method, of class EmployeeWebService.
     */
    @Test
    public void testGetEmployeesByParameters() {
        System.out.println("getEmployeesByParameters");
        Employee params = new Employee();
        params.setJob("programmer");
        EmployeeWebService instance = new EmployeeWebService();
        List<Employee> expResult = new LinkedList<>();
        expResult.add(new Employee("Julia", "Farmer", "programmer", 45000, false));
        expResult.add(new Employee("Gerald", "Carroll", "programmer", 40000, false));
        List<Employee> result = instance.getEmployeesByParameters(params);
        assertTrue(expResult.size() == result.size() && expResult.containsAll(result));
    }
}
