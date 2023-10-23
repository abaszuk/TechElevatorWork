package com.techelevator;

public class Employee {

    private int employeeId;

    private String firstName;

    private String lastName;

    private String department;

    private double annualSalary;

    //getters
    public int getEmployeeId(){
        return employeeId;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getDepartment(){
        return department;
    }

    public String getFullName(){
        return lastName + ", " +firstName;
    }

    public double getAnnualSalary(){
        return annualSalary;
    }

    //setters
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public Employee(int employeeId, String firstName, String lastName, double salary){
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = salary;
    }
    public void raiseSalary(double percent){
        annualSalary = (annualSalary*percent/100)+annualSalary;
    }


}
