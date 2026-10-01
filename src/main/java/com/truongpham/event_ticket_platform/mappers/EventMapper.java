package com.truongpham.event_ticket_platform.mappers;

import com.truongpham.event_ticket_platform.domains.Event;
import com.truongpham.event_ticket_platform.domains.TicketType;
import com.truongpham.event_ticket_platform.domains.dtos.CreateEventRequestDTO;
import com.truongpham.event_ticket_platform.domains.dtos.CreateEventResponseDTO;
import com.truongpham.event_ticket_platform.domains.dtos.CreateTicketTypeRequestDTO;
import com.truongpham.event_ticket_platform.domains.dtos.CreateTicketTypeResponseDTO;
import com.truongpham.event_ticket_platform.domains.requests.CreateEventRequest;
import com.truongpham.event_ticket_platform.domains.requests.CreateTicketTypeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper (componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    CreateEventRequest fromDTO (CreateEventRequestDTO requestDTO);

    CreateTicketTypeRequest fromDTO (CreateTicketTypeRequestDTO requestDTO);

    CreateEventResponseDTO toDTO (Event event);

    CreateTicketTypeResponseDTO toDTO (TicketType ticketType);

}
