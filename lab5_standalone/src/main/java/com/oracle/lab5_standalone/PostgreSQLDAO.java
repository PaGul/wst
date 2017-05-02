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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
                Employee employee = new Employee(name, surname, job, salary, disability);
                employees.add(employee);
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return employees;
    }

    public Long createEmployee(Employee newEmployee) {
        Long id = null;
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement prSt = connection.prepareStatement("INSERT INTO \"Employee\"(name, surname, job, salary, disability) values (?, ?, ?, ?, ? )", Statement.RETURN_GENERATED_KEYS);
            prSt.setString(1, newEmployee.getName());
            prSt.setString(2, newEmployee.getSurname());
            prSt.setString(3, newEmployee.getJob());
            prSt.setInt(4, newEmployee.getSalary());
            prSt.setBoolean(5, newEmployee.isDisability());
            if (prSt.executeUpdate() == 0) {
                throw new SQLException("Can't create new Employee");
            }
            ResultSet generatedKeys = prSt.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getLong(1);
            } else {
                throw new SQLException("Can't get new id of new Employee");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public Integer updateEmployee(Long id, String name,
            String surname,
            String job,
            Integer salary,
            Boolean disability) {
        int nulls = 5;
        StringBuilder query = new StringBuilder("UPDATE \"Employee\" SET ");
        try {
            if (name != null) {
                query.append("name = '" + name + "', ");
                nulls--;
            }
            if (surname != null) {
                query.append("surname = '" + surname + "', ");
                nulls--;
            }
            if (job != null) {
                query.append("job = '" + job + "', ");
                nulls--;
            }
            if (salary!= null) {
                query.append("salary = '" + salary.toString() + "', ");
                nulls--;
            }
            if (disability != null) {
                query.append("disability = '" + disability.toString() + "', ");
                nulls--;
            }
            if (nulls == 5) {
                throw new SQLException("No params to update Employee");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
        query.replace(query.lastIndexOf(","), query.lastIndexOf(",") + 1, "");
        query.append("WHERE id = " + id);
        System.out.println(query.toString());
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement prSt = connection.prepareStatement(query.toString());
            if (prSt.executeUpdate() == 0) {
                throw new SQLException("Can't update Employee");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
        return 0;
    }

    public Integer deleteEmployee(long id) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement prSt = connection.prepareStatement("DELETE FROM \"Employee\" WHERE id = ?");
            prSt.setLong(1, id);
            if (prSt.executeUpdate() == 0) {
                throw new SQLException("Can't delete Employee");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
        return 0;
    }

   
}
