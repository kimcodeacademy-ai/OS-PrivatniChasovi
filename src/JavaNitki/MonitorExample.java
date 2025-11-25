package JavaNitki;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MonitorExample extends Thread{

    private static final List<String> sharedList = new ArrayList<>();
    private static final Lock lock = new ReentrantLock();
    private static final Object lock1Monitor = new Object();

    @Override
    public void run() {
        for(int i = 0; i < 300; i++){
            addItem(Thread.currentThread().getName() + " - item " + i);
        }
    }

    private static synchronized void addItem(String value){
        //lock.lock();
//        synchronized (lock1Monitor) {
        sharedList.add(value);
       // }
        //lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new MonitorExample();
        Thread t2 = new MonitorExample();
        Thread t3 = new MonitorExample();
        Thread t4 = new MonitorExample();
        Thread t5 = new MonitorExample();

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

        System.out.println("Total list size: " + sharedList.size());
    }
}

