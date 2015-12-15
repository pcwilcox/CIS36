package adventure.items;


public abstract class Stationary extends Item {
//    public Item(String name, String description, boolean canTake) {
//        this.name = name;
//        this.description = description;
//        this.canTake = canTake;
//    }
    
    public Stationary(String name, String description) {
        super(name, description, false);
    }
}
