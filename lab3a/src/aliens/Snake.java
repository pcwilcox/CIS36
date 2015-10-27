package aliens;

public class Snake extends Alien {
    
    
    @Override
    public int getDamage() {
        return super.getDamage();
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
    
    public Snake() {
        super(50, 10, "Snake");
    }
    
    public Snake(int health, int damage, String name) {
        super(health, damage, name);
    }
    
}
