package net.happiness.unittests.controllers;

import net.happiness.unittests.dtos.event.EventDTO;
import net.happiness.unittests.dtos.event.EventDTOBuilder;
import net.happiness.unittests.entities.Event;
import net.happiness.unittests.services.EventService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("event")
public class EventsController {

    private final EventDTOBuilder eventDTOBuilder;
    private final EventService eventService;

    public EventsController(EventDTOBuilder eventDTOBuilder, EventService eventService) {
        this.eventDTOBuilder = eventDTOBuilder;
        this.eventService = eventService;
    }

    @GetMapping("/{id}")
    public EventDTO getEvent(@PathVariable("id") long eventId) {
        final Event event = eventService.findEvent(eventId);
        return eventDTOBuilder.fromEvent(event);
    }

    @PutMapping
    public void saveEvent(@RequestBody @Validated EventDTO eventDTO) {
        final Event event = eventDTOBuilder.fromEventDTO(eventDTO);
        eventService.saveEvent(event);
    }

}
