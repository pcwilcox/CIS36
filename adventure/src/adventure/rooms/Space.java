package adventure.rooms;

// Space is a type of room with some special behaviors - some items will work
// differently, pressure = false, etc.

public class Space extends Room {
    
    public Space(String name, String desc) {
        super(name, desc);
    }
    
    @Override
    public boolean getPressure() {
        return false;
    }
    
    @Override
    public boolean isSpace() {
        return true;
    }
}
