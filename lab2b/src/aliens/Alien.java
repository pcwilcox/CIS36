package aliens;

public class Alien {
    private int health;
    private String name;
    private int damage;
    
    public int getDamage() {
        return damage;
    }
    
    public void setDamage(int damage) {
        this.damage = damage;
    }
        
    public int getHealth() {
        return health;
    }
    
    public void setHealth(int damage) {
        this.health -= damage;
    }
    
    
    public Alien() {
        this.health = 10;
        this.name = "Alien";
    }
    

    public Alien(int health, int damage, String name) {
        this.health = health;
        this.damage = damage;
        this.name = name;
    }
    
    
}
