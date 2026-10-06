package com.truongpham.event_ticket_platform.controllers;

import com.truongpham.event_ticket_platform.domains.Event;
import com.truongpham.event_ticket_platform.domains.dtos.CreateEventRequestDTO;
import com.truongpham.event_ticket_platform.domains.dtos.CreateEventResponseDTO;
import com.truongpham.event_ticket_platform.domains.dtos.GetEventDetailResponseDTO;
import com.truongpham.event_ticket_platform.domains.dtos.GetListEventResponseDTO;
import com.truongpham.event_ticket_platform.domains.requests.CreateEventRequest;
import com.truongpham.event_ticket_platform.mappers.EventMapper;
import com.truongpham.event_ticket_platform.services.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping (path = "/api/v1/events") // su dung events cho 1 tap hop
@RequiredArgsConstructor
public class EventController {

    private final EventMapper eventMapper;
    private final EventService eventService;

    @PostMapping // tao mot event moi vao 1 tap hop events
    public ResponseEntity<CreateEventResponseDTO> createEvent (
            @AuthenticationPrincipal Jwt jwt,
            @Valid @RequestBody CreateEventRequestDTO request

            )
    {
        CreateEventRequest createEventRequest = eventMapper.fromDTO(request);
        UUID userID = UUID.fromString(jwt.getSubject());
        Event eventCreated = eventService.creatEvent(userID, createEventRequest);
        CreateEventResponseDTO responseDTO = eventMapper.toDTO(eventCreated);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<GetListEventResponseDTO>> listEvent (
            @AuthenticationPrincipal Jwt jwt,
            Pageable pageable
    )
    {
        UUID userId = parseUserId(jwt);
        Page<Event> events = eventService.getListEvent(userId, pageable);
        return ResponseEntity.ok(events.map(eventMapper::toListEventDTO));
    }

    @GetMapping (path = "/{eventId}")
    public ResponseEntity<GetEventDetailResponseDTO> getEvent(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable String eventId
    )
    {
        UUID organizerId = parseUserId(jwt);
        UUID eventID = UUID.fromString(eventId);
        Optional<Event> event = eventService.getEventForOrganizer(eventID, organizerId);
        return event.map(eventMapper::toEventDetailDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    private UUID parseUserId(Jwt jwt)
    {
        return UUID.fromString(jwt.getSubject());
    }

}
