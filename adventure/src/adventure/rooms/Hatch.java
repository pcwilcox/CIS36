package adventure.rooms;

import adventure.rooms.Path;
import adventure.rooms.Room;

/* Most paths between compartments have hatches between them. In normal operation
   they will open automatically, but since this is an emergency...
*/
public class Hatch extends Path {
    
    // True if there is something preventing the hatch from opening (like a room
    // with pressure = false on the other side)
    private boolean sealed;
    
    
    public Hatch(Room source, Room target, String dir, boolean sealed) {
        super(source, target, dir);
        this.sealed = sealed;
    }
    
    
    public boolean openHatch() {
        if (sealed) {
            return false;
        }
        return true;
    }
    
    /* placeholder: add a check for things like 'player has spacesuit' or 
        'target room has pressure now'
    */
    public boolean unseal() {
        if (true) { 
            return true;
        }
        return false;
    }
}
