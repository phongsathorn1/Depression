package depression.myservice.depreesionevent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class EventController {
	@Autowired
	private EventService service;
	
	@Secured({"ROLE_EVENTMGR"})
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public Event save(@RequestBody Event event) {
		
		return service.save(event);
	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public List<Event> views(){
		return service.listAll();
	}
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String test() {
		return "HelloWorld";
	}
	@Secured({"ROLE_EVENTMGR"})
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public void edit(@PathVariable int id) {
		service.delete(id);
	}
	
	@RequestMapping(value="/view/{id}", method=RequestMethod.GET)
	public Event getEvent(@PathVariable int id) {
		return service.get(id);
	}

}
