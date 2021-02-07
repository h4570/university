/* Author: Sandro Sobczyński */

package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Menu {

    public static void main(String[] args) {
        ArrayList<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new PizzaDeluxe(11, "Prosciutto", 11, PizzaSize.Large, true, true));
        pizzas.add(new PizzaWoogy(22, "Te są z drugim konstruktorem", 22, PizzaSize.Medium, false, false));
        pizzas.add(new PizzaSpecial(33, "A teraz niestety po łebkach", 33, PizzaSize.Small, false, true));
        pizzas.add(new PizzaDeluxe(44, "Bo moje dzieci są głodne", 44, PizzaSize.Small, false, true));
        pizzas.add(new PizzaDeluxe(55, "I umrą, jak będę tyle pisał", 55));
        pizzas.add(new PizzaDeluxe(222, "222", 222));
        pizzas.add(new PizzaDeluxe(66, "66", 66));
        pizzas.add(new PizzaDeluxe(88, "88", 88));
        pizzas.add(new PizzaDeluxe(77, "77", 77));
        pizzas.add(new PizzaDeluxe(99, "99", 99));
        pizzas.add(new PizzaDeluxe(111, "111", 111));
        pizzas.add(new PizzaDeluxe(333, "333", 333));
        pizzas.add(new PizzaSpecial(3333, "3333", 3333));
        pizzas.add(new PizzaDeluxe(555, "555", 555));
        pizzas.add(new PizzaDeluxe(666, "666", 666));
        pizzas.add(new PizzaDeluxe(1111, "1111", 1111));
        pizzas.add(new PizzaDeluxe(777, "777", 777));
        pizzas.add(new PizzaDeluxe(444, "444", 444));
        pizzas.add(new PizzaSpecial(8888, "8888", 8888));
        pizzas.add(new PizzaDeluxe(2222, "2222", 2222));
        pizzas.add(new PizzaDeluxe(888, "888", 888));
        pizzas.add(new PizzaSpecial(4444, "4444", 4444));
        pizzas.add(new PizzaDeluxe(999, "999", 999));
        pizzas.add(new PizzaSpecial(5555, "5555", 5555));
        pizzas.add(new PizzaSpecial(9999, "9999", 9999));
        pizzas.add(new PizzaSpecial(7777, "7777", 7777));
        pizzas.add(new PizzaSpecial(6666, "6666", 6666));
        pizzas.add(new PizzaSpecial(22222, "22222", 22222));
        pizzas.add(new PizzaSpecial(11111, "11111", 11111));
        pizzas.add(new PizzaWoogy(55555, "55555", 55555));
        pizzas.add(new PizzaSpecial(33333, "33333", 33333));
        pizzas.add(new PizzaWoogy(44444, "44444", 44444));
        pizzas.add(new PizzaWoogy(77777, "77777", 77777));
        pizzas.add(new PizzaWoogy(444444, "444444", 444444));
        pizzas.add(new PizzaWoogy(66666, "66666", 66666));
        pizzas.add(new PizzaWoogy(555555, "555555", 555555));
        pizzas.add(new PizzaWoogy(99999, "99999", 99999));
        pizzas.add(new PizzaWoogy(111111, "111111", 111111));
        pizzas.add(new PizzaWoogy(88888, "88888", 88888));
        pizzas.add(new PizzaWoogy(333333, "333333", 333333));
        pizzas.add(new PizzaWoogy(222222, "222222", 222222));

        Collections.sort(pizzas);

        for (Pizza pizza : pizzas)
            System.out.println(pizza);

    }

}
