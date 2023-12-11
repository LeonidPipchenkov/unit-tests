package net.happiness.unittests.controllers;

import net.happiness.unittests.dtos.event.EventDTO;
import net.happiness.unittests.dtos.event.EventDTOBuilder;
import net.happiness.unittests.entities.Event;
import net.happiness.unittests.services.EventService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventsControllerTest {

    private final static long ID = 1L;

    @Mock
    private EventDTOBuilder eventDTOBuilder;
    @Mock
    private EventService eventService;

    @InjectMocks
    private EventsController controller;

    @Test
    void getEvent() {
        final Event event = mock(Event.class);
        when(eventService.findEvent(ID)).thenReturn(event);
        final EventDTO eventDTO = mock(EventDTO.class);
        when(eventDTOBuilder.fromEvent(event)).thenReturn(eventDTO);

        final EventDTO actual = controller.getEvent(ID);

        assertNotNull(actual);
        assertEquals(eventDTO, actual);
        verify(eventService).findEvent(ID);
        verify(eventDTOBuilder).fromEvent(event);
    }

    @Test
    void saveEvent() {
        final Event event = mock(Event.class);
        final EventDTO eventDTO = mock(EventDTO.class);
        when(eventDTOBuilder.fromEventDTO(eventDTO)).thenReturn(event);

        controller.saveEvent(eventDTO);

        verify(eventDTOBuilder).fromEventDTO(eventDTO);
        verify(eventService).saveEvent(event);
    }

}
