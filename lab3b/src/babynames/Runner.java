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
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.length() < b.length()) {
                    return -1;
                } else if (a.length() == b.length()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        System.out.println("The longest name is " + names.get(names.size() - 1));

        // Use an *anonymous* Comparator to find the name that is, backwards, alphanumerically last.
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (new StringBuilder(a).reverse().toString().compareToIgnoreCase(new StringBuilder(b).reverse().toString()) < 0) {
                    return -1;
                } else if (new StringBuilder(a).reverse().toString().compareToIgnoreCase(new StringBuilder(b).reverse().toString()) == 0) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        
        System.out.println("The last name when considered backwards is: " + names.get(names.size() - 1));
        // I put this here for verifying the result of the last anonymous class
//        for (String name : names) {
//            System.out.println(new StringBuilder(name).reverse().toString());
//        }

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
