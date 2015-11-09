package prisoner;

public class Cooperator extends Player {

    public Cooperator(String name) {
        super(name);
    }

    // returns the name and the class in parentheses
    @Override
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

    // Cooperator always cooperates
    @Override
    public boolean cooperate() {
        return true;
    }

    @Override
    public void opponentChoice(boolean opponentCooperated) {
        
    }
}
