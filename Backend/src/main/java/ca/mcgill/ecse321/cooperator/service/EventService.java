package ca.mcgill.ecse321.cooperator.service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.cooperator.entity.Event;
import ca.mcgill.ecse321.cooperator.repository.EventRepository;

@Service
public class EventService {
	@Autowired
	EventRepository eventRepository;

	/**
	 * create an event
	 * check the input, throws exception if the parameter is not valid
	 * 
	 * @param startdate
	 * @param enddate
	 * @param location
	 * @param starttime
	 * @param endtime
	 * @return Event eventReturn
	 */
 	@Transactional
	public Event createEvent(Date startdate, Date enddate, String location, Time starttime, Time endtime){
		if (startdate == null) {
			throw new IllegalArgumentException("startDate cannot be empty!");
		}
		if (enddate == null) {
			throw new IllegalArgumentException("endDate cannot be empty!");
		}
		if (location == null || location.trim().length() == 0) {
			throw new IllegalArgumentException("location cannot be empty!");
		}
		if (starttime == null) {
			throw new IllegalArgumentException("startTime cannot be empty!");
		}
		if (endtime == null) {
			throw new IllegalArgumentException("endTime cannot be empty!");
		}

		Event event = new Event();
		event.setStartDate(startdate);
		event.setEndDate(enddate);
		event.setLocation(location);
		event.setStartTime(starttime);
		event.setEndTime(endtime);

		Event eventReturn = eventRepository.save(event);
		return eventReturn;
	}
 	
 	/**
 	 * get an event by the id
 	 * throws exception if the event is not found
 	 * 
 	 * @param id
 	 * @return Event event
 	 */
 	@Transactional
	public Event getEvent(int id){
 
		Event event = eventRepository.findById(id);
		if(event == null) {
			throw new IllegalArgumentException("there is no such event!");
		}
		return event;
	}
 	
 	/**
 	 * delete an event by the id
 	 * 
 	 * @param id
 	 */
 	@Transactional
 	public void deleteEvent(int id) {
 		eventRepository.deleteById(id);
 	}
 	
 	/**
 	 * get all events in the database
 	 *
 	 * @return List<Event>
 	 */
 	@Transactional
	public List<Event> getAllEvents() {
		return toList(eventRepository.findAll());
	}

 	/**
 	 * convert all iterable to List
 	 * 
 	 * @param iterable
 	 * @return List
 	 */
 	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
}