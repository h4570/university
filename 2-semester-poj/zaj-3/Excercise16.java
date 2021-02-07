/* Author: Sandro Sobczyński */

package com.company;

import java.util.ArrayList;

public class Excercise16 {

    public static void main(String[] args) {
        ArrayList<Excercise16Dto> dtos = new ArrayList<Excercise16Dto>();
        populate(dtos);
        for (Excercise16Dto dto : dtos) {
            System.out.println(String.format("Name: %s, salary: %d, joining date %s", dto.Employee.getName(),
                    dto.Employee.getSalary(), dto.JoiningDate.toString()));
        }
    }

    public static void populate(ArrayList<Excercise16Dto> dtos) {
        Date date1 = new Date(15, 10, 2010);
        Date date2 = new Date(2, 8, 2012);
        Date date3 = new Date(13, 1, 2015);
        dtos.add(new Excercise16Dto("Łukasz", "Adamski", 1000, date1));
        dtos.add(new Excercise16Dto("Kacper", "Maczewski", 800, date2));
        dtos.add(new Excercise16Dto("Adam", "Włodarczyk", 200, date3));
        dtos.add(new Excercise16Dto("Robert", "Andrzejewski", 5000, date1));
        dtos.add(new Excercise16Dto("Jakub", "Plichta", 3050, date2));
        dtos.add(new Excercise16Dto("Norbert", "Adamczyk", 3000, date3));
        dtos.add(new Excercise16Dto("Paweł", "Karski", 2010, date1));
        dtos.add(new Excercise16Dto("Łukasz", "Wróblewski", 1500, date2));
    }

}