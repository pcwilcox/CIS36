package aliens;

public class Ogre extends Alien {

    @Override
    public int getDamage() {
        return 6;
    }

    @Override
    public int getHealth() {
        return super.getHealth();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public Ogre() {
        super(25, 6, "Ogre");
    }

    public Ogre(int health, int damage, String name) {
        super(health, damage, name);
    }
}
