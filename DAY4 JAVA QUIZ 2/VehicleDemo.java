/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aishwarya
 */

public class VehicleDemo {
    public static void main(String[] args) {
      
        Car car = new Car(60.0, 4); 
        Motorcycle motorcycle = new Motorcycle(80.0, 2); 

        double carSpeed = car.calculateSpeed();
        double motorcycleSpeed = motorcycle.calculateSpeed();

        System.out.println("Car Speed: " + carSpeed);
        System.out.println("Motorcycle Speed: " + motorcycleSpeed);

        if (carSpeed > motorcycleSpeed) {
            System.out.println("The car has the highest effective speed.");
        } else if (carSpeed < motorcycleSpeed) {
            System.out.println("The motorcycle has the highest effective speed.");
        } else {
            System.out.println("Both the car and motorcycle have the same effective speed.");
        }
    }
}

class Vehicle {
    private double speed;

    public Vehicle(double speed) {
        this.speed = speed;
    }

  
    public double calculateSpeed() {
        return speed;
    }
}

class Car extends Vehicle {
    private int numPassengers;


    public Car(double speed, int numPassengers) {
        super(speed);
        this.numPassengers = numPassengers;
    }

    @Override
    public double calculateSpeed() {
       
        return super.calculateSpeed() * numPassengers;
    }
}


class Motorcycle extends Vehicle {
    private int numWheels;

    public Motorcycle(double speed, int numWheels) {
        super(speed);
        this.numWheels = numWheels;
    }

    
    @Override
    public double calculateSpeed() {
        
        return super.calculateSpeed() * numWheels;
    }
}

//OUTPUT:
//run:
//Car Speed: 240.0
//Motorcycle Speed: 160.0
//The car has the highest effective speed.
//BUILD SUCCESSFUL (total time: 0 seconds)
