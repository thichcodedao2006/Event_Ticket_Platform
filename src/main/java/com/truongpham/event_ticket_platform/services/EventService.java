package com.truongpham.event_ticket_platform.services;

import com.truongpham.event_ticket_platform.domains.Event;
import com.truongpham.event_ticket_platform.domains.requests.CreateEventRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;


public interface EventService {

    Event creatEvent (UUID organizerId, CreateEventRequest request);
}
