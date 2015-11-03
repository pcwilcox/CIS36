/*
 * lab3c
 * observer
 * RandomWalkerObserver.java
 * Created by Pete Wilcox on Nov 2, 2015
 * petercwilcox@gmail.com
 * Copyright © 2015 Pete Wilcox. All rights reserved.
 */
package observer;

import java.util.Observable;
import java.util.Observer;

public class RandomWalkerObserver implements Observer {

    private int steps = 0;
    private int center = 0;
    private int left = 10;
    private int right = -10;

    @Override
    public void update(Observable o, Object arg) {
        if (o != null) {
            if (o instanceof RandomWalker) {
                steps++;
                RandomWalker r = (RandomWalker) o;
                
                if (r.getLeft() == true) {
                    center++;
                } else {
                    center--;
                }
                
                if (center == right) {
                    System.out.println("The walker reached " + (right * -1) + " spaces to the right after " + steps + " steps.");
                    right -= 10;
                } else if (center == left) {
                    System.out.println("The walker reached " + left + " spaces to the left after " + steps + " steps.");
                    left += 10;
                }
                
            } else {
                throw new ClassCastException();
            }
        } else {
            throw new NullPointerException();
        }
    }

}
