package com.truongpham.event_ticket_platform.controllers;

import com.truongpham.event_ticket_platform.domains.Event;
import com.truongpham.event_ticket_platform.domains.dtos.CreateEventRequestDTO;
import com.truongpham.event_ticket_platform.domains.dtos.CreateEventResponseDTO;
import com.truongpham.event_ticket_platform.domains.requests.CreateEventRequest;
import com.truongpham.event_ticket_platform.mappers.EventMapper;
import com.truongpham.event_ticket_platform.services.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping (path = "/api/v1/events") // su dung events cho 1 tap hop
@RequiredArgsConstructor
public class EventController {

    private final EventMapper eventMapper;
    private final EventService eventService;

    @PostMapping // tao mot event moi vao 1 tap hop events
    ResponseEntity<CreateEventResponseDTO> createEvent (
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

}
