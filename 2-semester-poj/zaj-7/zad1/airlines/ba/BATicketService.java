/* Author: Sandro Sobczyński */

package com.company.zad1.airlines.ba;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BATicketService implements IBATicketService {
    public List<BATicket> getTicketInfo(Airport from, Airport to, LocalDateTime when) {
        Random generator = new Random();
        int amountOfTickets = generator.nextInt((8 - 3) + 1) + 3;
        List<BATicket> result = new ArrayList<BATicket>();
        for (int i = 0; i < amountOfTickets; i++) {
            BATicket ticket = new BATicket();
            ticket.ticketPrice = generator.nextInt((1000 - 100) + 1) + 100;
            ticket.departureTime = when;
            result.add(ticket);
        }
        return result;
    }
}
