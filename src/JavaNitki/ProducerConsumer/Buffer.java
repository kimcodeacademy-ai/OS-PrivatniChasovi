package JavaNitki.ProducerConsumer;

public class Buffer {
    private int numItems;
    private int numConsumers;

    public Buffer(int numConsumers){
        this.numConsumers = numConsumers;
    }

    public void fillBuffer(){
        if (numItems != 0){
            throw new RuntimeException("The buffer is not empty!");
        }
        numItems = numConsumers;
        System.out.println("Filling the buffer...");
    }

    public void decrementNumberOfItemsLeft(){
        numItems--;
    }

    public boolean isBufferEmpty(){
        return numItems == 0;
    }

    public void getItem(int id){
        System.out.println(String.format("Get item by id: %d.", id));
    }

}

