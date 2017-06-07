package com.oracle.lab5_client;

import com.sun.istack.NotNull;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import java.util.List;
import javax.ws.rs.core.MediaType;

public class App {

    private static final String URL = "http://localhost:8085/rest/employees";

    public static void main(String[] args) {
        Client client = Client.create();
        printList(getEmployeesByParams(client, null, null, null, null, null));
        System.out.println();
        printList(getEmployeesByParams(client, null, null, "programmer", null, null));
        System.out.println();
        System.out.println(createEmployee(client, "Pavel", "Gulyaev", "programmer", 30000, false));
        System.out.println();
        System.out.println(updateEmployee(client, 1l, "Pasha", "Gul", null, 1, null));
        System.out.println();
        printList(getEmployeesByParams(client, null, null, null, null, null));
        System.out.println();
        System.out.println(deletePerson(client, 25l));
        System.out.println();
        printList(getEmployeesByParams(client, null, null, null, null, null));
    }
    
    private static List<Employee> getEmployeesByParams(Client client, String name,
            String surname,
            String job,
            Integer salary,
            Boolean disability) {
        WebResource webResource = client.resource(URL);
        webResource = fillWebResourceByEmployee(webResource, name, surname, job, salary, disability);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        GenericType<List<Employee>> type = new GenericType<List<Employee>>(){};
        return response.getEntity(type);
    }
    
//    private static List<Employee> getEmployees(Client client) {
//        WebResource webResource = client.resource(URL);
//        ClientResponse response = makeResponse(webResource);
//        GenericType<List<Employee>> type = new GenericType<List<Employee>>(){};
//        return response.getEntity(type);
//    }

    private static String createEmployee(
            @NotNull Client client,
            @NotNull String name,
            @NotNull String surname,
            @NotNull String job,
            @NotNull Integer salary,
            @NotNull Boolean disability) {
        WebResource webResource = client.resource(URL);
        webResource = webResource.queryParam("name", name);
        webResource = webResource.queryParam("surname", surname);
        webResource = webResource.queryParam("job", job);
        webResource = webResource.queryParam("salary", salary.toString());
        webResource = webResource.queryParam("disability", disability.toString());

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).put(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        GenericType<String> type = new GenericType<String>() {};
        return response.getEntity(type);
    }

    private static String updateEmployee(
            Client client,
            @NotNull Long id,
            String name,
            String surname,
            String job,
            Integer salary,
            Boolean disability) {
        WebResource webResource = client.resource(URL);
        webResource = fillWebResourceByEmployee(webResource, name, surname, job, salary, disability);
        webResource = webResource.queryParam("id", id.toString());
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        GenericType<String> type = new GenericType<String>() {};
        return response.getEntity(type);
    }

    private static String deletePerson(Client client,
            @NotNull Long id) {
        WebResource webResource = client.resource(URL);
        webResource = webResource.queryParam("id", id.toString());
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        GenericType<String> type = new GenericType<String>() {
        };
        return response.getEntity(type);
    }

    private static void printList(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
    
     private static ClientResponse makeResponse(WebResource webResource) {
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        return response;
    }
    
    private static WebResource fillWebResourceByEmployee(WebResource webResource,
            String name,
            String surname,
            String job,
            Integer salary,
            Boolean disability) {
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
        return webResource;
    }
}
