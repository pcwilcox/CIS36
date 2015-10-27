package prisoner;

import java.util.Random;

public class RandomChooser extends Player {

    public RandomChooser(String name) {
        super(name);
    }

    @Override
    // returns the name and the class in parentheses
    public String toString() {
        return super.toString();
    }

    @Override
    ////// keeping score methods
    public void increaseScore(int amt) {
        super.increaseScore(amt);
    }

    @Override
    public int score() {
        return super.score();
    }

    ////// choice methods
    // provides the players choice for this round, returning true if the
    // player should cooperate, or false otherwise.
    @Override
    public boolean cooperate() {
        Random rand = new Random();
        int choice = rand.nextInt(2);

        if (choice == 0) {
            return true;
        } else {
            return false;
        }
    }

}
