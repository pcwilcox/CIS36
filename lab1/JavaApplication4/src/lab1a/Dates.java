/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1a;

/**
 *
 * @author Student
 */
public class Dates {
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
        
        
        
        /*
        if (month == 2) {
            return 29;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
                */
    }
}
