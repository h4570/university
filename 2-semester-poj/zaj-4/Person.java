/* Author: Sandro Sobczyński */

package com.company;

class Person {

    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String value) {
        this.address = value;
    }

    public String toString() {
        return String.format("Person[name=%s,address=%s]", this.getName(), this.getAddress());
    }

}