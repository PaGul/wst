
package com.oracle.generatedStandAlone;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.5-b05 
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "NoDataForUpdateException", targetNamespace = "http://lab3_soap_err_standalone.oracle.com/")
public class NoDataForUpdateException
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private EmployeeServiceFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public NoDataForUpdateException(String message, EmployeeServiceFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public NoDataForUpdateException(String message, EmployeeServiceFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.oracle.generatedStandAlone.EmployeeServiceFault
     */
    public EmployeeServiceFault getFaultInfo() {
        return faultInfo;
    }

}