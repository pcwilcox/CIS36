package adventure.items;

import adventure.Player;

// A container is an item that holds other items
public interface Container {
    
    public boolean putItem(Item i, Player p);
    public boolean getItem(String name, Player p);
    public boolean isFull();
    public void printItems();
}
