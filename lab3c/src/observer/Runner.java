
package observer;

import java.util.Observer;


public class Runner {
    
    public static void main(String[] args) {
        RandomWalker source = new RandomWalker();
        Observer observer = new RandomWalkerObserver();
        source.addObserver(observer);
        source.start(1000);
        
    }
            
}
