package aliens;

import java.util.Random;

public class AlienTester {
    public static void main(String[] args) {
        System.out.println("Testing aliens");
        
        singleSnake();
        singleOgre();
        singleMarsh();
        
        // I thought it'd be neat to do this randomly
        randomPack(1);
        randomPack(5);
        randomPack(10);
    }
    
    public static void singleSnake() {
        Snake snake = new Snake();
        
        System.out.println("Testing single snake.");
        
        System.out.println("I am a " + snake.getName() +", I have " + snake.getHealth() + " health and I do " + snake.getDamage() + " damage.");
    }
    
    public static void singleOgre() {
        Ogre ogre = new Ogre();
        
        System.out.println("Testing ogre.");
        
        System.out.println("I am a " + ogre.getName() +", I have " + ogre.getHealth() + " health and I do " + ogre.getDamage() + " damage.");
    }
    
    public static void singleMarsh() {
        MarshmellowMan marsh = new MarshmellowMan();
        
        System.out.println("Testing marsh.");
        
        System.out.println("I am a " + marsh.getName() +", I have " + marsh.getHealth() + " health and I do " + marsh.getDamage() + " damage.");
    }
    
    public static void randomPack(int num) {
        Random rand = new Random();
        AlienPack randPack = new AlienPack();
        
        for (int i = 0; i < num; i++) {
            int alienType = rand.nextInt(3);
            switch (alienType) {
                case 0:
                    Snake snake = new Snake();
                    randPack.addAlien(snake);
                    break;
                case 1:
                    Ogre ogre = new Ogre();
                    randPack.addAlien(ogre);
                    break;
                case 2:
                    MarshmellowMan marsh = new MarshmellowMan();
                    randPack.addAlien(marsh);
                    break;
            }
        }
        
        System.out.println("Testing random pack with (" + num + ") aliens.");
        System.out.println("Aliens: ");
        
        for (Alien alien : randPack.getAliens()) {
            System.out.println(alien.getStats());
        }
        System.out.println("Total health: " + randPack.calculateHealth());
        System.out.println("Total damage: " + randPack.calculateDamage());
        
    }
    
    
}
