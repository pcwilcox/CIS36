package adventure.items;

import adventure.Player;
import java.util.ArrayList;

// A bag is a container that is takeable and wearable (a backpack, for example)
public class Bag extends Takeable implements Wearable, Container {

    // A bag has its own inventory
    private ArrayList<Item> items;

    // Maximum number of items it can hold
    private int capacity;

    public Bag(String name, String description, int cap) {
        super(name, description);
        items = new ArrayList<>();
        capacity = cap;
        this.setShort("bag");
    }
    
    @Override
    public boolean isFull() {
        if (items.size() == capacity) {
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Name: " + super.getName() + ", Desc: " + super.getDescription() + ", Cap: " + capacity;
    }

    @Override
    public void printItems() {
        if (items.isEmpty()) {
            System.out.println("The " + super.getName() + " is empty.");
        } else {
            System.out.println("The " + super.getName() + " contains: ");
            for (Item i : items) {
                System.out.println(i.getName());
            }
        }
    }
    
    // Need to examine Command to figure out how this works
    @Override
    public boolean getItem(String name, Player p) {
        for (Item i : items) {
            if (i.isReference(name)) {
                p.addItem(i);
                items.remove(i);
                return true;
            }
        }
        
        return false;
    }
    
    // This is really gonna be addItem() but I'm not sure how to work with command yet
    @Override
    public boolean putItem(Item i, Player p) {
        if (items.size() < capacity) {
            items.add(i);
            p.removeItem(i);
            System.out.println("You put the " + i.getName() + " in the " + this.getName() + ".");
            return true;
        }
        System.out.println("There is not enough room in the " + this.getName() + ".");
        return false;
    }
    
    
    @Override
    public boolean wear(Player p) {
        if (p.getItem(this.getName()) != null) {
            p.addWorn(this);
            p.removeItem(this);
            System.out.println("You wear the " + this.getName() + ".");
            return true;
        }
        
        System.out.println("You need to pick up the " + this.getName() + " first!");
        return false;
    }

    @Override
    public boolean remove(Player p) {
        if (p.getWorn(this.getName()) != null) {
            p.addItem(this);
            p.removeWorn(this);
            System.out.println("You remove the " + this.getName() + ".");
        }
        System.out.println("You can't remove something you aren't wearing!");
        return false;
    }

    // Put an item in the bag
    public boolean addItem(Item i, Player p) {
        if (i == null) {
            throw new NullPointerException();
        } else if (i.canTake()) {
            if (items.size() < capacity) {
                items.add(i);
                p.removeItem(i);
                return true;
            } else {
                System.out.println("There isn't enough room in the " + this.getName() + ".");
                return false;
            }

        } else {
            System.out.println("You cannot put the " + i.getName() + " in the " + this.getName() + ".");
            return false;
        }
    }

    public boolean removeItem(Item i) {
        if (i == null) {
            throw new NullPointerException();
        } else if (items.contains(i)) {
            // somehow get an item out of the bag

            return true;
        } else {
            System.out.println("There is no " + i.getName() + "in the " + this.getName() + ".");
            return false;
        }
    }
}
