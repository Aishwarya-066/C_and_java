/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aishwarya
 */
public class EmployeeDemo {
    public static void main(String[] args) {

        Manager manager = new Manager("John Doe", 101, 15.0);
        Developer developer = new Developer("Jane Smith", 102, "Java");

        System.out.println("Manager Details:");
        System.out.println("Name: " + manager.getName());
        System.out.println("Employee ID: " + manager.getEmployeeID());
        System.out.println("Bonus Percentage: " + manager.calculateSalary());
        System.out.println();

        System.out.println("Developer Details:");
        System.out.println("Name: " + developer.getName());
        System.out.println("Employee ID: " + developer.getEmployeeID());
        System.out.println("Programming Language: " + developer.getProgrammingLanguage());
        System.out.println("Salary with Allowance: " + developer.calculateSalary());
    }
}
class Employee {
    private String name;
    private int employeeID;

    public Employee(String name, int employeeID) {
        this.name = name;
        this.employeeID = employeeID;
    }

    public double calculateSalary() {
        return 50000; }

    
    public String getName() {
        return name;
    }

    public int getEmployeeID() {
        return employeeID;
    }
}

class Manager extends Employee {
    private double bonusPercentage;

   
    public Manager(String name, int employeeID, double bonusPercentage) {
        super(name, employeeID);
        this.bonusPercentage = bonusPercentage;
    }

    @Override
    public double calculateSalary() {
  
        return super.calculateSalary() * (1 + bonusPercentage / 100);
    }
}

class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, int employeeID, String programmingLanguage) {
        super(name, employeeID);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public double calculateSalary() {
       
        return super.calculateSalary() + 10000; 
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }
}



//OUTPUT:
//
//run:
//Manager Details:
//Name: John Doe
//Employee ID: 101
//Bonus Percentage: 57499.99999999999
//
//Developer Details:
//Name: Jane Smith
//Employee ID: 102
//Programming Language: Java
//Salary with Allowance: 60000.0
//BUILD SUCCESSFUL (total time: 0 seconds)
