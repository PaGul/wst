/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oracle.lab1_j2ee;

/**
 *
 * @author pavelgulaev
 */
public class Employee {

    private String name;
    private String surname;
    private String job;
    private Integer salary;
    private Boolean disability;
    public Employee() {
    }

    public Employee(String name, String surname, String job, int salary, boolean disability) {
        this.name = name;
        this.surname = surname;
        this.job = job;
        this.salary = salary;
        this.disability = disability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Boolean isDisability() {
        return disability;
    }

    public void setDisability(Boolean disability) {
        this.disability = disability;
    }

    

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", surname=" + surname + ", job=" + job + ", salary=" + salary + ", disability=" + disability + '}';
    }


    
}
