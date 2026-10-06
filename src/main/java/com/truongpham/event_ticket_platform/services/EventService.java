package com.truongpham.event_ticket_platform.services;

import com.truongpham.event_ticket_platform.domains.Event;
import com.truongpham.event_ticket_platform.domains.requests.CreateEventRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


public interface EventService {

    Event creatEvent (UUID organizerId, CreateEventRequest request);

    Page<Event> getListEvent(UUID organizerId, Pageable pageable);

    Optional<Event> getEventForOrganizer (UUID eventId, UUID organizerId);
}
