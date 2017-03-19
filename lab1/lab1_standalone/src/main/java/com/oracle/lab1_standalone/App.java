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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.ws.Endpoint;

public class App {

    public static void main(String[] args) {
        String url = "http://0.0.0.0:8081/EmployeeWebService";
        Endpoint.publish(url, new EmployeeWebService());
//        Connection[] conns = new Connection[10];
//        for (int i = 0; i < 10; i++) {
//            conns[i] = ConnectionUtil.getConnection();
//        }
//        try {
//            conns[0].close();
//        } catch (SQLException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        ConnectionUtil.getConnection();

    }
}
