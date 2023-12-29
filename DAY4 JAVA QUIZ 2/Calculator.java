/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aishwarya
 */
public class Calculator {

    public int multiply(int a, int b) {
        return a * b;
    }

    public double multiply(double x, double y, double z) {
        return x * y * z;
    }

    public static void main(String[] args) {
  
        Calculator calculator = new Calculator();

        int resultInt = calculator.multiply(5, 7);
        System.out.println("Result of multiplying two integers: " + resultInt);

        double resultDouble = calculator.multiply(2.5, 3.0, 1.5);
        System.out.println("Result of multiplying three doubles: " + resultDouble);
    }
}

//OUTPUT:
//
//run:
//Result of multiplying two integers: 35
//Result of multiplying three doubles: 11.25
//BUILD SUCCESSFUL (total time: 0 seconds)
