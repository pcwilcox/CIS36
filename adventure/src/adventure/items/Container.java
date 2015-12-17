package adventure.items;

import java.util.ArrayList;

// Containers are items that can hold other items
public interface Container {
    ArrayList<Item> items = null;
    int capacity = 0;
    
    public abstract boolean putItem(Item i);
    public abstract Item getItem(String name);
    public abstract void printItems();
    
}
