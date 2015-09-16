import java.util.Scanner;

public class DateConverter {

    // Asks user for a integer bewteen 1 and 366, a day number in a leap year
    //  (a year with 29 days in February, such as 2016).
    // Prints the date in month/day format.
    // Example: 
    //   if the user enters 365, this should print 12/30
    //
    // Fill in missing code only where indicated (***), although perhaps not in every spot
    public static void main(String[] args) {
        int dayOfYear = 0;
        System.out.print("Enter the number of a day in a leap year (1-366): ");
        
        
        // *** store user entry in dayOfYear;
        Scanner input = new Scanner(System.in);
        dayOfYear = input.nextInt();

        convertDayOfYear(dayOfYear);
    }

    public static void convertDayOfYear(int dayOfYear) {
        int month, dateInMonth, daysInMonth;
        month = 1;
        daysInMonth = 31;

        while (dayOfYear > daysInMonth) {
            // *** Here is one possible place to put assignment statements.
            
            daysInMonth = daysInMonth(month);
            // *** Here is another possible place to put assignment statements
            dayOfYear -= daysInMonth;
            month++;
        }

        dateInMonth = dayOfYear;
        System.out.println(month + "/" + dateInMonth);
    }

    
 
    public static int daysInMonth(int month) {
        
        switch (month) {
            case 2:
                return 29;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

}
