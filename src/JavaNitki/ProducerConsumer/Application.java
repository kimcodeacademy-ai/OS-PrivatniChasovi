package JavaNitki.ProducerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Application {
    static final int NUM_RUNS = 150;

    public static void main(String[] args) {
        int numConsumers = 100;

        init(numConsumers);
        Buffer b = new Buffer(numConsumers);
        Producer p = new Producer(b);
        List<Consumer> consumers = new ArrayList<>();
        for (int i = 0; i < numConsumers; i++){
            consumers.add(new Consumer(b, i));
        }
        p.start();
        for(int i = 0; i < numConsumers; i++){
            consumers.get(i).start();
        }
    }

    public static void init(int numConsumers){
        Locks.bufferEmpty = new Semaphore(1);
        Locks.bufferLock = new Semaphore(1);
        Locks.items = new Semaphore[numConsumers];

        for(int i = 0; i < numConsumers; i++){
            Locks.items[i] = new Semaphore(0);
        }

    }
}
