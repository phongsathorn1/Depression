package microserviceproject.eventmicroservice;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class EventResource {
	@Autowired
	private EventService service;
	
	@GetMapping("/event")
	public List<Event> getAllUser(Event event){
		return service.getAllEvent();
	}
	
	@GetMapping("/event/{id}")
	public Event getDetailsUser(@PathVariable int id) {
		Event event = service.findOne(id);
		if (event==null) {
			throw new EventNotFoundException("id-" + id);
		}
		return event;
	}
	
	@PostMapping("/event")
	public ResponseEntity<Object> createUser(@RequestBody Event event) {
		Event getEvent = service.createEvent(event);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(getEvent.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
}