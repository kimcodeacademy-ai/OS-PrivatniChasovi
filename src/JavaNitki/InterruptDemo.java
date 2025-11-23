package JavaNitki;

// interrupt - go prekinuva izvrsuvanjeto na nitkata
public class InterruptDemo extends Thread{

    @Override
    public void run(){
        System.out.println("Rabotam....");
        while(!isInterrupted()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Dobien e nekoj signal za prekin.");
                interrupt();
            }
        }
        System.out.println("Nitkata e uredno prekinata");
    }

    public static void main(String[] args) throws InterruptedException {
        InterruptDemo t = new InterruptDemo();
        t.start();
        Thread.sleep(1500);
        t.interrupt();
    }
}
