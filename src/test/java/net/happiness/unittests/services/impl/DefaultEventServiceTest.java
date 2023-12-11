package net.happiness.unittests.services.impl;

import net.happiness.unittests.entities.Event;
import net.happiness.unittests.repositories.EventRepository;
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
class DefaultEventServiceTest {

    private static final long ID = 1L;

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private DefaultEventService service;

    @Test
    void findEvent_shouldCallRepository() {
        final Event event = mock(Event.class);
        when(eventRepository.findEventById(ID)).thenReturn(event);

        final Event actual = service.findEvent(ID);

        assertNotNull(actual);
        assertEquals(event, actual);
        verify(eventRepository).findEventById(ID);
    }

    @Test
    void saveEvent_shouldCallRepository() {
        final Event event = mock(Event.class);

        service.saveEvent(event);

        verify(eventRepository).saveEvent(event);
    }

}
