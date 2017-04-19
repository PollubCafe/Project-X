package org.projectX.event.service;

import org.projectX.event.model.Event;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by jrwoj on 19.04.2017.
 */
public interface EventService {

    List<Event> getAllEvents();

    Event getEventById(Integer id);

    Event createEvent(Event event);

    Event updateEvent(Event event) throws NoResultException;

    void deleteEvent(Integer id) throws NoResultException;
}
