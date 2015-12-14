package adventure.items;

import adventure.Player;
import adventure.rooms.Hatch;
import adventure.rooms.Lift;
import adventure.rooms.Room;


public class ElevatorPanel extends ControlPanel {
    private Lift elevator;
    
    public ElevatorPanel(String name, String description, Hatch target, Lift elevator) {
        super(name, description, target);
        this.elevator = elevator;
    }
    
    
    
    @Override
    public boolean use(Room currentRoom, Player player) {
        
        if (this.getTarget().getTarget().getPressure() == true && currentRoom.getPressure() == true) {
            this.getTarget().setBlocked(false);
            System.out.println("You activate the control panel, and the hatch unlocks.");
            return true;
        }
        System.out.println("The control panel beeps loudly, and the hatch remains locked.");
        return false;
    }
}
