/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.lab1_standalone;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author pavelgulaev
 */
public class AppTest {

    public AppTest() {
    }
    static LinkedList<Connection> connections;

    @BeforeClass
    public static void setUpClass() {
        connections = new LinkedList<Connection>();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() throws SQLException {
        for (Connection connection : connections) {
            if (connection != null) {
                connection.close();
            }
        }
        connections.clear();
    }

    /**
     * Test of main method, of class App.
     */
    @Test
    public void testThrottlingException() {
        try {
            for (int i = 0; i < 11; i++) {
                connections.add(ConnectionUtil.getConnection());
            }
        } catch (ThrottlingException te) {
             assertTrue(te.getMessage().equals("Server is busy"));
        }
    }

}
