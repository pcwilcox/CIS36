
package observer;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Timer;


public class RandomWalker extends Observable {
    
    private Random r = new Random();
    private Timer t = new Timer();
    private boolean changed = false;
    
    // sleepTime is in milliseconds (thousands of a second)
    public void start(int repetitions) {
        for (int i=0; i<repetitions; i++) {
            walk();
            try {
                Thread.sleep(50);     // this waits 50/1000 of a second before repeating
            } catch (InterruptedException ex) {
                System.out.println("Got interrupted before the time was up!");
            }
        }
    }
    
    @Override
    public void addObserver(Observer o) {
        if (o == null) {
            throw new NullPointerException();
        } else {
            
        }
    }
    
    private void walk() {
        if (r.nextBoolean()) {
            // walk left
        } else {
            // walk right
        }
    }
    

}
