/* Author: Sandro Sobczyński */

package com.company;

import com.company.HumanParameters.SexType;

public class Human {

    public Human(HumanParameters params) {
        this.params = params;
    }

    private HumanParameters params;

    public int getAge() {
        return this.params.age;
    }

    public void setAge(int value) {
        this.params.age = value;
    }

    public double getWeight() {
        return this.params.weight;
    }

    public void setWeight(double value) {
        this.params.weight = value;
    }

    public double getHeight() {
        return this.params.height;
    }

    public void setHeight(double value) {
        this.params.height = value;
    }

    public String getName() {
        return this.params.name;
    }

    public void setName(String value) {
        this.params.name = value;
    }

    public boolean isMale() {
        return this.params.sex == SexType.Male;
    }

    public void setSex(SexType value) {
        this.params.sex = value;
    }

    public double getFeetSize() {
        return this.params.feetSize;
    }

    public void setFeetSize(double value) {
        this.params.feetSize = value;
    }

    public String getIndexNumber() {
        return this.params.indexNumber;
    }

    public void setIndexNumber(String value) {
        this.params.indexNumber = value;
    }

}
