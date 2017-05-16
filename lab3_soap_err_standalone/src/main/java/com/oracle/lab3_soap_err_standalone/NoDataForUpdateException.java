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
import javax.xml.ws.WebFault;

@WebFault(faultBean = "com.oracle.lab3_soap_err_standalone.EmployeeServiceFault")
public class NoDataForUpdateException extends Exception {

    private static final long serialVersionUID = -6647544772732631047L;
    private final EmployeeServiceFault fault;

    public NoDataForUpdateException(String message, EmployeeServiceFault fault) {
        super(message);
        this.fault = fault;
    }

    public NoDataForUpdateException(String message, EmployeeServiceFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public EmployeeServiceFault getFaultInfo() {
        return fault;
    }
}
