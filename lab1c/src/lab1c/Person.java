package lab1c;

import java.util.Random;

public class Person {
<<<<<<< HEAD

    private static int assignedIDs;
=======
    private static int assignedIDs;
    private int thisID;
>>>>>>> origin/master
    private Name personName = new Name();
    private String hairColor;
    private int height;
    private int personID;

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }
    
<<<<<<< HEAD
    public void setName(String firstName) {
        this.personName.setName(firstName);
    }

    private static int setRandomHeight() {
        Random randomHeight = new Random();
        int returnHeight = 51 + randomHeight.nextInt(39);
        return returnHeight;
    }

    public int getPersonID() {
        return this.personID;
    }

    public String getHairColor() {
        if (this.hairColor != null) {
            return "hair color is unspecified.";
        } else {
            return this.hairColor;
        }
    }

    Person(String firstName, String lastName, int gender, String hairColor, int height) {
        this.personName.setName(firstName, lastName, gender);
        this.hairColor = hairColor;
        this.height = height;
        assignedIDs++;
        this.personID = assignedIDs;
    }

    Person(String firstName, String lastName, int gender, int height) {
        this(firstName, lastName, gender, null, height);
    }

    Person(String firstName, String lastName, int gender, String hairColor) {
        this(firstName, lastName, gender, hairColor, setRandomHeight());
    }

    Person(String firstName, String lastName, int height) {
        this(firstName, lastName, -99, null, height);
    }

    Person(String firstName, String lastName) {
        this(firstName, lastName, -99, null, setRandomHeight());
    }

    Person(String firstName, int height) {
        this(firstName, "Doe", -99, null, height);
    }

    Person(String firstName) {
        this(firstName, "Doe", -99, null, setRandomHeight());
    }

    Person() {
        this("John", "Doe", -99, null, setRandomHeight());
    }

=======
    
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
>>>>>>> origin/master
}
