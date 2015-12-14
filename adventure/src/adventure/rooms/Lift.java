package adventure.rooms;

import java.util.ArrayList;


/* A lift is a Room that can change its location. It does this via the method
 changeDeck(), which changes the exits according to the list defined in 
 ArrayList decks.
 */
public class Lift extends Room {

    private Room currentDeck;

    private ArrayList<Room> decks;

    public Lift(String name, String desc) {
        super(name, desc);
        decks = new ArrayList<Room>();
    }

    public Lift(String name, String desc, Room deck) {
        super(name, desc);
        decks = new ArrayList<Room>();
        currentDeck = deck;
        super.addHatch(deck, "out");
        decks.add(deck);
    }
    
    public void removeExit(Room target) {
        for (Path p : exits) {
            if (p.getTarget() == target) {
                exits.remove(p);
            }
        }
    }
    
    public void addDeck(Room deck) {
        decks.add(deck);
    }

    @Override
    public void printExits() {
        if (currentDeck != null) {
            System.out.println("The lift is currently on " + currentDeck);
        }
    }

    // Intended to work with a control terminal of some kind
    public void changeDeck(Room newDeck) {
        if (decks.contains(newDeck)) {
            // TODO: figure out how to lock the hatch from the other room
            this.removeExit(currentDeck);
            currentDeck = newDeck;
            super.addExit(newDeck, "out");
            
            System.out.println("The lift shudders slightly as it changes decks to " + newDeck.name);
        }
    }
    
    // This one doesn't report anything because it's to be used when the player
    // isn't actually in the lift (so they don't see the description of the change)
    public void setDeck(Room newDeck) {
        if (decks.contains(newDeck)) {
            currentDeck = newDeck;
            
        }
    }
    
    // The control terminal will call this to generate its menu - this way the
    // lift can also be moved using the central computer or something
    public ArrayList<Room> getDecks() {
        return decks;
    }
}
