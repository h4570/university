/* Author: Sandro Sobczyński */

package com.company.zad1.airlines.ua;

import java.time.LocalDateTime;
import java.util.List;

public interface IUATicketService {
    List<UATicketInfo> getTicketInfo(String from, String to, LocalDateTime when);
}
