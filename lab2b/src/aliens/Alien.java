package aliens;

public class Alien {

    public static final int SNAKE_ALIEN = 0;
    public static final int OGRE_ALIEN = 1;
    public static final int MARSHMALLOW_MAN_ALIEN = 2;
    
    private int health;
    private String name;
    
    public Alien() {
        
    }
    

    public Alien(int health, String name) {
        this.health = health;
        this.name = name;
    }
    
    
}
