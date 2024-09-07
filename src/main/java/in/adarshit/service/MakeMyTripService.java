package in.adarshit.service;

import in.adarshit.request.Passenger;
import in.adarshit.response.Ticket;

public interface MakeMyTripService {

	public Ticket bookticket(Passenger passenger);

	public Ticket getTicket(Integer ticketNumber);

}
