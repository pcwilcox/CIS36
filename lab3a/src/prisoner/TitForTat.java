package prisoner;

public class TitForTat extends Player {

    private boolean opponentCooperated = true;

    public TitForTat(String name) {
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
        return opponentCooperated;
    }

    @Override
    // called by the simulation framework after each turn is completed
    // parameter reflects oppenents choice in that turn.
    public void opponentChoice(boolean opponentCooperated) {
        // default implementation does nothing with this information
        this.opponentCooperated = opponentCooperated;
    }
}
