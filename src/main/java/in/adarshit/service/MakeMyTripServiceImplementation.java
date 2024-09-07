package in.adarshit.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.adarshit.request.Passenger;
import in.adarshit.response.Ticket;

@Service
public class MakeMyTripServiceImplementation implements MakeMyTripService {

	private String BOOK_TICKET_URL = "http://localhost:9095/ticket";

	private String GET_TICKET_URL = "http://localhost:9095/ticket/{ticketNum}";

	@Override
	public Ticket bookticket(Passenger passenger) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> t = rt.postForEntity(BOOK_TICKET_URL, passenger, Ticket.class);
		Ticket ticket = t.getBody();

		return ticket;
	}

	@Override
	public Ticket getTicket(Integer ticketNumber) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> entity = rt.getForEntity(GET_TICKET_URL, Ticket.class, ticketNumber);
		Ticket ticket = entity.getBody();

		return ticket;
	}

}
