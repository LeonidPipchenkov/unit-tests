package net.happiness.unittests.services;

import net.happiness.unittests.entities.Event;

public interface EventService {

    Event findEvent(long id);

    void saveEvent(Event event);

}
