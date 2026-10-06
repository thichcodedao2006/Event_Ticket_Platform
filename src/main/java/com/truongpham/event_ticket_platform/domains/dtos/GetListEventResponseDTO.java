package com.truongpham.event_ticket_platform.domains.dtos;

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
public class GetListEventResponseDTO {

    private UUID id;
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
    private String venue;
    private LocalDateTime sales_start;
    private LocalDateTime sales_end;
    private EventStatusEnum status;

    private List<GetListEventTicketTypeResponeDTO> ticketTypes = new ArrayList<>();
}
