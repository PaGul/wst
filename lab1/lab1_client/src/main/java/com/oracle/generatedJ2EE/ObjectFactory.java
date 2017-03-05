
package com.oracle.generatedJ2EE;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.generatedJ2EE package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetEmployeesResponse_QNAME = new QName("http://lab1_j2ee.oracle.com/", "getEmployeesResponse");
    private final static QName _GetEmployees_QNAME = new QName("http://lab1_j2ee.oracle.com/", "getEmployees");
    private final static QName _GetEmployeesByParameters_QNAME = new QName("http://lab1_j2ee.oracle.com/", "getEmployeesByParameters");
    private final static QName _GetEmployeesByParametersResponse_QNAME = new QName("http://lab1_j2ee.oracle.com/", "getEmployeesByParametersResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.generatedJ2EE
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetEmployeesByParametersResponse }
     * 
     */
    public GetEmployeesByParametersResponse createGetEmployeesByParametersResponse() {
        return new GetEmployeesByParametersResponse();
    }

    /**
     * Create an instance of {@link GetEmployees }
     * 
     */
    public GetEmployees createGetEmployees() {
        return new GetEmployees();
    }

    /**
     * Create an instance of {@link GetEmployeesByParameters }
     * 
     */
    public GetEmployeesByParameters createGetEmployeesByParameters() {
        return new GetEmployeesByParameters();
    }

    /**
     * Create an instance of {@link GetEmployeesResponse }
     * 
     */
    public GetEmployeesResponse createGetEmployeesResponse() {
        return new GetEmployeesResponse();
    }

    /**
     * Create an instance of {@link Employee }
     * 
     */
    public Employee createEmployee() {
        return new Employee();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployeesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1_j2ee.oracle.com/", name = "getEmployeesResponse")
    public JAXBElement<GetEmployeesResponse> createGetEmployeesResponse(GetEmployeesResponse value) {
        return new JAXBElement<GetEmployeesResponse>(_GetEmployeesResponse_QNAME, GetEmployeesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployees }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1_j2ee.oracle.com/", name = "getEmployees")
    public JAXBElement<GetEmployees> createGetEmployees(GetEmployees value) {
        return new JAXBElement<GetEmployees>(_GetEmployees_QNAME, GetEmployees.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployeesByParameters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1_j2ee.oracle.com/", name = "getEmployeesByParameters")
    public JAXBElement<GetEmployeesByParameters> createGetEmployeesByParameters(GetEmployeesByParameters value) {
        return new JAXBElement<GetEmployeesByParameters>(_GetEmployeesByParameters_QNAME, GetEmployeesByParameters.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployeesByParametersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1_j2ee.oracle.com/", name = "getEmployeesByParametersResponse")
    public JAXBElement<GetEmployeesByParametersResponse> createGetEmployeesByParametersResponse(GetEmployeesByParametersResponse value) {
        return new JAXBElement<GetEmployeesByParametersResponse>(_GetEmployeesByParametersResponse_QNAME, GetEmployeesByParametersResponse.class, null, value);
    }

}
