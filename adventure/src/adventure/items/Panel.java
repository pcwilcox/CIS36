package adventure.items;


public interface Panel {
    public Usable getTarget();
    
    public void setTarget(Usable u);
    
    public boolean use();
    public void examine();
    
}
