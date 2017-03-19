
package com.oracle.generatedStandAlone;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.generatedStandAlone package. 
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

    private final static QName _GetEmployeesByParametersResponse_QNAME = new QName("http://lab2_crud.oracle.com/", "getEmployeesByParametersResponse");
    private final static QName _DeleteEmployeeResponse_QNAME = new QName("http://lab2_crud.oracle.com/", "deleteEmployeeResponse");
    private final static QName _UpdateEmployee_QNAME = new QName("http://lab2_crud.oracle.com/", "updateEmployee");
    private final static QName _CreateNewEmployee_QNAME = new QName("http://lab2_crud.oracle.com/", "createNewEmployee");
    private final static QName _GetEmployees_QNAME = new QName("http://lab2_crud.oracle.com/", "getEmployees");
    private final static QName _GetEmployeesByParameters_QNAME = new QName("http://lab2_crud.oracle.com/", "getEmployeesByParameters");
    private final static QName _CreateNewEmployeeResponse_QNAME = new QName("http://lab2_crud.oracle.com/", "createNewEmployeeResponse");
    private final static QName _DeleteEmployee_QNAME = new QName("http://lab2_crud.oracle.com/", "deleteEmployee");
    private final static QName _UpdateEmployeeResponse_QNAME = new QName("http://lab2_crud.oracle.com/", "updateEmployeeResponse");
    private final static QName _GetEmployeesResponse_QNAME = new QName("http://lab2_crud.oracle.com/", "getEmployeesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.generatedStandAlone
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
     * Create an instance of {@link DeleteEmployeeResponse }
     * 
     */
    public DeleteEmployeeResponse createDeleteEmployeeResponse() {
        return new DeleteEmployeeResponse();
    }

    /**
     * Create an instance of {@link UpdateEmployee }
     * 
     */
    public UpdateEmployee createUpdateEmployee() {
        return new UpdateEmployee();
    }

    /**
     * Create an instance of {@link CreateNewEmployee }
     * 
     */
    public CreateNewEmployee createCreateNewEmployee() {
        return new CreateNewEmployee();
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
     * Create an instance of {@link CreateNewEmployeeResponse }
     * 
     */
    public CreateNewEmployeeResponse createCreateNewEmployeeResponse() {
        return new CreateNewEmployeeResponse();
    }

    /**
     * Create an instance of {@link DeleteEmployee }
     * 
     */
    public DeleteEmployee createDeleteEmployee() {
        return new DeleteEmployee();
    }

    /**
     * Create an instance of {@link UpdateEmployeeResponse }
     * 
     */
    public UpdateEmployeeResponse createUpdateEmployeeResponse() {
        return new UpdateEmployeeResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployeesByParametersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2_crud.oracle.com/", name = "getEmployeesByParametersResponse")
    public JAXBElement<GetEmployeesByParametersResponse> createGetEmployeesByParametersResponse(GetEmployeesByParametersResponse value) {
        return new JAXBElement<GetEmployeesByParametersResponse>(_GetEmployeesByParametersResponse_QNAME, GetEmployeesByParametersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEmployeeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2_crud.oracle.com/", name = "deleteEmployeeResponse")
    public JAXBElement<DeleteEmployeeResponse> createDeleteEmployeeResponse(DeleteEmployeeResponse value) {
        return new JAXBElement<DeleteEmployeeResponse>(_DeleteEmployeeResponse_QNAME, DeleteEmployeeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEmployee }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2_crud.oracle.com/", name = "updateEmployee")
    public JAXBElement<UpdateEmployee> createUpdateEmployee(UpdateEmployee value) {
        return new JAXBElement<UpdateEmployee>(_UpdateEmployee_QNAME, UpdateEmployee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateNewEmployee }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2_crud.oracle.com/", name = "createNewEmployee")
    public JAXBElement<CreateNewEmployee> createCreateNewEmployee(CreateNewEmployee value) {
        return new JAXBElement<CreateNewEmployee>(_CreateNewEmployee_QNAME, CreateNewEmployee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployees }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2_crud.oracle.com/", name = "getEmployees")
    public JAXBElement<GetEmployees> createGetEmployees(GetEmployees value) {
        return new JAXBElement<GetEmployees>(_GetEmployees_QNAME, GetEmployees.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployeesByParameters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2_crud.oracle.com/", name = "getEmployeesByParameters")
    public JAXBElement<GetEmployeesByParameters> createGetEmployeesByParameters(GetEmployeesByParameters value) {
        return new JAXBElement<GetEmployeesByParameters>(_GetEmployeesByParameters_QNAME, GetEmployeesByParameters.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateNewEmployeeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2_crud.oracle.com/", name = "createNewEmployeeResponse")
    public JAXBElement<CreateNewEmployeeResponse> createCreateNewEmployeeResponse(CreateNewEmployeeResponse value) {
        return new JAXBElement<CreateNewEmployeeResponse>(_CreateNewEmployeeResponse_QNAME, CreateNewEmployeeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEmployee }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2_crud.oracle.com/", name = "deleteEmployee")
    public JAXBElement<DeleteEmployee> createDeleteEmployee(DeleteEmployee value) {
        return new JAXBElement<DeleteEmployee>(_DeleteEmployee_QNAME, DeleteEmployee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEmployeeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2_crud.oracle.com/", name = "updateEmployeeResponse")
    public JAXBElement<UpdateEmployeeResponse> createUpdateEmployeeResponse(UpdateEmployeeResponse value) {
        return new JAXBElement<UpdateEmployeeResponse>(_UpdateEmployeeResponse_QNAME, UpdateEmployeeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployeesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2_crud.oracle.com/", name = "getEmployeesResponse")
    public JAXBElement<GetEmployeesResponse> createGetEmployeesResponse(GetEmployeesResponse value) {
        return new JAXBElement<GetEmployeesResponse>(_GetEmployeesResponse_QNAME, GetEmployeesResponse.class, null, value);
    }

}
