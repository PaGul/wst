/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.lab6_rest_err_standalone;

/**
 *
 * @author pavelgulaev
 */
public class NoDataForUpdateException extends Exception {

    private static final long serialVersionUID = -6647544772732631047L;
    public static NoDataForUpdateException DEFAULT_INSTANCE = new NoDataForUpdateException("update query can not be empty");

    public NoDataForUpdateException(String message) {
        super(message);
    }
}
