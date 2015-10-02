package lab1c;

import java.util.Random;

public class Person {

    private static int assignedIDs;
    private Name personName = new Name();
    private String hairColor;
    private int height;
    private int personID;

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }
    
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

}
