package adventure;

import adventure.items.Item;
import adventure.rooms.Room;
import adventure.command.Command;
import adventure.items.Container;
import adventure.items.Wearable;
import adventure.rooms.Path;
import java.util.ArrayList;

public class Player {

    private World myWorld;
    private Room currentRoom;
    private String myName = "";
    private ArrayList<Item> myItems;
    private ArrayList<Wearable> worn;

    public Player(World world) {
        myWorld = world;
        myItems = new ArrayList<>();
        worn = new ArrayList<>();
    }

    public Player(String name, World world) {
        myName = name;
        myWorld = world;
        myItems = new ArrayList<>();
        worn = new ArrayList<>();
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }

    public Room getCurrentRoom() {
        return (currentRoom);
    }

    ////// Item 
    // returns the item with the name s, or null if there is none    
    public Item getItem(String name) {
        for (Item item : myItems) {
            if (item.getName().equalsIgnoreCase(name) || item.getShort().equalsIgnoreCase(name)) {
                return item;
            }
        }
        for (Item item : currentRoom.getItems()) {
            if (item.getName().equalsIgnoreCase(name) || item.getShort().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public void addWorn(Wearable w) {
        worn.add(w);
    }

    public void removeWorn(Wearable w) {
        if (worn.contains(w)) {
            worn.remove(w);
        }
    }

    public Wearable getWorn(String name) {
        for (Wearable w : worn) {
            if (w.getName().equalsIgnoreCase(name)) {
                return w;
            }
        }
        return null;
    }

    // adds an Item object to the Player
    public void addItem(Item itemToAdd) {
        myItems.add(itemToAdd);
    }

    public void removeItem(Item itemToRemove) {
        int i;
        for (i = 0; i < myItems.size(); i++) {
            if (myItems.get(i).equal(itemToRemove)) {
                myItems.remove(i);
                break;
            }
        }
    }

    //////
    //////   Handle Commands
    //////
    public void dispatch(Command turn) {
        if (turn.isLookRoom()) {
            actionLookRoom();

        } else if (turn.isLookItem()) {
            actionLookItem(turn);
        } else if (turn.isTravel(currentRoom)) {
            actionTravel(turn);

        } else if (turn.isTake()) {
            actionTake(turn);

        } else if (turn.isDrop()) {
            actionDrop(turn);

        } else if (turn.isInventory()) {
            actionInventory();

        } else if (turn.isUse()) {
            actionUse(turn);
        } else if (turn.isPut()) {
            actionPut(turn);

        } else {
            System.out.println("Huh?");
        }
    }

    public void actionPut(Command turn) {
        String itemName = turn.getFirstReference();
        String containerName = turn.getSecondReference();
        Item item = getItem(itemName);
        Item c = getItem(containerName);
        if (item != null && c != null) {
            if (c instanceof Container) {
                Container container = (Container) c;
                container.putItem(item, this);
            } else {
                System.out.println("The " + c.getName() + " is not a container.");
            }

        } else {
            System.out.println("Huh?");
        }
    }

    public void actionTravel(Command turn) {
        String newDir = turn.getDirectionReference();
        Room newRoom = currentRoom.tryToExit(newDir);
        Path path = this.currentRoom.getExit(newDir);
        if (newRoom == null) {
            System.out.println("You can't go that direction from here.");
        } else {
            if (newRoom.enterRoom(path)) {
                currentRoom = newRoom;
            } else {
                System.out.println("You can't go there.");
            }
        }
    }

    public void actionLookRoom() {
        currentRoom.printDescription();
    }

    public void actionLookItem(Command turn) {
        Item item = getItem(turn.getFirstReference());
        if (item != null) {
            System.out.println("You see " + item.getDescription());
        } else {
            System.out.println("Look at what?");
        }
    }

    public void actionTake(Command turn) {
        String itemName = turn.getDropReference();
        Item item = currentRoom.getItem(itemName);
        if (item == null) {
            // item doesn't exist (misspelled, perhaps).
            System.out.println("There is no item " + itemName + "to take");
        } else if (item.take()) {
            currentRoom.removeItem(item);
            addItem(item);
        }
    }

    public void actionDrop(Command turn) {
        String itemName = turn.getDropReference();
        Item itemToDrop = getItem(itemName);
        if (itemToDrop == null) {
            System.out.println("You don't have a " + itemName + " to drop");
        } else if (itemToDrop.drop()) { //an item was specified
            removeItem(itemToDrop);
            currentRoom.addItem(itemToDrop);
        }
    }

    public void actionInventory() {
        printInv();
    }

    private void printInv() {
        if (myItems.size() > 0) {
            System.out.println("You have");
            for (Item item : myItems) {
                System.out.print(" -- ");
                System.out.println(item.getName());
            }
        } else {
            System.out.println("You have nothing!");
        }

    }

    public void actionUse(Command turn) {
        Item item = getItem(turn.getUseReference());
        if (item == null) {
            System.out.println("I don't understand what you want to use.");
            return;
        }
        // items know how to use themselves, although they might need reference to the current room
        // and player.
        boolean usedUp = item.use(currentRoom, this);
        if (usedUp) {
            removeItem(item);
        }
    }

} // end player
