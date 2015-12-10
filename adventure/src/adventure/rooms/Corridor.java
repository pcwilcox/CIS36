package adventure.rooms;


public class Corridor extends Room {
    
    // Corridors have labels on the wall indicating their position on the ship
    
    private int deck;
    private String label;
    
    
    public Corridor(String name, String desc, int deck) {
        
        super(name, desc);

    }
    
}
