package com.mayank.curddemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @Column(name="id")
    private long id;
    private String firstName;
    private String lastName;
    private String emailId;

    private  String employeeDetails;

    public Employee(){}
    public Employee(long id, String firstName, String lastName, String emailId,String employeeDetails) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.employeeDetails=employeeDetails;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getEmployeeDetails(){return employeeDetails;}

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public void setEmployeeDetails(String employeeDetails){this.employeeDetails=employeeDetails;}

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ",employeeDetails='"+employeeDetails+'\''+
                '}';
    }
}
