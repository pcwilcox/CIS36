package prisoner;

public class Simulation {

    final static boolean PROVIDE_INFORMATION_PER_TURN = false;

    /////////////// constructors
    public Simulation(Player p1, Player p2) {
        this(p1, p2, 200);
    }

    // Runs a simulation of two players playing for a specified number
    // of turns.  Will report scores at the end.
    public Simulation(Player p1, Player p2, int numberOfTurns) {

        // First turn starts as cooperating
        p1.opponentChoice(true);
        p2.opponentChoice(true);

        for (int k = 0; k < numberOfTurns; k++) {

            boolean p1Cooperated = p1.cooperate();
            boolean p2Cooperated = p2.cooperate();

            p1.opponentChoice(p2Cooperated);
            p2.opponentChoice(p2Cooperated);

            if (p1Cooperated) {
                if (p2Cooperated) {
                    p1.increaseScore(3);
                    p2.increaseScore(3);
                } else {
                    p1.increaseScore(0);
                    p2.increaseScore(5);
                }
            } else {
                if (p2Cooperated) {
                    p1.increaseScore(5);
                    p2.increaseScore(0);
                } else {
                    p1.increaseScore(1);
                    p2.increaseScore(1);
                }
            }

            if (PROVIDE_INFORMATION_PER_TURN) {
                System.out.println("Turn " + k + ": " + p1 + " " + p1Cooperated + "(score = " + p1.score() + "), " + p2 + " " + p2Cooperated + "(score = " + p2.score() + ")");
            }

            p1.opponentChoice(p2Cooperated);
            p2.opponentChoice(p1Cooperated);
        }

        System.out.println("\nGame over, " + numberOfTurns + " turns:");
        System.out.println(" Player 1 (" + p1.getClass().getName() + ") has score = " + p1.score());
        System.out.println(" Player 2 (" + p2.getClass().getName() + ") has score = " + p2.score());
    }

    public static void main(String[] args) {
        Simulation s = new Simulation(new Cooperator("Cooperator1"), new Cooperator("Cooperator"), 20);
        Simulation a = new Simulation(new Cooperator("Cooperator"), new Competitor("Competitor2"), 20);
        Simulation b = new Simulation(new Cooperator("Cooperator"), new RandomChooser("RandomChooser2"), 20);
        Simulation c = new Simulation(new Cooperator("Cooperator"), new Unforgiving("Unforgiving2"), 20);
        Simulation d = new Simulation(new Cooperator("Cooperator"), new TitForTat("TitForTat2"), 20);
        Simulation k = new Simulation(new Competitor("Competitor1"), new Competitor("Competitor2"), 20);
        Simulation e = new Simulation(new Competitor("Competitor1"), new RandomChooser("RandomChooser2"), 20);
        Simulation f = new Simulation(new Competitor("Competitor1"), new Unforgiving("Unforgiving2"), 20);
        Simulation g = new Simulation(new Competitor("Competitor1"), new TitForTat("TitForTat2"), 20);
        Simulation m = new Simulation(new RandomChooser("RandomChooser1"), new RandomChooser("RandomChooser2"), 20);
        Simulation h = new Simulation(new RandomChooser("RandomChooser1"), new Unforgiving("Unforgiving2"), 20);
        Simulation i = new Simulation(new RandomChooser("RandomChooser1"), new TitForTat("TitForTat2"), 20);
        Simulation n = new Simulation(new Unforgiving("Unforgiving1"), new Unforgiving("Unforgiving2"), 20);
        Simulation j = new Simulation(new Unforgiving("Unforgiving1"), new TitForTat("TitForTat2"), 20);

        Simulation o = new Simulation(new TitForTat("TitForTat1"), new TitForTat("TitForTat2"), 20);
    }
}
