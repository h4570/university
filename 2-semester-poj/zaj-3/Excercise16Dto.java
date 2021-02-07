/* Author: Sandro Sobczyński */

package com.company;

public class Excercise16Dto {

    public Employee Employee;
    public Date JoiningDate;

    public Excercise16Dto(String firstName, String lastName, int salary, Date joiningDate) {
        Employee = new Employee(321, firstName, lastName, salary);
        JoiningDate = joiningDate;
    }

}
