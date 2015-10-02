package lab1c;

public class Name {

    String firstName,
            lastName;
    int gender;

    public void setName(String firstName, String lastName, int gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }
    
    public void setName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public void setName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String name() {
        String firstChar = this.firstName.substring(0, 1);
        String secondChar = this.lastName.substring(0, 1);
        String firstRemaining = this.firstName.substring(1, this.firstName.length());
        String secondRemaining = this.lastName.substring(1, this.lastName.length());
        String returnName = firstChar.toUpperCase() + firstRemaining.toLowerCase() + " " + secondChar.toUpperCase() + secondRemaining.toLowerCase();
        return returnName;
    }

    public String rollCallName() {
        String firstChar = this.firstName.substring(0, 1);
        String secondChar = this.lastName.substring(0, 1);
        String firstRemaining = this.firstName.substring(1, this.firstName.length());
        String secondRemaining = this.lastName.substring(1, this.lastName.length());
        String returnName = secondChar.toUpperCase() + secondRemaining.toLowerCase() + ", " + firstChar.toUpperCase() + firstRemaining.toLowerCase();
        return returnName;
    }

    public String initials() {
        String firstChar = this.firstName.substring(0, 1);
        String secondChar = this.lastName.substring(0, 1);
        String returnInitials = firstChar.toUpperCase() + secondChar.toUpperCase();
        return returnInitials;
    }

    private String pigName(String name) {
        String suffixVowel = "yay";
        String suffixConsonant = "ay";
        
        char[] charName = name.toCharArray();
        
        if (isVowel(charName[0]) == true) {
            String returnName = name.toLowerCase() + suffixVowel;
            return returnName;
        } else {
            int i = 0;
            
            while ((isVowel(charName[i]) == false) && (i < name.length())) {
                i++;
            }
            
            String prefix = new String(charName, i, (name.length() - i));
            String suffix = new String(charName, 0, i);

            
            String returnName = prefix.toLowerCase() + suffix.toLowerCase() + suffixConsonant;
            return returnName;
        }
    }
    
    public String pigLatinName() {
        String pigFirst = pigName(this.firstName);
        String pigSecond = pigName(this.lastName);
        
        String returnName = pigFirst + " " + pigSecond;
        
        return returnName;
    }

    private boolean isVowel(char character) {
        switch (character) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'y':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
            case 'Y':
                return true;
            default:
                return false;

        }
    }

    public int gender() {
        return gender;
    }

    public Name() {
        this("John", "Doe", -99);
    }

    public Name(String lastName) {
        this("John", lastName, -99);
    }

    public Name(String firstName, String lastName) {
        this(firstName, lastName, -99);
    }

    public Name(String firstName, String lastName, int gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

}
