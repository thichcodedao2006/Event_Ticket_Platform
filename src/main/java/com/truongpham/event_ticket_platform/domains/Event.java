package com.truongpham.event_ticket_platform.domains;


import com.truongpham.event_ticket_platform.enums.EventStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table (name = "events")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Event {

    @Id
    @Column (name = "id", updatable = false, nullable = false)
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    @Column (name = "event_name", nullable = false)
    private String name;

    @Column (name =  "date_start")
    private LocalDateTime start;

    @Column (name = "date_end")
    private LocalDateTime end;

    @Column (name = "venue", nullable = false)
    private String venue;

    @Column (name =  "sales_start")
    private LocalDateTime sales_start;

    @Column (name = "sales_end")
    private LocalDateTime sales_end;

    @Column (name =  "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private EventStatusEnum status;

}
