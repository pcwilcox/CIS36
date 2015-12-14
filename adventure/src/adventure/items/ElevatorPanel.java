package adventure.items;

import adventure.Player;
import adventure.rooms.Hatch;
import adventure.rooms.Lift;
import adventure.rooms.Room;


public class ElevatorPanel extends HatchPanel {
    private final Lift elevator;
    
    public ElevatorPanel(String name, String description, Hatch target, Lift elevator) {
        super(name, description, target);
        this.elevator = elevator;
    }
    
    
    
    @Override
    public boolean use(Room currentRoom, Player player) {
        
        return false;
    }
}
