package microserviceproject.eventmicroservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EventService {
	public static List<Event> events = new ArrayList<>();
	private static  int countEvent = 0;
	
	static {
		
	}

	public List<Event> getAllEvent() {
		return events;
	}
	
	public Event createEvent(Event event) {
		if (event.getId() == null) {
			event.setId(++countEvent);
		}
		events.add(event);
		return null;
	}
	
	public Event findOne(int id) {
		for(Event event:events) {
			if(event.getId()==id) {
				return event;
			}
		}
		return null;
	}
}