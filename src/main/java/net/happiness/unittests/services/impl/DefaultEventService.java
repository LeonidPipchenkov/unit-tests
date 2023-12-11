package net.happiness.unittests.services.impl;

import net.happiness.unittests.entities.Event;
import net.happiness.unittests.repositories.EventRepository;
import net.happiness.unittests.services.EventService;
import org.springframework.stereotype.Service;

@Service
public class DefaultEventService implements EventService {

    private final EventRepository eventRepository;

    public DefaultEventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event findEvent(long id) {
        return eventRepository.findEventById(id);
    }

    @Override
    public void saveEvent(Event event) {
        eventRepository.saveEvent(event);
    }

}
