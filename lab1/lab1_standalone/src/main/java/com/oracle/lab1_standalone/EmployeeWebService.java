/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.lab1_standalone;

/**
 *
 * @author pavelgulaev
 */
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "EmployeeService")
public class EmployeeWebService {
    @WebMethod(operationName = "getEmployees")
    public List<Employee> getEmployees() {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        List<Employee> employees = dao.getEmployees("");
        return employees;
    }

    @WebMethod(operationName = "getEmployeesByParameters")
    public List<Employee> getEmployeesByParameters(Employee params) {
        String condition = "where ";
        if (params.getName()!= null) {
            condition += "name=\'" + params.getName().toString() + "\' and ";
        }
        if (params.getSurname()!= null) {
            condition += "surname=\'" + params.getSurname().toString() + "\' and ";
        }
        if (params.getJob()!= null) {
            condition += "job=\'" + params.getJob().toString() + "\' and ";
        }
        if (params.getSalary()!= null) {
            condition += "salary=\'" + params.getSalary().toString() + "\' and ";
        }
        if (params.isDisability()!= null) {
            condition += "disability=\'" + params.isDisability().toString() + "\' and ";
        }
        condition = condition.substring(0, condition.length() - 4);
        System.out.println(condition);
        PostgreSQLDAO dao = new PostgreSQLDAO();
        List<Employee> employees = dao.getEmployees(condition);
        return employees;
    }
}
