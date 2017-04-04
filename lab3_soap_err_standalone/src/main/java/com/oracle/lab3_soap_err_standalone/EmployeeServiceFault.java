/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.lab3_soap_err_standalone;

/**
 *
 * @author pavelgulaev
 */
public class EmployeeServiceFault {

    private static final String DEFAULT_MESSAGE = "query can not be empty";
    protected String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static EmployeeServiceFault defaultInstance() {
        EmployeeServiceFault fault = new EmployeeServiceFault();
        fault.message = DEFAULT_MESSAGE;
        return fault;
    }
}
