class Solution {
    
    // Strategy:
    // each year has 365 days, except leap years with 366 days
    // for the last year we can go month-by-month, noting that february has 29 days on leap years
    // for the last month we can just add the day of the month
    // for all of this we do mod 7 on the day of the week after adding a number of days
    public String dayOfTheWeek(int day, int month, int year) {
        String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int start_year = 1971;
        int weekday = 4;  // Jan. 1, 1971 was a Friday
        weekday = (weekday + daysAfterYears(start_year, year)) % 7;
        weekday = (weekday + daysAfterMonths(month - 1, year)) % 7;
        weekday = (weekday + day - 1) % 7;
        return weekdays[weekday];
    }
    
    private boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }
    
    private int daysAfterYears(int start_year, int end_year) {
        int day = 0;
        for (int y = start_year; y < end_year; y++) {
            if (isLeapYear(y)) day += 366;
            else day += 365;
        }
        return day % 7;
    }
    
    private int daysAfterMonths(int month, int year) {
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) months[1] = 29;
        int day = 0;
        for (int i = 0; i < month; i++) {
            day += months[i];
        }
        return day % 7;
    }
}
