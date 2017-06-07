/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.lab5_standalone;

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
        if (name != null) {
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
        PostgreSQLDAO dao = new PostgreSQLDAO();
        List<Employee> employees = dao.getEmployees(condition);
        return employees;
    }

    @PUT
    public String createEmployee(@QueryParam("name") String name,
            @QueryParam("surname") String surname,
            @QueryParam("job") String job,
            @QueryParam("salary") Integer salary,
            @QueryParam("disability") Boolean disability) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.createEmployee(new Employee(name, surname, job, salary, disability)).toString();
    }

    @POST
    public String updateEmployee(@QueryParam("id") Long id,
            @QueryParam("name") String name,
            @QueryParam("surname") String surname,
            @QueryParam("job") String job,
            @QueryParam("salary") Integer salary,
            @QueryParam("disability") Boolean disability) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        String ret = dao.updateEmployee(id, name, surname, job, salary, disability).toString();
        return ret;
    }

    @DELETE
    public String deleteEmployee(@QueryParam("id") Long id) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.deleteEmployee(id).toString();
    }
}
