/* Author: Sandro Sobczyński */

package com.company;

import java.util.Locale;

public class Student extends Person {

    private String program;
    private int year;
    private double fee;

    public Student(String name, String address, String program, int year, double fee) {
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    public String getProgram() {
        return this.program;
    }

    public void setProgram(String value) {
        this.program = value;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int value) {
        this.year = value;
    }

    public double getFee() {
        return this.fee;
    }

    public void setFee(double value) {
        this.fee = value;
    }

    public String toString() {
        return String.format(Locale.US, "Student[Person[name=%s,address=%s],program=%s,year=%d,fee=%.2f]",
                this.getName(), this.getAddress(), this.getProgram(), this.getYear(), this.getFee());
    }

}