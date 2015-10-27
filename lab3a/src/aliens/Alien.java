package aliens;

public abstract class Alien {

    private int health;
    private String name;
    private int damage;

    public abstract int getDamage();

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int damage) {
        this.health -= damage;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getStats() {
        String stats = this.name + ", Health : " + this.health + ", Damage: " + this.damage;
        
        return stats;
    }

    public Alien() {
        this.health = 1;
        this.damage = 1;
        this.name = "Alien";
    }

    public Alien(int health, int damage, String name) {
        this.health = health;
        this.damage = damage;
        this.name = name;
    }

}
