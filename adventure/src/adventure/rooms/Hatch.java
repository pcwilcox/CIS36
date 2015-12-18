package adventure.rooms;

import adventure.items.Usable;

// A hatch is a type of path with a pressure-tight door. It can be closed, blocking
// the exit. Some hatches will begin sealed, and the player will need to open them.
// Hatches will show on the list of exits as hatches with a description of what's
// on the other side. They can be manipulated with control panels.
public class Hatch extends Path implements Usable {

    boolean open;
    boolean canUse;

    public Hatch(Room source, Room target, String dir) {
        super(source, target, dir);
        this.blocked = false;
        canUse = true;
    }

    public Hatch(Room source, Room target, String dir, boolean sealed) {
        super(source, target, dir);
        open = false;
        this.blocked = sealed;
        super.setBlockDescription("The hatch does not open.");
        canUse = true;
    }

    @Override
    public void setUse(boolean use) {
        canUse = use;
    }

    public void setOpen(boolean o) {
        open = o;
    }

    @Override
    public boolean getOpen() {
        return open;
    }

    @Override
    public boolean use() {
        // If it's not locked
        if (canUse) {
            
            // If it's open
            if (open) {
                
                // Close it
                open = false;
                
                System.out.println("The hatch closes.");

                // Attempt to repressurize
                if (super.getSource().getPressure() == false) {
                    super.getSource().setPressure(true);
                    
                    // If it's successful
                    if (super.getSource().getPressure()) {
                        System.out.println("You hear a hissing as the environment systems repressurize the compartment.");
                    }
                }
                
                return true;
            } else {
                // Open it
                open = true;
                
                // If you open a compartment to space, bad things happen
                super.getSource().setPressure(super.getTarget().getPressure());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canUse() {
        return canUse;
    }

}
