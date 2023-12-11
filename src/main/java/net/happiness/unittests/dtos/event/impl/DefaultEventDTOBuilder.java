package net.happiness.unittests.dtos.event.impl;

import net.happiness.unittests.dtos.event.EventDTO;
import net.happiness.unittests.dtos.event.EventDTOBuilder;
import net.happiness.unittests.entities.Event;
import org.springframework.stereotype.Component;

@Component
public class DefaultEventDTOBuilder implements EventDTOBuilder {

    @Override
    public EventDTO fromEvent(Event event) {
        return new EventDTO() {{
            setId(event.getId());
            setName(event.getName());
            setStartDate(event.getStartDate());
            setEndDate(event.getEndDate());
        }};
    }

    @Override
    public Event fromEventDTO(EventDTO eventDTO) {
        return new Event(eventDTO.getId(),
                eventDTO.getName(),
                eventDTO.getStartDate(),
                eventDTO.getEndDate());
    }

}
