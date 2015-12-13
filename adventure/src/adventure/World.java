package adventure;

import adventure.rooms.Room;
import adventure.command.Command;
import java.util.*;
import java.io.*;

// The world contains the rooms, the player, and where the player is
public class World {

    private ArrayList<Room> rooms;
    private Player thePlayer;

    private boolean isPlaying;

    public static void main(String[] args) {
        World theWorld = new World();
        theWorld.play();
    }

    //////
    ////// Setup (populate the world)
    //////
    public World() {
        rooms = new ArrayList<Room>();
        thePlayer = new Player(this);

        // create the items
        //create and add rooms
        Room bridge = new Room("Main Bridge",
                "You are on the bridge");
        addRoom(bridge);

        Room navConsole = new Room("Nav Console",
                "The nav console on the bridge");
        addRoom(navConsole);

        Room captainChair = new Room("Captain's Chair",
                "The captain's chair");
        addRoom(captainChair);

        Room bridgeComputer = new Room("Bridge Computer",
                "The bridge's main computer screen");
        addRoom(bridgeComputer);

        Room corridorUpperForward = new Room("Main Corridor - Upper Deck - Forward Section",
                "The forward section of the main corridor");
        addRoom(corridorUpperForward);

        Room corridorUpperPort = new Room("Main Corridor - Upper Deck - Port Section",
                "The port section of the main corridor");
        addRoom(corridorUpperPort);

        Room corridorUpperStarboard = new Room("Main Corridor - Upper Deck - Starboard Section",
                "The starboard section of the main corridor");
        addRoom(corridorUpperStarboard);

        Room corridorUpperAft = new Room("Main Corridor - Upper Deck - Aft Section",
                "The aft section of the main corridor");
        addRoom(corridorUpperAft);

        Room corridorLowerForward = new Room("Main Corridor - Lower Deck - Forward Section",
                "The forward section of the main corridor");
        addRoom(corridorLowerForward);

        Room corridorLowerPort = new Room("Main Corridor - Lower Deck - Port Section",
                "The port section of the main corridor");
        addRoom(corridorLowerPort);

        Room corridorLowerStarboard = new Room("Main Corridor - Lower Deck - Starboard Section",
                "The starboard section of the main corridor");
        addRoom(corridorLowerStarboard);

        Room corridorLowerAft = new Room("Main Corridor - Lower Deck - Aft Section",
                "The aft section of the main corridor");
        addRoom(corridorLowerAft);

        Room engineering = new Room("Main Engineering",
                "The main engineering compartment");
        addRoom(engineering);

        Room cargo = new Room("Main Cargo Hold",
                "The main cargo hold");
        addRoom(cargo);

        Room engine = new Room("Main Engineering - Engine",
                "The main engine");
        addRoom(engine);

        Room lifeSupport = new Room("Main Engineering - Life Support",
                "Life support controls");
        addRoom(lifeSupport);

        Room cryo1 = new Room("CryoSleep One - Upper Deck - Starboard",
                "Upper starboard cryo chamber");
        addRoom(cryo1);

        Room cryo2 = new Room("CryoSleep Two - Upper Deck - Port",
                "Upper port cryo chamber");
        addRoom(cryo2);

        Room cryo3 = new Room("CryoSleep Three - Lower Deck - Starboard",
                "Lower starboard cryo chamber");
        addRoom(cryo3);

        Room cryo4 = new Room("CryoSleep Three - Lower Deck - Port",
                "Lower port cryo chamber");
        addRoom(cryo4);

        //connect the rooms
        bridge.addExit(corridorUpperForward, "out");
        bridge.addExit(navConsole, "Navigation Console");
        bridge.addExit(captainChair, "Captain's Chair");
        bridge.addExit(bridgeComputer, "Main Computer");

        navConsole.addExit(bridge, "Bridge");
        
        captainChair.addExit(bridge, "Bridge");
        
        bridgeComputer.addExit(bridge, "Bridge");
        
        corridorUpperForward.addExit(bridge, "Bridge");
        corridorUpperForward.addExit(corridorUpperPort, "port");
        corridorUpperForward.addExit(corridorUpperStarboard, "starboard");
        
        corridorUpperPort.addExit(corridorUpperForward, "forward");
        corridorUpperPort.addExit(corridorUpperAft, "aft");
        corridorUpperPort.addExit(cryo2, "Cryo 2");
        
        corridorUpperStarboard.addExit(corridorUpperForward, "forward");
        corridorUpperStarboard.addExit(corridorUpperAft, "aft");
        corridorUpperStarboard.addExit(cryo1, "Cryo 1");
        
        corridorUpperAft.addExit(corridorUpperStarboard, "starboard");
        corridorUpperAft.addExit(corridorUpperPort, "port");

        corridorLowerForward.addExit(cargo, "cargo hold");
        corridorLowerForward.addExit(corridorLowerPort, "port");
        corridorLowerForward.addExit(corridorLowerStarboard, "starboard");
        
        corridorLowerPort.addExit(corridorLowerForward, "forward");
        corridorLowerPort.addExit(corridorLowerAft, "aft");
        corridorLowerPort.addExit(cryo4, "cryo");

        corridorLowerStarboard.addExit(corridorLowerForward, "forward");
        corridorLowerStarboard.addExit(corridorLowerAft, "aft");
        corridorLowerStarboard.addExit(cryo3, "cryo 3");

        corridorLowerAft.addExit(corridorLowerPort, "port");
        corridorLowerAft.addExit(corridorLowerStarboard, "starboard");
        corridorLowerAft.addExit(engineering, "engineering");
        
        engineering.addExit(corridorLowerAft, "out");
        engineering.addExit(engine, "engine");
        engineering.addExit(lifeSupport, "life support");
        
        cargo.addExit(corridorLowerForward, "out");
        
        engine.addExit(engineering, "out");
        
        lifeSupport.addExit(engineering, "out");
        
        cryo1.addExit(corridorUpperStarboard, "out");
        
        cryo2.addExit(corridorUpperPort, "out");

        cryo3.addExit(corridorLowerStarboard, "out");
        
        cryo4.addExit(corridorLowerPort, "out");

        // set current position
        setCurrentRoom(rooms.get(0));

    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room getCurrentRoom() {
        return thePlayer.getCurrentRoom();
    }

    public void setCurrentRoom(Room room) {
        thePlayer.setCurrentRoom(room);
    }

    //////
    ////// Gameplay
    //////
    public void play() {

        isPlaying = true;
        printWelcome();

        // ... and start playing!
        while (isPlaying) {

            Command turn = new Command();    // read user input
            dispatch(turn);
        }

        //stopped
        printGoodBye();
    }

    private void printWelcome() {
        System.out.println("Welcome to Damage Control. \n"
                + "You are the engineer aboard the  the starship Aasimov. The \n"
                + "ship was carrying passengers in cryo-sleep on a journey to Europa, \n"
                + "one of Jupiter's moons. You would not be woken up during a normal \n"
                + "transit except in cases of malfunction or emergency.\n\n"
                + "You are surprised to be awakened well ahead of scheduled arrival. \n"
                + "The sound of warning klaxons fills the air amidst the flashing \n"
                + "emergency lighting. This can't be good.\n\n"
                + "You will need to find and repair any damage to the ship, then re-enable \n"
                + "the autopilot in order to succeed. Good luck."
        );
        System.out.println();
        getCurrentRoom().printDescription();
    }

    private void printGoodBye() {
        System.out.println("Bye!");
    }

    // called by other objects (rooms, player) when they've decided the game should end.
    public void gameOver() {
        isPlaying = false;
    }

    /////
    ///// Handle commands
    /////
    // handle administrative commands, or dispatch to player to handle gameplay commands
    private void dispatch(Command turn) {
        if (turn.isHelp()) {
            actionHelp();
        } else if (turn.isQuit()) {
            actionQuit();
        } else {
            thePlayer.dispatch(turn);
        }
    }

    private void actionHelp() {
        System.out.println("Try using simple verbs in order to do things. Only one or");
        System.out.println("two words will be recognized.");
        System.out.println();
        System.out.println("For example, type 'look' to look around, or 'north' to move to");
        System.out.println("the north. ");
    }

    private void actionQuit() {
        gameOver();
    }

}  // end World class

