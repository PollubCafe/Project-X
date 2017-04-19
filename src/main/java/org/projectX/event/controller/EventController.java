package org.projectX.event.controller;

import org.projectX.event.model.Event;
import org.projectX.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.events.EventException;

import java.util.List;

/**
 * Created by jrwoj on 19.04.2017.
 */
@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping( value="/all",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Event>> getAllEvents(){
        List<Event> allEvents = eventService.getAllEvents();
        return new ResponseEntity<List<Event>>(allEvents, HttpStatus.OK);
    }

    @RequestMapping(value="/event/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> getEventById(@PathVariable("id") Integer id){
        Event foundEvent = eventService.getEventById(id);
        return new ResponseEntity<Event>(foundEvent, HttpStatus.OK);
    }

    @RequestMapping(value="/create",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> createEvent(@RequestBody Event event){
        Event createdEvent = eventService.createEvent(event);
        return new ResponseEntity<Event>(createdEvent, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> updateEvent(@RequestBody Event event){
        Event updatedEvent = eventService.updateEvent(event);
        return new ResponseEntity<Event>(updatedEvent, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public ResponseEntity deleteEvent(@PathVariable("id") Integer id){
        eventService.deleteEvent(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
