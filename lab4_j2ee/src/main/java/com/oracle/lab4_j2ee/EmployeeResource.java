/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.lab4_j2ee;

/**
 *
 * @author pavelgulaev
 */
import java.sql.Connection; import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped; import javax.sql.DataSource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/employees")
@Produces({MediaType.APPLICATION_JSON})
public class EmployeeResource {

    @Resource(lookup = "employee") 
    private DataSource dataSource;
    
    @GET
    public List<Employee> getEmployeesByParameters(@QueryParam("name") String name,
            @QueryParam("surname") String surname,
            @QueryParam("job") String job,
            @QueryParam("salary") Integer salary,
            @QueryParam("disability") Boolean disability) {
        String condition = "where ";
        if (name!= null) {
            condition += "name=\'" + name.toString() + "\' and ";
        }
        if (surname != null) {
            condition += "surname=\'" + surname.toString() + "\' and ";
        }
        if (job != null) {
            condition += "job=\'" + job.toString() + "\' and ";
        }
        if (salary != null) {
            condition += "salary=\'" + salary.toString() + "\' and ";
        }
        if (disability != null) {
            condition += "disability=\'" + disability.toString() + "\' and ";
        }
        condition = condition.substring(0, condition.length() - 4);
        System.out.println(condition);
        List<Employee> employees = null;
        try {
            employees = new PostgreSQLDAO(dataSource.getConnection()).getEmployees(condition);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employees;
    }
}