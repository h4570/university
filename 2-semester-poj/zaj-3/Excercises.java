/* Author: Sandro Sobczyński */

package com.company;

public class Excercises {

    public static void main(String[] args) {
        System.out.print("\n--- Excercise 11 ---\n\n");
        Excercise11();
        System.out.print("\n--- Excercise 12 ---\n\n");
        Excercise12();
        System.out.print("\n--- Excercise 13 ---\n\n");
        Excercise13();
        System.out.print("\n--- Excercise 14 ---\n\n");
        Excercise14();
        System.out.print("\n--- Excercise 15 ---\n\n");
        Excercise15();
    }

    private static void Excercise11() {
        Employee maciek = new Employee(1, "Maciek", "Zdzisiek", 100);
        int newSalary = maciek.raiseSalary(20);
        System.out.println(newSalary);
        System.out.println(maciek.toString());
    }

    private static void Excercise12() {
        InvoiceItem item = new InvoiceItem("{C-6123}", "Maciek", 10, 1.5);
        System.out.println(item.toString());
    }

    private static void Excercise13() {
        Account acc1 = new Account("{C-11}", "Acc1", 100);
        Account acc2 = new Account("{C-22}", "Acc2", 50);
        acc1.debit(120); // fail
        acc2.debit(20);
        acc2.credit(20);
        acc1.transferTo(acc2, 110); // fail
        acc1.transferTo(acc2, 50);
        System.out.println(acc1.toString());
        System.out.println(acc2.toString());
    }

    private static void Excercise14() {
        Date date1 = new Date(1, 1, 1999);
        Date date2 = new Date(10, 10, 2010);
        System.out.println(date1.toString());
        System.out.println(date2.toString());
    }

    private static void Excercise15() {
        Time time1 = new Time(23, 59, 59);
        time1.previousSecond();
        System.out.println(time1.toString());
        time1.nextSecond();
        time1.nextSecond();
        System.out.println(time1.toString());

        Time time2 = new Time(0, 0, 0);
        time2.nextSecond();
        System.out.println(time2.toString());
        time2.previousSecond();
        time2.previousSecond();
        System.out.println(time2.toString());

        Time time3 = new Time(1, 0, 59);
        time3.nextSecond();
        System.out.println(time3.toString());
    }

}