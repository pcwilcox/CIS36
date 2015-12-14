package adventure.items;

import adventure.Player;
import adventure.rooms.*;

// Big change - control panels just control things. A hatch panel is a control panel that controls a hatch

// A control panel is an item used to control a hatch. It cannot be taken. When
// used, it will be unblock a hatch as long as conditions allow it. Subclasses
// will do other stuff too (like cycle an airlock or call an elevator)
public class HatchPanel extends ControlPanel implements Panel {
    private Hatch target;
    
    public HatchPanel(String name, String description) {
        super(name, description);
    }
    
    public HatchPanel(String name, String description, Hatch target) {
        super(name, description, target);
    }
    
    @Override
    public boolean use(Room currentRoom, Player player) {
        if (this.target.getOpen()) { // If the hatch is open, close it
            
            target.setOpen(false);
            getOther().setOpen(false);
            return true;
        } else {
        if (this.target.getTarget().getPressure() == true && currentRoom.getPressure() == true) {
            this.target.setBlocked(false);
            System.out.println("You activate the control panel, and the hatch opens.");
            target.setOpen(true);
            getOther().setOpen(true);
            return true;
        }
        System.out.println("The control panel beeps loudly, and the hatch remains locked.");
        return false;
        }
    }
    
    // Returns the other side of the hatch this is connected to
    public Hatch getOther() {
        if (target.getTarget().getExit(this.target.getSource()) != null) {
            return (Hatch)target.getTarget().getExit(this.target.getSource());
        } else {
            return null;
        }
    }
    
    @Override
    public Object getTarget() {
        return target;
    }
    
    @Override
    public void setTarget(Object t) {
        if (t == null) {
            throw new NullPointerException();
        } else if (t instanceof Hatch) {
            target = (Hatch)t;
        } else {
            throw new ClassCastException();
        }
    }
}
