/* Author: Sandro Sobczyński */

package com.company.zad1.airlines.ba;

import java.time.LocalDateTime;
import java.util.List;

public interface IBATicketService {
    List<BATicket> getTicketInfo(Airport from, Airport to, LocalDateTime when);
}
