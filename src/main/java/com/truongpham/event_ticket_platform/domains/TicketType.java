package com.truongpham.event_ticket_platform.domains;

import com.truongpham.event_ticket_platform.configs.JpaConfig;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ticket_types")
@EntityListeners(AuditingEntityListener.class)

public class TicketType {

    @Id
    @Column (name = "id", updatable = false, nullable = false)
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    @Column (name = "name", nullable = false)
    private String name;

    @Column (name = "price", nullable = false)
    private Double price;

    @Column (name = "description")
    private String description;

    @Column(name = "ticket_available", nullable = false)
    private Integer totalAvailable;

    @ManyToOne (fetch =  FetchType.LAZY)
    @JoinColumn (name = "event_id")
    private Event event;

    @CreatedDate
    @Column (name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column (name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;


    @OneToMany (mappedBy = "ticketType", cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TicketType that = (TicketType) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(description, that.description) && Objects.equals(totalAvailable, that.totalAvailable) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, description, totalAvailable, createdAt, updatedAt);
    }
}
