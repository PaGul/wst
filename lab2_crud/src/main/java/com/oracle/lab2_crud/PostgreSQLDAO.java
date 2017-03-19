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

    public int updateEmployee(String query) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement prSt = connection.prepareStatement(query);
            if (prSt.executeUpdate() == 0) {
                throw new SQLException("Can't update Employee");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
        return 0;
    }

    public int deleteEmployee(long id) {
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
