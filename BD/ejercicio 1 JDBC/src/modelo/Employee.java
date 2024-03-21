package modelo;

import java.util.ArrayList;

public class Employee {
    private int employeeNumber;
    private String lastName;
    private String firstName;
    private String email;
    private int reportsTo;
    private String jobTitle;

    public Employee(int employeeNumber, String lastName, String firstName, String email, int reportsTo, String jobTitle) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.reportsTo = reportsTo;
        this.jobTitle = jobTitle;

    }

    @Override
    public String toString() {
        return "employeeNumber=" + employeeNumber +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", reportsTo=" + reportsTo +
                ", jobTitle='" + jobTitle + '\'';
    }
}
