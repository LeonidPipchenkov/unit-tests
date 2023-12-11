package net.happiness.unittests.dtos.event;

import net.happiness.unittests.entities.Event;

public interface EventDTOBuilder {

    EventDTO fromEvent(Event event);

    Event fromEventDTO(EventDTO eventDTO);

}
