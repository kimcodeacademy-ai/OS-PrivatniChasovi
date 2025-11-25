package JavaNitki;

//MUTEX

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexExample extends Thread {

    @Override
    public void run()
    {
        for(int i = 0; i < 1000; i++){
            increment();
        }
    }

    private static int counter = 0;
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new MutexExample();
        Thread t2 = new MutexExample();
        Thread t3 = new MutexExample();
        Thread t4 = new MutexExample();
        Thread t5 = new MutexExample();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        System.out.println("Final counter value: " + counter);
    }

    private static void increment(){
        lock.lock();
        counter++;
        lock.unlock();
    }
}

