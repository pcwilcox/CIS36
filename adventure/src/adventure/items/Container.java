package adventure.items;
public interface Container {
    
    public boolean putItem(Item i);
    public Item getItem(String name);
    public boolean isFull();
    public void printItems();
    
    
}
