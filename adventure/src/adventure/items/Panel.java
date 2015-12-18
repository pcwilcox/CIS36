package adventure.items;

import adventure.Player;
import adventure.rooms.Room;
import java.util.ArrayList;

// A panel is a stationary object that allows the player to interact with 
// something, like a room, door, or item. It may require another
public class Panel extends Stationary {

    private Usable target;
    private ArrayList<Item> required;
    

    public Panel(String name, String desc, Usable t) {
        super(name, desc);
        target = t;
        required = new ArrayList<>();
        this.setShort("panel");
    }

    public Panel(String name, String desc, Usable t, Item r) {
        super(name, desc);
        target = t;
        required = new ArrayList<>();
        required.add(r);
    }

    public void setTarget(Usable t) {
        target = t;
    }

    public Usable getTarget() {
        return target;
    }

    public void addRequired(Item i) {
        required.add(i);
    }

    public ArrayList<Item> getRequired() {
        return required;
    }

    @Override
    public boolean use(Room currentRoom, Player p) {
        int hasRequired = 0;
        
        // For each required item
        for (Item r : required) {
            // If the player has it in inventory
            if (p.getItem(r.getName()) != null) {
                hasRequired++;
            }
            
            // Or if it's just in the room
            if (p.getCurrentRoom().getItem(r.getName()) != null) {
                hasRequired++;
            }
        }
        
        if (hasRequired == required.size()) {
            return target.use();
        }
        return false;
    }
}
