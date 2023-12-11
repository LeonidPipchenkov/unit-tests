package net.happiness.unittests.repositories.impl;

import net.happiness.unittests.entities.Event;
import net.happiness.unittests.repositories.EventRepository;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class DefaultInMemoryEventRepository implements EventRepository {

    private final ConcurrentHashMap<Long, Event> storage;

    public DefaultInMemoryEventRepository() {
        storage = new ConcurrentHashMap<>();
    }

    @Override
    public Event findEventById(long id) {
        return storage.get(id);
    }

    @Override
    public void saveEvent(Event event) {
        storage.put(event.getId(), event);
    }

}
