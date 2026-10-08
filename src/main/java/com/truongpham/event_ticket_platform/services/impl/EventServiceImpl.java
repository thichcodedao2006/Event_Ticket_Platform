package com.truongpham.event_ticket_platform.services.impl;

import com.truongpham.event_ticket_platform.domains.Event;
import com.truongpham.event_ticket_platform.domains.TicketType;
import com.truongpham.event_ticket_platform.domains.User;
import com.truongpham.event_ticket_platform.domains.requests.CreateEventRequest;
import com.truongpham.event_ticket_platform.domains.requests.UpdateEventRequest;
import com.truongpham.event_ticket_platform.exceptions.UserNotFoundException;
import com.truongpham.event_ticket_platform.repositories.EventRepository;
import com.truongpham.event_ticket_platform.repositories.UserRepository;
import com.truongpham.event_ticket_platform.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;


    @Override
    public Event creatEvent(UUID organizerId, CreateEventRequest request) {
        User organizer = userRepository.findById(organizerId).
                orElseThrow(() -> new UserNotFoundException(
                        String.format("User with ID '%s' not found", organizerId )

                ));
        // ta co request chua cac TicketTypeRequest
        // can chuyen Request nay sang TicketType
        Event event = new Event();
        List<TicketType> ticketTypes = request.getTicketTypes().stream().map(
                ticketTypeRequest ->
                {
                    TicketType ticketType = new TicketType();
                    ticketType.setName(ticketTypeRequest.getName());
                    ticketType.setDescription(ticketTypeRequest.getDescription());
                    ticketType.setPrice(ticketTypeRequest.getPrice());
                    ticketType.setTotalAvailable(ticketTypeRequest.getTotalAvailable());
                    ticketType.setEvent(event);
                    return ticketType;
                }
        ).toList();


        event.setName(request.getName());
        event.setStart(request.getStart());
        event.setEnd(request.getEnd());
        event.setVenue(request.getVenue());
        event.setSales_start(request.getSales_start());
        event.setSales_end(request.getSales_end());
        event.setStatus(request.getStatus());
        event.setOrganizer(organizer);
        event.setTicketTypes(ticketTypes);
        return eventRepository.save(event);

    }

    @Override
    public Page<Event> getListEvent(UUID organizerId, Pageable pageable) {
        return eventRepository.findByOrganizerId(organizerId, pageable);
    }

    @Override
    public Optional<Event> getEventForOrganizer(UUID eventId, UUID organizerId) {
        return eventRepository.findByIdAndOrganizerId(eventId, organizerId);
    }

    @Override
    public Event updateEventForOrganizer(UUID organizerId, UUID eventId, UpdateEventRequest request) {
        return null;
    }
}
