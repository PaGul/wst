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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSQLDAO {

    public List<Employee> getEmployees(String condition) {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(String.format("select * from \"Employee\" %s", condition));

            while (rs.next()) {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String job = rs.getString("job");
                Integer salary = rs.getInt("salary");
                Boolean disability = rs.getBoolean("disability");
                Employee employee = new Employee(name,surname,job,salary, disability);
                employees.add(employee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return employees;
    }
}
