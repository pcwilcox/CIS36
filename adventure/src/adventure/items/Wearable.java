package adventure.items;

// A wearable is an item that can be worn (or equipped, etc)

import adventure.Player;

public interface Wearable {
    // Synonymous with equip, use, etc
    public boolean wear(Player p);
    public boolean remove(Player p);
    
    // Evidently even though it's an interface it needs this to work right
    public String getName();
    
}
