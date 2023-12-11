package net.happiness.unittests.repositories;

import net.happiness.unittests.entities.Event;

public interface EventRepository {

    Event findEventById(long id);

    void saveEvent(Event event);

}
