package adventure.rooms;

// Space is a type of room with some special behaviors - some items will work
import adventure.items.Item;

// differently, pressure = false, etc.
public class Space extends Room {

    public Space(String name, String desc) {
        super(name, desc);
    }

    @Override
    public boolean getPressure() {
        return false;
    }

    // Recursion! This override method is a bit simpler
    @Override
    public boolean setPressure(boolean p) {

        // Space never has pressure, and the same counts for any room with an
        // open pathway to it
        for (Path h : exits) {
            if (h.getOpen() == true) {
                // connecting path is open

                return h.getTarget().setPressure(false);
            }
        }

        // Space always returns false
        return false;
    }

    @Override
    public boolean isSpace() {
        return true;
    }

    @Override
    protected void printItems() {
        // When you drop stuff in space it floats away
    }
    
    // getItem() always returns null in space - don't drop things here
    @Override
    public Item getItem(String possibleName) {
        return null;
    }

    // You cannot remove items from here
    @Override
    public void removeItem(Item itemToRemove) {
    }
}
