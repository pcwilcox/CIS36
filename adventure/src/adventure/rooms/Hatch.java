package adventure.rooms;

// A hatch is a type of path with a pressure-tight door. It can be closed, blocking
// the exit - this happens automatically if the other side is unsafe (no atmosphere,
// room is on fire, the lift has moved to another deck, etc). Some hatches will begin
// sealed, and the player will need to open them.

// Hatches will show on the list of exits as hatches with a description of what's
// on the other side. They can be manipulated with control panels.

public class Hatch extends Path {

    
    public Hatch(Room source, Room target, String dir) {
        super(source, target, dir);
        this.blocked = false;
        super.setBlockDescription("The hatch does not open.");
    }
    
    public Hatch(Room source, Room target, String dir, boolean sealed) {
        super(source, target, dir);
        this.blocked = sealed;
        super.setBlockDescription("The hatch does not open.");
    }
    
    
}
