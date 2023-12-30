class MyRunnable implements Runnable {
    public void run() {
   
        Thread currentThread = Thread.currentThread();
        
        System.out.println("Thread Name: " + currentThread.getName());
    }
}

public class thread {
    public static void main(String[] args) {
        
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable, "Thread-1");
        Thread t2 = new Thread(myRunnable, "Thread-2");

        t1.start();
        t2.start();
    }
}

//OUTPUT:
//
//run:
//Thread Name: Thread-1
//Thread Name: Thread-2
//BUILD SUCCESSFUL (total time: 0 seconds)