/* Author: Sandro Sobczyński */

package com.company.zad1;

import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Wrapper wrapper = new Wrapper();
        try {
            List<TicketInfo> tickets = wrapper.getTicketInfo("GD", "WAW", LocalDateTime.now());
            for (TicketInfo ticket : tickets)
                System.out.println(String.format("%s - %.2f %s", ticket.airline, ticket.price, ticket.dateTime));
        } catch (Exception ex) {
            System.out.println("Unknown airports");
        }
    }
}