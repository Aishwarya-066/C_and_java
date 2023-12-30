/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aishwarya
 */
class PrintNumbers {
    private int n;
    private static int counter = 1;
    private static final Object lock = new Object();

    public PrintNumbers(int n) {
        this.n = n;
    }

    public void printOdd() {
        synchronized (lock) {
            while (counter <= n) {
                if (counter % 2 == 1) {
                    System.out.print(counter + " ");
                    counter++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void printEven() {
        synchronized (lock) {
            while (counter <= n) {
                if (counter % 2 == 0) {
                    System.out.print(counter + " ");
                    counter++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

public class PrintNumbersMain {
    public static void main(String[] args) {
        int n = 10; 

        PrintNumbers printNumbers = new PrintNumbers(n);

        Thread t1 = new Thread(printNumbers::printOdd);
        Thread t2 = new Thread(printNumbers::printEven);

        t1.start();
        t2.start();
    }
}

//OUTPUT:
//run:
//1 2 3 4 5 6 7 8 9 10 
//BUILD SUCCESSFUL (total time: 0 seconds)

