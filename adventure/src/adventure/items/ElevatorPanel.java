package adventure.items;

import adventure.rooms.Hatch;
import adventure.rooms.Lift;


public class ElevatorPanel extends ControlPanel {
    private Lift elevator;
    
    public ElevatorPanel(String name, String description, Hatch target, Lift elevator) {
        super(name, description, target);
        this.elevator = elevator;
    }
    
    
}
