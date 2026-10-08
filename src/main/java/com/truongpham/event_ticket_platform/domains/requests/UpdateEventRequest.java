package com.truongpham.event_ticket_platform.domains.requests;

import com.truongpham.event_ticket_platform.enums.EventStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEventRequest {

    private UUID id; // this id is used to check with the id provided in the URL

    private String name;

    private LocalDateTime start;

    private LocalDateTime end;

    private String venue;

    private LocalDateTime sales_start;

    private LocalDateTime sales_end;

    private EventStatusEnum status;

    private List<UpdateTicketTypeRequest> ticketTypes = new ArrayList<>();
}
