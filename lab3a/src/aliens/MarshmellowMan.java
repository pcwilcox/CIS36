package aliens;

public class MarshmellowMan extends Alien {
        
    @Override
    public int getDamage() {
        return 1;
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
    
    public MarshmellowMan() {
        super(10, 1, "MarshmellowMan");
    }
    
    public MarshmellowMan(int health, int damage, String name) {
        super(health, damage, name);
    }
}
