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
public class PostgreSQLDAOTest {


    /**
     * Test of getEmployees method, of class PostgreSQLDAO.
     */
    @Test
    public void testGetEmployeesWithOneParameter() {
        System.out.println("getEmployeesWithOneParameter");
        String condition = "WHERE disability=TRUE";
        PostgreSQLDAO instance = new PostgreSQLDAO();
        List<Employee> expResult = new LinkedList<>();
        expResult.add(new Employee("Andre", "Peters", "singer", 600000, true));
        expResult.add(new Employee("Pete", "Jones", "shoemaker", 30000, true));
        List<Employee> result = instance.getEmployees(condition);
        assertTrue(expResult.size() == result.size() && expResult.containsAll(result));
    }

    @Test
    public void testGetEmployeesWithManyParameters() {
        System.out.println("getEmployeesWithManyParameters");
        String condition = "WHERE job='pilot' and salary=80000";
        PostgreSQLDAO instance = new PostgreSQLDAO();
        List<Employee> expResult = new LinkedList<>();
        expResult.add(new Employee("Scott", "Guerrero", "pilot", 80000, false));
        expResult.add(new Employee("Rickey", "Barton", "pilot", 80000, false));
        List<Employee> result = instance.getEmployees(condition);
        assertTrue(expResult.size() == result.size() && expResult.containsAll(result));
    }
    
    @Test
    public void testGetEmployeesWithoutResult() {
        System.out.println("getEmployeesWithoutResult");
        String condition = "WHERE job='pilot' and salary=80400";
        PostgreSQLDAO instance = new PostgreSQLDAO();
        List<Employee> expResult = new LinkedList<>();
        List<Employee> result = instance.getEmployees(condition);
        assertTrue(expResult.size() == result.size() && expResult.containsAll(result));
    }
}
