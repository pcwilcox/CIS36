package adventure.rooms;

public class Path {
    
    private Room source;
    private Room target;
    private String direction;
    private String description;
    protected String blockDescription;
    protected boolean blocked = false;
    
    public Path(Room source, Room target, String dir) {
        setSource(source);
        setTarget(target);
        setDirection(dir);
    }

    public void setSource(Room source) {
        this.source = source;
    }

    public Room getSource() {
        return source;
    }

    public void setTarget(Room target) {
        this.target = target;
    }

    public Room getTarget() {
        return target;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

    // returns the Room that the player traveling this path arrives at
    public Room travelDestination() {
        return target;
    }

    // If there's like debris blocking the path or something
    public void setBlocked(boolean b) {
        blocked = b;
    }
    
    public boolean getBlocked() {
        return blocked;
    }
    
    // Prints reason the path is blocked    
    public void printBlocked() {
        System.out.println(blockDescription);
    }
    
    public String getBlockDescription() {
        return blockDescription;
    }
    
    public void setBlockDescription(String desc) {
        blockDescription = desc;
    }
    
    // subclass hatch overrides this
    public boolean getOpen() {
        return true;
    }
}  // end class Path
