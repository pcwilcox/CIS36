package adventure.items;

import java.util.ArrayList;

// A bag is a container for items that can be worn or carried, like a backpack
public class Bag extends Takeable implements Wearable {

    // A bag has its own inventory

    private ArrayList<Item> items;

    // Maximum number of items it can hold
    private int capacity;

    public Bag(String name, String description, int cap) {
        super(name, description);
        items = new ArrayList<Item>();
        capacity = cap;
    }

    @Override
    public boolean wear() {
        // something
        return false;
    }

    @Override
    public boolean remove() {
        // something
        return false;
    }

    // Put an item in the bag
    public boolean addItem(Item i) {
        if (i == null) {
            throw new NullPointerException();
        } else if (i instanceof Takeable) {
            if (items.size() < capacity) {
                items.add(i);
                // figure out how to remove the item from wherever it came from
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
