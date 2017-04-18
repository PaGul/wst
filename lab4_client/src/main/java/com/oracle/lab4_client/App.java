package com.oracle.lab4_client;

/**
 * Hello world!
 *
 */
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import java.util.List;
import javax.ws.rs.core.MediaType;

public class App {

    private static final String URL = "http://localhost:8084/rest/employees";

    public static void main(String[] args) {
        Client client = Client.create();
        printList(getEmployeesByParams(client, null, null, null, null, null));
        System.out.println();
        printList(getEmployeesByParams(client, null, null, "programmer", null, null));
    }

    private static List<Employee> getEmployeesByParams(Client client, String name,
            String surname,
            String job,
            Integer salary,
            Boolean disability) {
        WebResource webResource = client.resource(URL);
        if (name != null) {
            webResource = webResource.queryParam("name", name);
        }
        if (surname != null) {
            webResource = webResource.queryParam("surname", surname);
        }
        if (job != null) {
            webResource = webResource.queryParam("job", job);
        }
        if (salary != null) {
            webResource = webResource.queryParam("salary", salary.toString());
        }
        if (disability != null) {
            webResource = webResource.queryParam("disability", disability.toString());
        }
        
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        GenericType<List<Employee>> type = new GenericType<List<Employee>>() {
        };
        return response.getEntity(type);
    }

    private static void printList(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
