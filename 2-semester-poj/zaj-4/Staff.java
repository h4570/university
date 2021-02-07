/* Author: Sandro Sobczyński */

package com.company;

import java.util.Locale;

public class Staff extends Person {

    private String school;
    private double pay;

    public Staff(String name, String address, String school, double pay) {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }

    public String getSchool() {
        return this.school;
    }

    public void setSchool(String value) {
        this.school = value;
    }

    public double getPay() {
        return this.pay;
    }

    public void setPay(double value) {
        this.pay = value;
    }

    public String toString() {
        return String.format(Locale.US, "Student[Person[name=%s,address=%s],school=%s,pay=%.2f]", this.getName(),
                this.getAddress(), this.getSchool(), this.getPay());
    }

}