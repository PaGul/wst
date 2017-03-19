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

        Employee newEmployee = new Employee();
        newEmployee.setName("Paul");
        newEmployee.setSurname("Gulyaev");
        newEmployee.setSalary(123456);
        newEmployee.setJob("programmer");
        newEmployee.setDisability(Boolean.FALSE);
        Long createNewEmployeeId = employeeService.getEmployeeWebServicePort().createNewEmployee(newEmployee);
        if (createNewEmployeeId != null) {
            System.out.println("New employee ID: " + createNewEmployeeId);
        } else {
            System.out.println("Insert error");
        }
        Employee updData = new Employee();
        updData.setName("Paul");
        updData.setJob("programmer");
        updData.setDisability(Boolean.FALSE);
        updData.setSalary(314);
        if (employeeService.getEmployeeWebServicePort().updateEmployee(10, updData) == 0) {
            System.out.println("Successful update");
        } else {
            System.out.println("Update error");
        }
        if (employeeService.getEmployeeWebServicePort().deleteEmployee(12) == 0) {
            System.out.println("Successful remove");
        } else {
            System.out.println("Remove error");
        }

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
