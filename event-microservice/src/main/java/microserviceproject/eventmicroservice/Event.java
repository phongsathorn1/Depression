package microserviceproject.eventmicroservice;

import java.util.Date;

public class Event {
	private Integer id;
	private String event_name;
	private Date start_date;
	private Date end_date;
	private String event_details;
	
	protected Event() {
		
	}
	
	public Event(Integer id, String event_name, Date start_date, Date end_date, String event_details) {
		super();
		this.id = id;
		this.event_name = event_name;
		this.start_date = start_date;
		this.end_date = end_date;
		this.event_details = event_details;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getEvent_name() {
		return event_name;
	}
	
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getEvent_details() {
		return event_details;
	}
	public void setEvent_details(String event_details) {
		this.event_details = event_details;
	}
	
	@Override
	public String toString() {
		return "Event [id=" + id + ", event_name=" + event_name + ", start_date=" + start_date + ", end_date="
				+ end_date + ", event_details=" + event_details + "]";
	}
}
