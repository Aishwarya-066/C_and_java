/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aishwarya
 */
class PrimeNumberFinder extends Thread {
    public void run() {
        System.out.println("Prime numbers from 0 to 10:");
        for (int i = 2; i <= 10; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

class PalindromeNumberFinder extends Thread {
    public void run() {
        System.out.println("Palindrome numbers from 10 to 50:");
        for (int i = 10; i <= 50; i++) {
            if (isPalindrome(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private boolean isPalindrome(int num) {
        int originalNum = num;
        int reversedNum = 0;
        while (num > 0) {
            int digit = num % 10;
            reversedNum = reversedNum * 10 + digit;
            num /= 10;
        }
        return originalNum == reversedNum;
    }
}

public class SequentialThread {
    public static void main(String[] args) {
        PrimeNumberFinder primeThread = new PrimeNumberFinder();
        PalindromeNumberFinder palindromeThread = new PalindromeNumberFinder();

        primeThread.start();
        try {
            primeThread.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        palindromeThread.start();
    }
}
//
//OUTPUT:
//run:
//Prime numbers from 0 to 10:
//2 3 5 7 
//Palindrome numbers from 10 to 50:
//11 22 33 44 
//BUILD SUCCESSFUL (total time: 0 seconds)