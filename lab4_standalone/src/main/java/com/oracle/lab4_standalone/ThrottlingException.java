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
public class ThrottlingException extends Exception {

    public ThrottlingException() {
    }

    public ThrottlingException(String message) {
        super(message);
    }
}
