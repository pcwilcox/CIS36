package lab1c;

import java.util.Random;

public class Person {
    private static int assignedIDs;
    private int thisID;
    private Name personName = new Name();
    private String hair;
    private int height;
    
    
    Person(String firstName, String lastName, String hair, int height, int gender) {
        this.personName.setFirstName(firstName);
        this.personName.setLastName(lastName);
        this.personName.setGender(gender);
        this.height = height;
        this.hair = hair;
        assignedIDs++;
        this.thisID = assignedIDs;
    }  
    
    Person() {
        this.personName.setFirstName("John");
        this.personName.setLastName("Doe");
        this.personName.setGender(1);
        this.height = getRandomHeight();
        this.hair = null;
        assignedIDs++;
        this.thisID = assignedIDs;
    }
    
    Person(String firstName, String lastName) {       
        this.personName.setFirstName(firstName);
        this.personName.setLastName(lastName);
        this.height = getRandomHeight();
        this.hair = null;
        assignedIDs++;
        this.thisID = assignedIDs;
    }
    
    Person(String firstName, String lastName, String hair) {
        this.personName.setFirstName(firstName);
        this.personName.setLastName(lastName);
        this.hair = hair;
        this.height = getRandomHeight();
        assignedIDs++;
        this.thisID = assignedIDs;
    }
    
    Person(String firstName, String lastName, String hair, int gender) {
        this.personName.setFirstName(firstName);
        this.personName.setLastName(lastName);
        this.hair = hair;
        this.personName.setGender(gender);
        this.height = getRandomHeight();
        assignedIDs++;
        this.thisID = assignedIDs;
        
    }
    

    
    Person(String firstName, String lastName, int gender) {
        this.personName.setFirstName(firstName);
        this.personName.setLastName(lastName);
        this.hair = null;
        this.personName.setGender(gender);
        this.height = getRandomHeight();
        assignedIDs++;
        this.thisID = assignedIDs;
    }
    
    public void setHeight(int height) {
        if (height < 39) {
            System.out.println("Too short!");
        } else if (height > 90) {
            System.out.println("Too tall!");
        } else {
            this.height = height;
        }
    }
    
    private int getRandomHeight() {
        Random rand = new Random();
        
        // 7'6" = 90", 4'3" = 51"; 90 - 51 = 39;
        int randomHeight = rand.nextInt(39);
                
        return randomHeight;
    }
    
    public String getHeight() {
        int feet = (height / 12);
        int inches = (height % 12);
        
        String heightString = feet + "'" + inches + "\"";
        
        return heightString;
    }
    
    public void setHair(String hair) {
        this.hair = hair;
    }
}
