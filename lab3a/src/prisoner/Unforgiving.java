package prisoner;

public class Unforgiving extends Player {

    private boolean opponentCompeted = false;

    public Unforgiving(String name) {
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
        if (opponentCompeted == true) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    // called by the simulation framework after each turn is completed
    // parameter reflects oppenents choice in that turn.
    public void opponentChoice(boolean opponentCooperated) {
        // default implementation does nothing with this information
        if (opponentCooperated == false) {
            opponentCompeted = true;
        }
    }
}
