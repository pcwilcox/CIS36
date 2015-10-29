package babynames;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Runner {

    public static void main(String[] args) {
        ArrayList<String> names = readnames();
        Collections.sort(names);  // uses the build in sorting for String
        System.out.println("The last name is " + names.get(names.size() - 1));
        
        // Use an *anonymous* Comparator to find the longest name, or a name tied for longest.
        Comparator longName = new Comparator() {
            
            public String longest() {
                int maxIndex = 0;
                int lastIndex = names.size() - 1;
                for (int i = 0; i < lastIndex; i++) {
                    if (compare(names.get(i), names.get(i + 1)) == 1) {
                        maxIndex = i;
                    }s
                }
                return names.get(maxIndex);
            }
            
            @Override
            public int compare(Object a, Object b) {
                if (a == null || b == null) {
                    throw new NullPointerException();
                } else if (a instanceof String && b instanceof String) {
                    String firstName = a.toString();
                    String secondName = b.toString();
                    
                    if (firstName.length() < secondName.length()) {
                        return -1;
                    } else if (firstName.length() == secondName.length()) {
                        return 0;
                    } else {
                        return 1;
                    }
                    
                } else {
                    throw new ClassCastException();
                }
                
            }
        };
        
        System.out.println("Longest name: " + longName.longest());
        // Use an *anonymous* Comparator to find the name that is, backwards, alphanumerically last.
    }
    
    
    
    public static void sortTest() {
        
    }

    
    // reads names from a file named "babynames.txt", which should be in 
    //  the java package 'babynames'
    public static ArrayList<String> readnames() {
        ArrayList<String> names = new ArrayList<>();
        try {
            String path = System.getProperty("user.dir");  // gets this project's base directory
            path += "/src";   // looks in Source Packages in this project
            path += "/babynames/babynames.txt";   // looks inside the babynames package, in the babynames.txt file
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                names.add(line);
            }

        } catch (FileNotFoundException ex) {
            System.err.println("Couldn't find the file");
        } catch (IOException ex) {
            System.err.println("Couldn't read file");;
        }
        System.out.println(names.size() + " names read from file.");
        return names;
    }


}
