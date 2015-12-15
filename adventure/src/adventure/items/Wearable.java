package adventure.items;

// A wearable is an item that can be worn (or equipped, etc)
public interface Wearable {
    // Synonymous with equip, use, etc
    public boolean wear();
    public boolean remove();
    
}
