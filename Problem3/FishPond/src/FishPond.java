import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

class Pond implements Runnable{
    int cntMale = 0;
    int cntFemale = 0;
    List<String> fish = new LinkedList<>();
    Pond(){
        for(int i = 0; i < 10; i++){
            fish.add("M");
            fish.add("F");
            this.cntMale = 10;
            this.cntFemale = 10;
        }
    }
    public void print(){
        for(int i = 0; i < fish.size(); i++){
            System.out.print(fish.get(i) + " " );
        }
        System.out.print(" "+ " "+ this.cntMale + " " + this.cntFemale);
        System.out.println();
    }
    public  synchronized void activity(){
            Random ran = new Random();
            int rand1 = (int) (Math.random() * fish.size() - 1) % fish.size();
            int rand2 = (int) (Math.random() * fish.size() - 1) % fish.size();

            String fishOne = fish.get(rand1);
            String fishTwo = fish.get(rand2);
            if (fishOne.equals("M") && fishTwo.equals("M")) {
                fish.remove(rand1);
                fish.remove(rand2);
                if(this.cntMale >= 2)
                    this.cntMale -= 2;
                else if(this.cntMale == 1)
                    this.cntMale -= 1;
            } else if (fishOne.equals("F") && fishTwo.equals("F")) {
                int rand3 = ran.nextInt(2);
                if (rand3 == 0) {
                    fish.remove(rand1);
                } else {
                    fish.remove(rand2);
                }
                this.cntFemale--;
            } else if (fishOne.equals("M") && fishTwo.equals("F")) {
                int rand3 = ran.nextInt(2);
                if (rand3 == 0) {
                    fish.add(fishOne);
                    this.cntMale++;
                } else {
                    fish.add(fishTwo);
                    this.cntFemale++;
                }

            } else if (fishOne.equals("F") && fishTwo.equals("M")) {
                int rand3 = ran.nextInt(2);
                if (rand3 == 0) {
                    fish.add(fishOne);
                    this.cntFemale++;
                } else {
                    fish.add(fishTwo);
                    this.cntMale++;
                }
            }

        print();
    }

    @Override
    public void run() {
        try{
                while(fish.size() >= 1){
                    activity();
                }


        } catch (Exception e){
          System.out.print(e);
        }

    }
}
public class FishPond {
    public static void main(String ...args) throws InterruptedException {
        Pond A = new Pond();
        A.print();
        Thread t1 = new Thread(A);
        Thread t2 = new Thread(A);
        Thread t3 = new Thread(A);
        Thread t4 = new Thread(A);
        Thread t5 = new Thread(A);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t1.join();t2.join();t3.join();t4.join();t5.join();
        A.print();
    }
}
