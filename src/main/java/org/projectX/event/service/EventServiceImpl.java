package org.projectX.event.service;

import org.hibernate.SessionFactory;
import org.projectX.event.model.Event;
import org.projectX.event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by jrwoj on 19.04.2017.
 */
@Service
public class EventServiceImpl implements EventService{

    @Autowired
    private EventRepository eventRepository;


    @Override
    public List<Event> getAllEvents() {
        List<Event> eventList = eventRepository.findAll();
        return eventList;
    }

    @Override
    public Event getEventById(Integer id) {
        Event foundEvent = eventRepository.findOne(id);
        return foundEvent;
    }

    @Override
    public Event createEvent(Event event) {
        eventRepository.save(event);
        return event;
    }

    @Override
    public Event updateEvent(Event event) {
        Event foundEvent = eventRepository.findOne(event.getId());
        if(foundEvent == null){
            throw new NoResultException("Cannot update event. Event not found!");
        }
        else{
            eventRepository.save(event);
        }
        return event;
    }

    @Override
    public void deleteEvent(Integer id) throws NoResultException {
        Event eventToDelete = eventRepository.findOne(id);
        if(eventToDelete == null){
            throw new NoResultException("Cannot delete event. Event not found!");
        }
        eventRepository.delete(id);
    }
}
