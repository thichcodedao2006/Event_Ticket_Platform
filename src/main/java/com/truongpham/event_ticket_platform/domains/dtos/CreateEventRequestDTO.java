package com.truongpham.event_ticket_platform.domains.dtos;

import com.truongpham.event_ticket_platform.domains.requests.CreateTicketTypeRequest;
import com.truongpham.event_ticket_platform.enums.EventStatusEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventRequestDTO {

    @NotBlank (message = "Event name is required.")
    private String name;

    private LocalDateTime start;

    private LocalDateTime end;

    @NotBlank (message =  "Venue information is required.")
    private String venue;

    private LocalDateTime sales_start;

    private LocalDateTime sales_end;

    @NotNull (message = "Event status is required.")
    private EventStatusEnum status;

    @NotEmpty (message = "Event should have at least 1 ticket type.")
    @Valid
    private List<CreateTicketTypeRequestDTO> ticketTypes = new ArrayList<>();
}
