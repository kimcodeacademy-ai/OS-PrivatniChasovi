package JavaNitki;

// vtora osnovna implementacija
public class ThreadRunnable implements Runnable {

    private final String name;

    ThreadRunnable(String name){
        this.name=name;
    }

    @Override
    public void run() {
          for(int i = 3; i >= 1; i--){
              System.out.println(name + " -> " + i);
              try {
                  Thread.sleep(3000);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
          }
        System.out.println(name + " zavrsi rabota.");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadRunnable("t1")); // new ThreadRunnable sama po sebe ne ni pravi nitka.
        // No vo sklop na new Thread ni pravi nitka zaradi toa sto mi e optovarena metodata run()

        Thread t2 = new Thread(new ThreadRunnable("t2"));

        t1.start();
        t2.start();
    }
}
