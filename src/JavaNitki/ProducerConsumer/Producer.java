package JavaNitki.ProducerConsumer;

import java.util.concurrent.Semaphore;

public class Producer extends Thread {
    private Buffer buffer;

    public Producer(Buffer buffer){
        this.buffer = buffer;
    }

    public void execute() throws InterruptedException {
//        public static Semaphore bufferEmpty;
//        public static Semaphore bufferLock;
//        public static Semaphore items[]; // eden semafor za sekoj consumer posebno

        Locks.bufferEmpty.acquire();

        Locks.bufferLock.acquire();
        buffer.fillBuffer();
        Locks.bufferLock.release();

        for(Semaphore s : Locks.items){
            // release whole buffer
            s.release();
        }

    }

    @Override
    public void run(){
        for(int i = 0; i < Application.NUM_RUNS; i++){
            try {
                execute();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


}


