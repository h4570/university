/* Author: Sandro Sobczyński */

package com.company.zad1;

import java.time.LocalDateTime;

import com.company.zad1.airlines.ba.BATicket;
import com.company.zad1.airlines.ua.UATicketInfo;

public class TicketInfo {

    LocalDateTime dateTime;
    double price;
    String airline;

    public TicketInfo(LocalDateTime dateTime, double price, String airline) {
        this.dateTime = dateTime;
        this.price = price;
        this.airline = airline;
    }

    public static TicketInfo fromForeignTicket(BATicket ticket) {
        return new TicketInfo(ticket.departureTime, ticket.ticketPrice, "British Airways");
    }

    public static TicketInfo fromForeignTicket(UATicketInfo ticket) {
        return new TicketInfo(ticket.dateTime, ticket.price, "United Airways");
    }

}
