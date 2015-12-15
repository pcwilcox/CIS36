package adventure.items;

// A control panel is an Item that serves as an interface for things. It is used
// to do things like switch the lights on, open and close doors, or repair
// components.
public abstract class ControlPanel extends Stationary implements Panel {
    private Object target;
        
    public ControlPanel(String name, String description) {
        super(name, description);
    }
    
    public ControlPanel(String name, String description, Object target) {
        super(name, description);
        this.target = target;
    }
    
    @Override
    abstract public Object getTarget();
    
    @Override
    abstract public void setTarget(Object t);
    
    
}
