package adventure.items;

import adventure.Player;
import adventure.rooms.*;

// A control panel is an item used to control a hatch. It cannot be taken. When
// used, it will be unblock a hatch as long as conditions allow it. Subclasses
// will do other stuff too (like cycle an airlock or call an elevator)
public class ControlPanel extends Item {
    private Hatch target;
    
    public ControlPanel(String name, String description) {
        super(name, description, false);
    }
    
    public ControlPanel(String name, String description, Hatch target) {
        super(name, description, false);
        this.target = target;
    }
    
    public Hatch getTarget() {
        return target;
    }
    
    
    @Override
    public boolean use(Room currentRoom, Player player) {
        if (this.target.getTarget().getPressure() == true && currentRoom.getPressure() == true) {
            this.target.setBlocked(false);
            System.out.println("You activate the control panel, and the hatch unlocks.");
            return true;
        }
        System.out.println("The control panel beeps loudly, and the hatch remains locked.");
        return false;
    }
    
}
