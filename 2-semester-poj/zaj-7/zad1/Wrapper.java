/* Author: Sandro Sobczyński */

package com.company.zad1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.company.zad1.airlines.ba.Airport;
import com.company.zad1.airlines.ba.AirportHelper;
import com.company.zad1.airlines.ba.BATicket;
import com.company.zad1.airlines.ba.BATicketService;

import com.company.zad1.airlines.ua.UATicketInfo;
import com.company.zad1.airlines.ua.UATicketService;

public class Wrapper {

    private UATicketService uaTicketService;
    private BATicketService baTicketService;

    public Wrapper() {
        baTicketService = new BATicketService();
        uaTicketService = new UATicketService();
    }

    public List<TicketInfo> getTicketInfo(String from, String to, LocalDateTime when) throws Exception {
        List<TicketInfo> result = new ArrayList<TicketInfo>();
        result.addAll(getBATicketInfo(from, to, when));
        result.addAll(getUATicketInfo(from, to, when));
        return result;
    }

    private List<TicketInfo> getBATicketInfo(String from, String to, LocalDateTime when) throws Exception {
        List<TicketInfo> result = new ArrayList<TicketInfo>();
        Airport airportFrom = AirportHelper.getAirportByString(from);
        Airport airportTo = AirportHelper.getAirportByString(to);
        List<BATicket> tickets = baTicketService.getTicketInfo(airportFrom, airportTo, when);
        for (BATicket ticket : tickets)
            result.add(TicketInfo.fromForeignTicket(ticket));
        return result;
    }

    private List<TicketInfo> getUATicketInfo(String from, String to, LocalDateTime when) throws Exception {
        List<TicketInfo> result = new ArrayList<TicketInfo>();
        List<UATicketInfo> tickets = uaTicketService.getTicketInfo(from, to, when);
        for (UATicketInfo ticket : tickets)
            result.add(TicketInfo.fromForeignTicket(ticket));
        return result;
    }

}
