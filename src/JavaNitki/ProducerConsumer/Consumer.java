package JavaNitki.ProducerConsumer;

public class Consumer extends Thread {
    private Buffer buffer;
    private int id;
    public Consumer(Buffer buffer, int id) {
        this.buffer = buffer;
        this.id = id;
    }

    public void execute() throws InterruptedException {
        Locks.items[id].acquire();
        // kriticen region, od tuka nadolu
        this.buffer.getItem(id);
        Locks.bufferLock.acquire();
        this.buffer.decrementNumberOfItemsLeft();
        if(this.buffer.isBufferEmpty()){
            Locks.bufferEmpty.release();
        }

        Locks.bufferLock.release();
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
