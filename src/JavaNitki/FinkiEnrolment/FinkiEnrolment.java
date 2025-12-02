//Во оваа задача го моделираме процесот на запишување студенти на ФИНКИ, каде што паралелно работат повеќе членови
//на административниот тим и голем број студенти кои доаѓаат да се запишат. Поентата е да се обезбеди правилна синхронизација
// помеѓу студентите и членовите
//на администрацијата за да се избегнат хаотични ситуации, расипани податоци и истовремено пристапување до ист ресурс.
//Системот функционира на следниот начин:
//Администрацијата има 4 членови, и секој член може да обработува по 10 студенти.
//Студентите не смеат сами да влезат — мора да ги пушти член на администрација.
//Кога студентот ќе влезе, тој ги дава документите.
//Додека студентот е внатре, членот на администрацијата мора да го запише (enrol).
//По запишувањето, студентот мора да излезе пред да влезе следниот.
//Овој циклус се повторува 10 пати за секој член на администрацијата.
//Ова бара строга синхронизација за да се избегне ситуација каде што двајца студенти даваат документи во исто време кај ист член,
//или членот почнува да запишува без студент пред него.

package JavaNitki.FinkiEnrolment;

import java.util.concurrent.Semaphore;

public class FinkiEnrolment {

    static Semaphore manageMembers;
    static Semaphore canEnter;
    static Semaphore canEnrol;
    static Semaphore shouldLeave;

    public static void init(){
        manageMembers = new Semaphore(4);
        canEnter = new Semaphore(0);
        canEnrol = new Semaphore(0);
        shouldLeave = new Semaphore(0);
    }

    public static class Member extends Thread{
        public void execute() throws InterruptedException {
            // kriticen region
            manageMembers.acquire();
            int i = 10;
            // kriticen region
            while(i > 0){
                canEnter.release();
                canEnrol.acquire(); // clenot od admn go zapishuva samiot student
                this.enrol();
                shouldLeave.release(); // deka moze studentot da si odi
                i--;
            }
            manageMembers.release();
        }

        public void enrol(){
            System.out.println("Enrol student...");
        }

        @Override
        public void run() {
            try{
                execute();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static class Student extends Thread {
        public void execute() throws InterruptedException {
            // kriticen region
            canEnter.acquire();
            this.giveDocuments();
            canEnrol.release(); // studentot e zapishan
            shouldLeave.acquire(); // znak deka baram dozvola da si odam
        }
        public void giveDocuments(){
            System.out.println("Giving documents...");
        }
        @Override
        public void run() {
            try{
                execute();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }



}

