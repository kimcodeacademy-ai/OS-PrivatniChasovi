package JavaNitki.ProducerConsumer;

import java.util.concurrent.Semaphore;

public class Locks {
    public static Semaphore bufferEmpty;
    public static Semaphore bufferLock;
    public static Semaphore items[]; // eden semafor za sekoj consumer posebno
}

