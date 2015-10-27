
package aliens;

import java.util.ArrayList;

public class AlienPack {

    private ArrayList<Alien> aliens;
    
    public AlienPack() {
        aliens = new ArrayList<>();
    }

    public void addAlien(Alien newAlien) {
        aliens.add(newAlien);
    }

    public ArrayList<Alien> getAliens() {
        return aliens;
    }

    // calculates the damage done by the pack by summing up 
    // the damage from each alien in the pack
    public int calculateDamage() {
        int damage = 0;

        for (Alien alien : aliens) {
            damage += alien.getDamage();
        }
        
        return damage;
    }
    
    public int calculateHealth() {
        int health = 0;
        
        for (Alien alien : aliens) {
            health += alien.getHealth();
        }
        
        return health;
    }
}
