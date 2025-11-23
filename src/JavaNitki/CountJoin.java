package JavaNitki;

public class CountJoin extends Thread{
    private long result;

    @Override
    public void run() {
        result = 0;
        for(long i = 0; i < 5_000_000; i++){
            result += i;
        }
        System.out.println("Smetanjeto e zavrseno");
    }

    public long getResult(){
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        CountJoin c = new CountJoin();
        c.start();
        c.join();  // - dava do znaenje deka se ceka celosniot rezultat od prethodnata nitka pred da se prodolzi kon ostatokot od programata
        System.out.println("Rezultat: " + c.getResult());

    }
}
