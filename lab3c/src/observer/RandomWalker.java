package observer;

import java.util.Observable;
import java.util.Random;
//import java.util.Timer;

public class RandomWalker extends Observable {

    private Random r = new Random();
//    private Timer t = new Timer();
    private boolean wentLeft = false;

    // sleepTime is in milliseconds (thousands of a second)
    public void start(int repetitions) {
        for (int i = 0; i < repetitions; i++) {
            walk();
//            try {
//                Thread.sleep(50);     // this waits 50/1000 of a second before repeating
//            } catch (InterruptedException ex) {
//                System.out.println("Got interrupted before the time was up!");
//            }
        }
    }

    private void walk() {
        if (r.nextBoolean()) {
            // walk left
            wentLeft = true;
        } else {
            // walk right
            wentLeft = false;
        }
        setChanged();
        notifyObservers();

    }
    
    public boolean getLeft() {
        return wentLeft;
    }

}
