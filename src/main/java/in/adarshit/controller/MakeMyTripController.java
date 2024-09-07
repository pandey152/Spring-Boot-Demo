package in.adarshit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.adarshit.request.Passenger;
import in.adarshit.response.Ticket;
import in.adarshit.service.MakeMyTripService;

@Controller
public class MakeMyTripController {

	@Autowired
	private MakeMyTripService service;

	@PostMapping("/book-ticket")
	public String bookTicket(@ModelAttribute("passenger") Passenger passenger, Model model) {
		Ticket ticket = service.bookticket(passenger);

		model.addAttribute("msg", "Ticket booked with ID" + ticket.getTicketNumber());
		return "index";
	}

	@GetMapping("/load-ticket")
	public String loadGetTicketForm(Model model) {
		model.addAttribute("ticket", new Ticket());
		return "ticket-form";
	}

	@GetMapping("/get-ticket")
	public String getTicket(@RequestParam Integer ticketNumber, Model model) {
		Ticket ticketByNum = service.getTicket(ticketNumber);
		model.addAttribute("ticket", ticketByNum);
		return "ticket-form";
	}

	@GetMapping("/")
	public String loadPage(Model model) {
		model.addAttribute("passenger", new Passenger());

		return "index";

	}
}
