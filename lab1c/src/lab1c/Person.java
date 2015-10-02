package lab1c;

import java.util.Random;

public class Person {

    private static int assignedIDs;
    private int thisID;
    private Name personName;
    private String hairColor;
    private int height;
    private int personID;

    public void setName(String firstName) {
        this.personName.setName(firstName);
    }

    public String getName() {
        return this.personName.name();
    }

    public String getInitials() {
        return this.personName.initials();
    }

    public int getPersonID() {
        return this.personID;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getHairColor() {
        if (this.hairColor != null) {
            return "hair color is unspecified.";
        } else {
            return this.hairColor;
        }
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

    public int getHeight() {
        return height;
    }

    public String getHeightString() {
        int feet = (height / 12);
        int inches = (height % 12);

        String heightString = feet + "'" + inches + "\"";

        return heightString;
    }

    private static int setRandomHeight() {
        Random randomHeight = new Random();
        int returnHeight = 51 + randomHeight.nextInt(39);
        return returnHeight;
    }

    public Person copyPerson() {
        Person newPerson = new Person(this.personName.getFirstName(), this.personName.getLastName(), this.personName.gender(), this.hairColor, this.height);
        return newPerson;
    }

    Person(String firstName, String lastName, int gender, String hairColor, int height) {
        this.personName = new Name(firstName, lastName, gender);
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
