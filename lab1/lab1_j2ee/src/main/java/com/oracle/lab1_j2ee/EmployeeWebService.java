/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.lab1_j2ee;

/**
 *
 * @author pavelgulaev
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.sql.DataSource;

@WebService(serviceName = "EmployeeService")
public class EmployeeWebService {
    
    @Resource(lookup = "employee")
    private DataSource dataSource;
    
    @WebMethod(operationName = "getEmployees")
    public List<Employee> getEmployees() {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
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
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        List<Employee> employees = dao.getEmployees(condition);
        return employees;
    }
    
    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
