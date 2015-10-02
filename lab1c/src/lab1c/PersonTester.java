package lab1c;

public class PersonTester {

    public static void main(String[] args) {
        System.out.println("Testing Person()...");
        
        johnsonTest();
        jillTest();
        samTest();
        jonnyTest();
    }
    
    static void jonnyTest() {
        Person jonny = new Person("Jonny", "Tremaine", "brown");
        System.out.println("My name is " + jonny.getName() + " and my initials are " + jonny.getInitials() + ".");
        System.out.println("My ID is " + jonny.getPersonID() + " and my hair is " + jonny.getHairColor() + ".");
    }
    
    static void copyTest(Person personToCopy) {
        System.out.println("Making a copy of " + personToCopy.getName() + ".");
        
        Person newGuy = personToCopy.copyPerson();
        
        System.out.println("My name is " + newGuy.getName() + " and my initials are " + newGuy.getInitials() + ".");
        System.out.println("My ID is " + newGuy.getPersonID() + ".");
        
    }
    
    static void samTest() {

        Person sam = new Person("Sam", "Houston", 1, 70);
        System.out.println("My name is " + sam.getName() + " and my initials are " + sam.getInitials() + ".");
        System.out.println("My ID is " + sam.getPersonID() + ".");
        
        copyTest(sam);
    }
    
    static void jillTest() {
        Person jill = new Person("Jane", "Deere", 2, 52);
        
        System.out.print("Hello, my name is " + jill.getName() + " and I am a ");
        
        if(jill.getGender() == 2) {
            System.out.println("girl.");
        } else if (jill.getGender() == 1) {
            System.out.println("boy.");
        } else {
            System.out.println("person.");
        }
    }
    
    static void johnsonTest() {
        Person johnson = new Person("Johnson");
        System.out.println("Hello, my name is " + johnson.getName());
        System.out.println("I am " + johnson.getHeightString() + " tall.");
    }
}

/*
Name johnson = new Name("Johnson");
        
        
        
        
        
        
        
        Name jessica = new Name("Jessica", "Simpson", 2);
        
        System.out.println("My name is " + jessica.name() + " and I like pig latin, so call me " + jessica.pigLatinName() + ".");
        
        Name steven = new Name("Steven", "Tyler", 2);
        
        System.out.println("My name is " + steven.name() + " and I like pig latin, so call me " + steven.pigLatinName() + ".");
        
        Name ermey = new Name("R Lee", "Ermey", 1);
        
        System.out.println(ermey.rollCallName() + " reporting!");
*/