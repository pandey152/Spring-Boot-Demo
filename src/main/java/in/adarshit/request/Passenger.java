package in.adarshit.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Passenger {

	private String name;
	private String from;
	private String to;
	private String doj;
	private String trainNumber;

}
