/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.lab4_standalone;

/**
 *
 * @author pavelgulaev
 */
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/employees")
@Produces({MediaType.APPLICATION_JSON})
public class EmployeeResource {

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
        PostgreSQLDAO dao = new PostgreSQLDAO();
        List<Employee> employees = dao.getEmployees(condition);
        return employees;
    }
}
