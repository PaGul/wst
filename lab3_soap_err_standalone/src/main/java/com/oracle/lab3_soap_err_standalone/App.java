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
import javax.xml.ws.Endpoint;

public class App {

    public static void main(String[] args) {
        //disable stacktraces in soap-message 
        System.setProperty("com.sun.xml.ws.fault.SOAPFaultBuilder.disableCaptureStackTrace", "false");
        String url = "http://0.0.0.0:8081/EmployeeWebService";
        Endpoint.publish(url, new EmployeeWebService());
    }
}
