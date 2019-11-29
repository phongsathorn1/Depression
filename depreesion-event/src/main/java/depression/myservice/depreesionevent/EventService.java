package depression.myservice.depreesionevent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
	@Autowired
	private EventRepository repo;
	
	public List<Event> listAll(){
		return repo.findAll();
	}
	
	public Event save(Event event) {
		return repo.save(event);
	}
	
	public Event get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
}
