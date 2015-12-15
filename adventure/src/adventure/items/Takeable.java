package adventure.items;


public abstract class Takeable extends Item {
    public Takeable(String name, String description) {
        super(name, description, true);
    }
}
