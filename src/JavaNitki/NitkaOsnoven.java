package JavaNitki;

// osnovna implementacija na Threads, so nasleduvanje na java klasata Thread
public class NitkaOsnoven extends Thread{

    // celiot kod, celata logika sto ke ja pisuvame vo nitkite
    // ja pisuvame vo metodata run

    @Override
    public void run(){
        for(int i = 1; i <= 5; i++){
            System.out.println(getName() + " -> broj: " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(getName() + " zavrsi");
    }

    public static void main(String[] args) {
        NitkaOsnoven t1 = new  NitkaOsnoven();
        NitkaOsnoven t2 = new NitkaOsnoven();
        t1.start();
        t2.start();
    }
}
