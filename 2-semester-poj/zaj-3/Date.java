/* Author: Sandro Sobczyński */

package com.company;

public class Date {

    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public void setDay(int value) {
        this.day = value;
    }

    public void setMonth(int value) {
        this.month = value;
    }

    public void setYear(int value) {
        this.year = value;
    }

    public void setDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toString() {
        String fixedDay = '0' + Integer.toString(day);
        fixedDay = fixedDay.substring(fixedDay.length() - 2, fixedDay.length());
        String fixedMonth = '0' + Integer.toString(month);
        fixedMonth = fixedMonth.substring(fixedMonth.length() - 2, fixedMonth.length());
        return String.format("%s/%s/%s", fixedDay, fixedMonth, year);
    }

}