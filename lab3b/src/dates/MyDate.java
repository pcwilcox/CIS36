package dates;

public class MyDate implements Comparable {

    private int month;
    private int day;

    MyDate() {
        this.month = 1;
        this.day = 1;
    }

    MyDate(int m, int d) {
        this.month = m;
        this.day = d;
    }

    private String getMonthString() {
        switch (this.month) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "Monthvember";
        }
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int m) {
        this.month = m;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int d) {
        this.day = d;
    }

    @Override
    public String toString() {
        return (this.getMonthString() + " " + this.day);
    }
    
    // I couldn't really handle not throwing exceptions on this one
    @Override
    public int compareTo(Object otherDate) {
        if (otherDate == null) {
            throw new NullPointerException();
        } else if (otherDate instanceof MyDate) {
            MyDate tempDate = (MyDate) otherDate;

            if (this.month < tempDate.month) {
                return -1;
            } else if (this.month == tempDate.month) {
                if (this.day < tempDate.day) {
                    return -1;

                } else if (this.day == tempDate.day) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 1;

            }
        } else {
            throw new ClassCastException();
        }
    }
}
