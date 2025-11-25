// imame 5 nitki koi sto rabotat istovremeno, ama samo dve nitki moze vo isto vreme da bidat vo nekoj resurs, a drugite cekaat red

package JavaNitki;

import java.util.concurrent.Semaphore;

public class SimpleSemaphoreExample {

    private static final Semaphore semaphore = new Semaphore(2);

    static class Worker extends Thread{
        private final int id;

        Worker(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                System.out.println("Worker " + id + " waiting to enter...");
                semaphore.acquire();
                System.out.println("Worker " + id + " starting");
                Thread.sleep(1000);
                System.out.println("Worker " + id + " leaving");
                semaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
    public static void main(String[] args) {
        for (int i  = 1; i <= 5 ; i++){
            new Worker(i).start();
        }
    }


}
