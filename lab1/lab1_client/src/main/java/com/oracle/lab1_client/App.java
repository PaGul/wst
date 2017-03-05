/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.lab1_client;

/**
 *
 * @author pavelgulaev
 */
/*
 * Для standalone сервера
 */
import com.oracle.generatedStandAlone.Employee;
import com.oracle.generatedStandAlone.EmployeeService;
/*
 * Для J2EE сервера
 */
//import com.oracle.generatedJ2EE.Employee;
//import com.oracle.generatedJ2EE.EmployeeService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws MalformedURLException {
        // Для standalone сервера
        URL url = new URL("http://localhost:8081/EmployeeWebService?wsdl");
        
        // Для J2EE сервера
//        URL url = new URL("http://localhost:8080/lab1_j2ee-1.0-SNAPSHOT/EmployeeService?wsdl");
        EmployeeService employeeService = new EmployeeService(url);
        Employee search = new Employee();
        search.setJob("programmer");
        List<Employee> searchEmployees = employeeService.getEmployeeWebServicePort().getEmployeesByParameters(search);
        for (Employee employee : searchEmployees) {
            System.out.println("name: " + employee.getName()
                    + ", surname: " + employee.getSurname() + ", job: " + employee.getJob()
                    + ", salary: " + employee.getSalary().toString() + ", disability: " + employee.isDisability().toString());
        }
        System.out.println("Total found employees: " + searchEmployees.size());

    }
}
