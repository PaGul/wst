/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.lab2_crud;

/**
 *
 * @author pavelgulaev
 */
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        if (params.getName() != null) {
            condition += "name=\'" + params.getName().toString() + "\' and ";
        }
        if (params.getSurname() != null) {
            condition += "surname=\'" + params.getSurname().toString() + "\' and ";
        }
        if (params.getJob() != null) {
            condition += "job=\'" + params.getJob().toString() + "\' and ";
        }
        if (params.getSalary() != null) {
            condition += "salary=\'" + params.getSalary().toString() + "\' and ";
        }
        if (params.isDisability() != null) {
            condition += "disability=\'" + params.isDisability().toString() + "\' and ";
        }
        condition = condition.substring(0, condition.length() - 4);
        System.out.println(condition);
        PostgreSQLDAO dao = new PostgreSQLDAO();
        List<Employee> employees = dao.getEmployees(condition);
        return employees;
    }

    @WebMethod(operationName = "createNewEmployee")
    public Long createNewEmployee(Employee newEmployee) {
        try {
            if (newEmployee.getName() == null || newEmployee.getSurname() == null || newEmployee.getSalary() == null || newEmployee.getJob() == null || newEmployee.isDisability() == null) {
                throw new SQLException("Wrong parameters: all params shouldn't be NULL");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeWebService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.createEmployee(newEmployee);
    }

    @WebMethod(operationName = "updateEmployee")
    public int updatePerson(long id, Employee updatingParams) {
        int nulls = 5;
        StringBuilder query = new StringBuilder("UPDATE \"Employee\" SET ");
        try {
            if (updatingParams.getName() != null) {
                query.append("name = '" + updatingParams.getName() + "', ");
                nulls--;
            }
            if (updatingParams.getSurname() != null) {
                query.append("surname = '" + updatingParams.getSurname() + "', ");
                nulls--;
            }
            if (updatingParams.getJob() != null) {
                query.append("job = '" + updatingParams.getJob() + "', ");
                nulls--;
            }
            if (updatingParams.getSalary() != null) {
                query.append("salary = '" + updatingParams.getSalary() + "', ");
                nulls--;
            }
            if (updatingParams.isDisability() != null) {
                query.append("disability = '" + updatingParams.isDisability() + "', ");
                nulls--;
            }
            if (nulls == 5) {
                throw new SQLException("No params to update Employee");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeWebService.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
        query.replace(query.lastIndexOf(","), query.lastIndexOf(",") + 1, "");
        query.append("WHERE id = " + id);
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.updateEmployee(query.toString());
    }

    @WebMethod(operationName = "deleteEmployee")
    public int deletePerson(long id) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.deleteEmployee(id);
    }
}
