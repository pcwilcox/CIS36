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
        
        Room bridge = new Room("Main Bridge", "placeholder text");
        

        
        //connect the rooms

        
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
        System.out.println("Welcome to Damage Control. \n" +
                "You are the engineer aboard the  the starship Aasimov. The \n" +
                "ship was carrying passengers in cryo-sleep on a journey to Europa, \n" +
                "one of Jupiter's moons. You would not be woken up during a normal \n" +
                "transit except in cases of malfunction or emergency.\n\n" +
                "You are surprised to be awakened well ahead of scheduled arrival. \n" +
                "The sound of warning klaxons fills the air amidst the flashing \n" +
                "emergency lighting. This can't be good.\n\n" +
                "You will need to find and repair any damage to the ship, then re-enable \n" +
                "the autopilot in order to succeed. Good luck."
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

