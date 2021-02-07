/* Author: Sandro Sobczyński */

package com.company.zad1.airlines.ua;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UATicketService implements IUATicketService {
    public List<UATicketInfo> getTicketInfo(String from, String to, LocalDateTime when) {
        Random generator = new Random();
        int amountOfTickets = generator.nextInt((8 - 3) + 1) + 3;
        List<UATicketInfo> result = new ArrayList<UATicketInfo>();
        for (int i = 0; i < amountOfTickets; i++) {
            UATicketInfo ticket = new UATicketInfo();
            ticket.price = generator.nextInt((1000 - 100) + 1) + 100;
            ticket.dateTime = when;
            ticket.from = from;
            ticket.to = to;
            result.add(ticket);
        }
        return result;
    }
}
