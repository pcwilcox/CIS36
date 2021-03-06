package adventure.rooms;

import adventure.items.Item;
import java.util.ArrayList;

public class Room {

    // protected because subclasses can get to it...
    protected String name;
    protected String description;

    // Rooms that aren't pressurized require a spacesuit
    protected boolean pressure;

    protected ArrayList<Path> exits;
    protected ArrayList<Item> items;

    // constructor.
    public Room(String name, String desc) {
        this.name = name;
        this.description = desc;
        exits = new ArrayList<>();
        items = new ArrayList<>();
    }

    // setters and getters
    public void setDescription(String newDesc) {
        this.description = newDesc;
    }

    // adds a path from this room
    public void addExit(Room target, String dir) {
        Path path = new Path(this, target, dir);
        exits.add(path);
    }

    // Adds a hatch instead of an exit
    // Checks getPressure() on both sides in order to automatically seal the hatch
    public void addHatch(Room target, String dir) {
        boolean sealed = true;
        if (target.getPressure() == true && this.getPressure() == true) {
            sealed = false;
        }

        Hatch hatch = new Hatch(this, target, dir, sealed);

        exits.add(hatch);
    }

    // Adds a hatch instead of an exit
    // This overloaded version allows sealed to be set manually
    public void addHatch(Room target, String dir, boolean sealed) {
        Hatch hatch = new Hatch(this, target, dir, sealed);

        exits.add(hatch);
    }

    public boolean getPressure() {
        return pressure;
    }

    public void printDescription() {
        System.out.println(description);
        printItems();
        printExits();
    }

    public String getName() {
        return name;
    }
    
    ////// Movement
    //////
    // method that gets called when you first enter a room; returns a boolean
    // indicating whether entry was sucessful.
    // This might get overridden by subclasses if something fancy should happen.
    public boolean enterRoom(Path p) {
        if (p.getBlocked()) {
            return false;
        }
        printDescription();
        return true;
    }

    // Returns a boolean indicating a successful exit.  This version
    //  does nothing, but subclasses might override this.
    public boolean exitRoom() {
        return true;
    }

    // When the player tries to move, it calls its room's tryToExit method.
    // This method returns null if unsuccessful. Otherwise, it returns the
    // room that the player has moved to.
    public Room tryToExit(String direction) {
        //check if this is a valid direction
        Path path = getExit(direction);
        if (path != null) {
            if (path.getTarget().enterRoom(path)) {
                return path.getTarget();
            } else {
                path.printBlocked();
                return this;
            }
        }
        return null;
    }

    // returns the path object if the argument is a direction to that path.
    //  if no such direction exists, returns null.
    public Path getExit(String possibleExit) {
        for (Path p : exits) {
            if (p.getDirection().equalsIgnoreCase(possibleExit)) {
                return p;
            }
        }
        return null;
    }

    // Overloaded method returns the connecting hatchway
    public Path getExit(Room target) {
        for (Path p : exits) {
            if (p.getTarget().equals(target)) {
                return p;
            }
        }
        return null;
    }

    public void printExits() {
        if (exits.isEmpty()) {
            System.out.println("There are no exits, and therefore no way out of here!");
        } else {
            int i = 0;
            System.out.print("The exits are ");
            for (Path p : exits) {
                if (p instanceof Hatch) {
                    System.out.print("a hatch leading to ");
                }
                System.out.print(p.getDirection());
                i++;
                if (i != exits.size()) {
                    System.out.print(", ");
                } else {
                    System.out.print(".");
                }
                if (i == (exits.size() - 1)) {
                    System.out.print("and ");
                }
            }
            System.out.println();
        }
    }
    
    public ArrayList<Path> getPaths() {
        return exits;
    }

    //////  Items
    //////
    public void addItem(Item item) {
        items.add(item);
    }

    public Item getItem(String possibleName) {
        for (Item item : items) {
            if (item.isReference(possibleName)) {
                return item;
            }
        }
        return null;
    }

    public void removeItem(Item itemToRemove) {
        int i;
        for (i = 0; i < items.size(); i++) {
            if (items.get(i).equal(itemToRemove)) {
                items.remove(i);
                break;
            }
        }
    }
    
    public ArrayList<Item> getItems() {
        return items;
    }

    // this prints a nice comma separated list of items.  
    protected void printItems() {
        if (items.isEmpty()) {
            return;
        }
        int i;
        System.out.print("There is ");
        // do the first set of items up to the second to last
        for (i = 0; i < (items.size() - 1); i++) {
            System.out.print("a ");
            items.get(i).printInventoryItem();
            System.out.print(", ");
        }
        if (items.size() >= 2) {
            System.out.print("and ");
        }
        System.out.print("a ");
        items.get(i).printInventoryItem();
        System.out.println(" here.");
    }

    // Recursion! Sets the pressure in the current room, then 
    public boolean setPressure(boolean p) {
        if (this.isSpace() == false) {
            pressure = p;

            for (Path h : exits) {
                if (h.getOpen() == true) {
                    // connecting path is open

                    if (h.getTarget().isSpace() != true) {
                        // and the target room isn't space

                        // set the pressure in the target room = p and return the value
                        return h.getTarget().setPressure(p);
                    } else {
                        // There is an open pathway to space, so you can't pressurize
                        return false;
                    }
                } else {
                    // Closed hatch returns true
                    return true;
                }
            }

            // If we somehow make a room with no exits, return true
            return true;
        } else {
            // If you're in space, pressure is always false
            return false;
        }

    }

    // Subclasses override this
    public boolean isSpace() {
        return false;
    }

} // end Room
